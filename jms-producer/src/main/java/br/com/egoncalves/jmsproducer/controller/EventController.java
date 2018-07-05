package br.com.egoncalves.jmsproducer.controller;

import br.com.egoncalves.jmsproducer.model.Event;
import br.com.egoncalves.jmsproducer.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity newEvent(@RequestBody Event event){

        this.eventService.sendEvent(event);

        return ResponseEntity.ok(event);
    }
}
