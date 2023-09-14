package com.ns.springboothibernateenvers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringBootHibernateEnversApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateEnversApplication.class, args);
    }


//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootHibernateEnversApplication.class, args);
//    }
//
//    @Bean
//    ApplicationRunner init(UserRepository userRepository) {
//        return (ApplicationArguments args) -> dataSetup(userRepository);
//    }
//    private void dataSetup(UserRepository userRepository) {
//
//        User userDetails = new User(1, "NIRAJ", "SONAWANE");
//
//        userRepository.save(userDetails);      // Create

//        userDetails.setFirstName("Updated Name");
//        userRepository.save(userDetails); // Update-1
//
//        userDetails.setLastName("Updated Last name"); // Update-2
//        userRepository.save(userDetails);
//
//        userRepository.delete(userDetails); // Delete
//    }

}
