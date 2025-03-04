//package com.example.greetingapp.controller;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/greeting")
//public class GreetingController {
//
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "{ \"message\": \"Hello from BridgeLabz\" }";
//    }
//}

package com.example.greetingapp.controller;
//package com.example.greetingapp.service;


import com.example.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return greetingService.getGreetingMessage();
    }
}
