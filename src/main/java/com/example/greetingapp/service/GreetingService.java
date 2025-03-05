//package com.example.greetingapp.service;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class GreetingService {
//    public String getGreetingMessage() {
//        return "{ \"message\": \"Hello from BridgeLabz\" }";
//    }
//}
//
//package com.example.greetingapp.service;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class GreetingService {
//    public String getPersonalizedGreeting(String firstName, String lastName) {
//        if (firstName != null && lastName != null) {
//            return "{ \"message\": \"Hello " + firstName + " " + lastName + " from BridgeLabz\" }";
//        } else if (firstName != null) {
//            return "{ \"message\": \"Hello " + firstName + " from BridgeLabz\" }";
//        } else if (lastName != null) {
//            return "{ \"message\": \"Hello " + lastName + " from BridgeLabz\" }";
//        } else {
//            return "{ \"message\": \"Hello World from BridgeLabz\" }";
//        }
//    }
//}
//
//package com.example.greetingapp.service;
//
//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.repository.GreetingRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GreetingService {
//    private final GreetingRepository greetingRepository;
//
//    public GreetingService(GreetingRepository greetingRepository) {
//        this.greetingRepository = greetingRepository;
//    }
//
//    public Greeting saveGreeting(String firstName, String lastName) {
//        String message;
//        if (firstName != null && lastName != null) {
//            message = "Hello " + firstName + " " + lastName + " from BridgeLabz";
//        } else if (firstName != null) {
//            message = "Hello " + firstName + " from BridgeLabz";
//        } else if (lastName != null) {
//            message = "Hello " + lastName + " from BridgeLabz";
//        } else {
//            message = "Hello World from BridgeLabz";
//        }
//        Greeting greeting = new Greeting(message);
//        return greetingRepository.save(greeting);
//    }
//}

//
//package com.example.greetingapp.service;
//
//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.repository.GreetingRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class GreetingService {
//    private final GreetingRepository greetingRepository;
//
//    public GreetingService(GreetingRepository greetingRepository) {
//        this.greetingRepository = greetingRepository;
//    }
//
//    public Optional<Greeting> findGreetingById(Long id) {
//        return greetingRepository.findById(id);
//    }
//}


//fetch all
//package com.example.greetingapp.service;
//
//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.repository.GreetingRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class GreetingService {
//    private final GreetingRepository greetingRepository;
//
//    public GreetingService(GreetingRepository greetingRepository) {
//        this.greetingRepository = greetingRepository;
//    }
//
//    public List<Greeting> getAllGreetings() {
//        return greetingRepository.findAll();
//    }
//}

// to update  a greeting
//package com.example.greetingapp.service;
//
//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.repository.GreetingRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class GreetingService {
//    private final GreetingRepository greetingRepository;
//
//    public GreetingService(GreetingRepository greetingRepository) {
//        this.greetingRepository = greetingRepository;
//    }
//
//    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
//        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
//        if (existingGreeting.isPresent()) {
//            Greeting greeting = existingGreeting.get();
//            greeting.setMessage(newMessage);
//            return Optional.of(greetingRepository.save(greeting));
//        }
//        return Optional.empty();
//    }
//}
// to delete a greeting
//package com.example.greetingapp.service;
//
//import com.example.greetingapp.repository.GreetingRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GreetingService {
//    private final GreetingRepository greetingRepository;
//
//    public GreetingService(GreetingRepository greetingRepository) {
//        this.greetingRepository = greetingRepository;
//    }
//
//    public boolean deleteGreeting(Long id) {
//        if (greetingRepository.existsById(id)) {
//            greetingRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//}

package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // UC2: Return Simple Greeting Message
    public String getGreetingMessage() {
        return "{ \"message\": \"Hello from BridgeLabz\" }";
    }

    // UC3: Personalized Greeting Message
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "{ \"message\": \"Hello " + firstName + " " + lastName + " from BridgeLabz\" }";
        } else if (firstName != null) {
            return "{ \"message\": \"Hello " + firstName + " from BridgeLabz\" }";
        } else if (lastName != null) {
            return "{ \"message\": \"Hello " + lastName + " from BridgeLabz\" }";
        } else {
            return "{ \"message\": \"Hello World from BridgeLabz\" }";
        }
    }

    // UC4: Save Greeting Message
    public Greeting saveGreeting(String firstName, String lastName) {
        String message = getPersonalizedGreeting(firstName, lastName);
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    // UC5: Find Greeting by ID
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // UC6: Get All Greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // UC7: Update Greeting Message
    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return Optional.of(greetingRepository.save(greeting));
        }
        return Optional.empty();
    }

    // UC8: Delete Greeting Message
    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
