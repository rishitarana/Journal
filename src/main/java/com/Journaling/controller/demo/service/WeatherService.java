package com.Journaling.controller.demo.service;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Journaling.controller.demo.api.response.WeatherResponse;
// import com.Journaling.controller.demo.api.response.WeatherResponse;
import com.Journaling.controller.demo.cache.AppCache;
import com.Journaling.controller.demo.constants.Placeholders;
import com.Journaling.controller.demo.entity.User;

@Service
public class WeatherService {



    // @Value("${weather.api.key}")
    // private String apiKey;
    // private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";



    @Value("${weather.api.key}")
    private String apiKey;
    // private static final String apiKey = "7ee259d1d65abbad70b1cd943af67c2b";

    //    private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;


    @Autowired
    private RedisService redisService;


    public  WeatherResponse getWeather(String city){

        WeatherResponse weatherResponse=redisService.get("weather_of_ "+city,WeatherResponse.class);

        if(weatherResponse!=null){
            return weatherResponse;
        }
        else{
            String finalAPI=appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY,city).replace(Placeholders.API_KEY, apiKey);


        ResponseEntity<WeatherResponse> response=restTemplate.exchange(finalAPI, HttpMethod.GET,null,WeatherResponse.class);

        WeatherResponse body=response.getBody();

        if(body!=null){
            redisService.set("weather_of_"+city,body,300l);
        }
        return body;


        }
        
       

    }



    // @Autowired
    // private RestTemplate restTemplate;

    // @Autowired
    // private AppCache appCache;


    // public WeatherResponse getWeather(String city) {
    //     // String finalAPI = appCache.appCache.get("AppCache.keys.WEATHER_API.toString()").replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);
    //     String finalAPI = appCache.appCache.get("WEATHER_API").replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);


        




    //     ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, null, WeatherResponse.class);
    //     WeatherResponse body=response.getBody();
    //     return body;

    // }
}
