package stream.arrays.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stream.arrays.backend.domain.Subscriber;
import stream.arrays.backend.services.interfaces.SubscriberRepository;

import java.util.List;

@RestController
@RequestMapping("/sub")
public class SubscriberAPIController {
    @Autowired
    SubscriberRepository subscriberRepository;

    @PostMapping
    public boolean addSubscriber(@RequestBody Subscriber payload){
        Subscriber finalSub = subscriberRepository.findTopByOrderByIdDesc();
        payload.setId((payload.getId() > 0 ? payload.getId(): finalSub.getId() + 1));
        payload.setProcessed(false);
        subscriberRepository.save(payload);
        return false;
    }

    @GetMapping
    public List<Subscriber> getAllSubscribers(){
        return subscriberRepository.findAll();
    }
}
