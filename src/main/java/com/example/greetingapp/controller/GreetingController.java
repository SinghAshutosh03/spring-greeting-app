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

//package com.example.greetingapp.controller;
//package com.example.greetingapp.service;

//
//import com.example.greetingapp.service.GreetingService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/greeting")
//public class GreetingController {
//
//    private final GreetingService greetingService;
//
//    public GreetingController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }
//
//    @GetMapping("/hello")
//    public String sayHello() {
//        return greetingService.getGreetingMessage();
//    }
//}
//
//package com.example.greetingapp.controller;
//
//import com.example.greetingapp.service.GreetingService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/greeting")
//public class GreetingController {
//
//    private final GreetingService greetingService;
//
//    public GreetingController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }
//
//    @GetMapping("/hello")
//    public String sayHello(@RequestParam(required = false) String firstName,
//                           @RequestParam(required = false) String lastName) {
//        return greetingService.getPersonalizedGreeting(firstName, lastName);
//    }
//}
//
//package com.example.greetingapp.controller;
//
//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.service.GreetingService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/greeting")
//public class GreetingController {
//    private final GreetingService greetingService;
//
//    public GreetingController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }
//
//    @PostMapping("/save")
//    public Greeting saveGreeting(@RequestParam(required = false) String firstName,
//                                 @RequestParam(required = false) String lastName) {
//        return greetingService.saveGreeting(firstName, lastName);
//    }
//}
//
//package com.example.greetingapp.controller;
//
//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.service.GreetingService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/greeting")
//public class GreetingController {
//    private final GreetingService greetingService;
//
//    public GreetingController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }
//
//    @GetMapping("/find/{id}")
//    public Optional<Greeting> findGreetingById(@PathVariable Long id) {
//        return greetingService.findGreetingById(id);
//    }
//}

// to gt req for all
//package com.example.greetingapp.controller;
//
//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.service.GreetingService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/greeting")
//public class GreetingController {
//    private final GreetingService greetingService;
//
//    public GreetingController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }
//
//    @GetMapping("/all")
//    public List<Greeting> getAllGreetings() {
//        return greetingService.getAllGreetings();
//    }
//}

// to handle put request for updating a greeting
package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PutMapping("/update/{id}")
    public Optional<Greeting> updateGreeting(@PathVariable Long id, @RequestParam String newMessage) {
        return greetingService.updateGreeting(id, newMessage);
    }
}
