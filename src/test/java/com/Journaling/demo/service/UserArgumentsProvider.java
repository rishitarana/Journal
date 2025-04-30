package com.Journaling.demo.service;

import com.Journaling.controller.demo.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;


import java.util.stream.Stream;

public class UserArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().userName("edeveve").password("jijij").build()),
                Arguments.of(User.builder().userName("aaaaa").password("aappp").build())
        );
    }
}


// package com.Journaling.demo.service;




// import org.junit.jupiter.api.extension.ExtensionContext;
// import org.junit.jupiter.params.provider.Arguments;
// import org.junit.jupiter.params.provider.ArgumentsProvider;
// import org.springframework.security.core.userdetails.User;

// import java.util.stream.Stream;

// public class UserArgumentsProvider implements ArgumentsProvider {

//     @Override
//     public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
//         return Stream.of(
//                 Arguments.of(User.builder().username("ededede").password("shyam").build()),
//                 Arguments.of(User.builder().username("ededed").password("").build())
//         );
//     }
// }
