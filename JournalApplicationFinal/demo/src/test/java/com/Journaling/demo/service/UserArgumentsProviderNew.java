// package com.Journaling.demo.service;

// import com.Journaling.controller.demo.entity.User;
// import org.junit.jupiter.api.extension.ExtensionContext;
// import org.junit.jupiter.params.provider.Arguments;
// import org.junit.jupiter.params.provider.ArgumentsProvider;


// import java.util.stream.Stream;

// public class UserArgumentsProviderNew implements ArgumentsProvider {

//     @Override
//     public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
//         return Stream.of(
//                 Arguments.of(User.builder().userName("rishita").password("rishita").build()),
//                 Arguments.of(User.builder().userName("aashish").password("aashish").build())
//         );
//     }
// }
