package com.example.demo.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "api/scheduler")
public class SchedulerController {
    
    private static Dictionary<String, Appointment> appointments;
    private final RestTemplate restTemplate;

    public SchedulerController(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @CrossOrigin
    @GetMapping("/getData")
    public Object getData(
        @RequestHeader(name = "Authorization", required = true) 
        String auth
    ) {
        String url = "https://api.yelp.com/v3/businesses/search?categories=bakeries&location=NYC";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(auth);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

        ResponseEntity<Object> response = this.restTemplate.exchange(
            url, 
            HttpMethod.GET,
            request,
            Object.class
        );

        return response.getBody();
    }


}
