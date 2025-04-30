package com.Journaling.controller.demo.scheduler;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Journaling.controller.demo.Repository.UserRepositoryImpl;
import com.Journaling.controller.demo.cache.AppCache;
import com.Journaling.controller.demo.entity.JournalEntry;
import com.Journaling.controller.demo.entity.User;
import com.Journaling.controller.demo.enums.Sentiment;
import com.Journaling.controller.demo.service.EmailService;
// import com.Journaling.controller.demo.service.SentimentAnalysisService;

@Component
public class UserScheduler {


    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    // @Autowired
    // private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;


    // @Scheduled(cron = "0 0 9 * * SUN")
    // @Scheduled(cron = "0 * * ? * *")
    public void fetchUsersAndSendMail(){
        List<User> users=userRepository.getUsersForSA();
        for(User user: users){
            List<JournalEntry> journalEntries=user.getJournalEntries();

            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getSentiment()).collect(Collectors.toList());

            
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for (Sentiment sentiment : sentiments) {
                if (sentiment != null)
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
            }
            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }

            if(mostFrequentSentiment!=null){
                emailService.sendEmail(user.getEmail(), "Sentiment for last 7 days", mostFrequentSentiment.toString());
            }
        }

    }

    @Scheduled(cron="0 0/10 * ? * *")
    public void clearAppCache(){
        appCache.init();
    }

}
