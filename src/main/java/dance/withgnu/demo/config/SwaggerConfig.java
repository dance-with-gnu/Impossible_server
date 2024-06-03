//package dance.withgnu.demo.config;
//
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//
//    // 모든 경로 포함하는 기본 그룹
////    @Bean
////    public GroupedOpenApi publicApi() {
////        return GroupedOpenApi.builder()
////                .group("public")
////                .pathsToMatch("/**")
////                .build();
////    }
//
//    // 하위 경로 그룹
//    @Bean
//    public GroupedOpenApi communityApi() {
//        return GroupedOpenApi.builder()
//                .group("community")
//                .pathsToMatch("/community/**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi poseApi() {
//        return GroupedOpenApi.builder()
//                .group("pose")
//                .pathsToMatch("/pose/**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi dashboardApi() {
//        return GroupedOpenApi.builder()
//                .group("dashboard")
//                .pathsToMatch("/dashboard/**")
//                .build();
//    }
////
////    @Bean
////    public GroupedOpenApi videoApi() {
////        return GroupedOpenApi.builder()
////                .group("video")
////                .pathsToMatch("/video/**")
////                .build();
////    }
//}
