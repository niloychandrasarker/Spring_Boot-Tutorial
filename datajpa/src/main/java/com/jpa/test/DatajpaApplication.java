package com.jpa.test;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DatajpaApplication {

    public static void main(String[] args) {
       ApplicationContext contest = SpringApplication.run(DatajpaApplication.class, args);

        UserRepository userRepository = contest.getBean(UserRepository.class);

//        User user = new User();
//        user.setName("Niloy Sarker");
//        user.setCity("dhaka");
//        user.setStatus("I am a Preogrammer");
//        User user1 = userRepository.save(user);

//        User user1 = new User();
//        user1.setName("Jack");
//        user1.setCity("america");
//        user1.setStatus("he is java programmer");
//
//        User user2 = new User();
//        user2.setName("joni sikdar");
//        user2.setCity("india");
//        user2.setStatus("he is python programmer");
//
//        List<User> users = List.of(user1, user2);
//        Iterable<User> resiltUser = userRepository.saveAll(users);
//
//        resiltUser.forEach(System.out::println);

        //update thw user of id 2
//        Optional<User> optional = userRepository.findById(2);
//        User user = optional.get();
//        user.setName("Omrit");
//        User result = userRepository.save(user);
//
//        System.out.println(result);

        // Find All

//        userRepository.deleteById(52);
//        System.out.println("deleted");
//
//        Iterable<User> users = userRepository.findAll();
//        users.forEach(System.out::println);
//
//          List<User> users = userRepository.findByName("Niloy Sarker");
//
//          users.forEach(System.out::println);

        List<User> users = userRepository.getAllUsers();
        users.forEach(System.out::println);
        System.out.println("done");
    }

}
