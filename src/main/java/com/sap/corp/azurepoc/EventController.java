package com.sap.corp.azurepoc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @RequestMapping("/storeEvent")
    public String storeEvent(@RequestParam(value = "eventType") String eventType) {

        /*
        Event Type 1 = departure
        Event Type 2 = arrival

        Business Partner 1 = Bosch
        Business Partner 2 = Daimler
         */
        return "eventType " + eventType;
    }

}