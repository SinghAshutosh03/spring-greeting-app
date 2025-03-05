package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC1: Basic Hello Message
    @GetMapping("/hello")
    public String sayHello() {
        return "{ \"message\": \"Hello from BridgeLabz\" }";
    }

    // UC2: Use Service Layer for Greeting
    @GetMapping("/hello/service")
    public String sayHelloFromService() {
        return greetingService.getGreetingMessage();
    }

    // UC3: Personalized Greeting Message
    @GetMapping("/hello/personalized")
    public String sayHello(@RequestParam(required = false) String firstName,
                           @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // UC4: Save Greeting Message
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        return greetingService.saveGreeting(firstName, lastName);
    }

    // UC5: Find Greeting by ID
    @GetMapping("/find/{id}")
    public Optional<Greeting> findGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    // UC6: List All Greetings
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC7: Update Greeting Message
    @PutMapping("/update/{id}")
    public Optional<Greeting> updateGreeting(@PathVariable Long id, @RequestParam String newMessage) {
        return greetingService.updateGreeting(id, newMessage);
    }

    // UC8: Delete Greeting Message
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        boolean isDeleted = greetingService.deleteGreeting(id);
        if (isDeleted) {
            return "Greeting with ID " + id + " deleted successfully.";
        } else {
            return "Greeting with ID " + id + " not found.";
        }
    }
}
