package com.scorenerds.ScoreNerds.integration.external.controller;

import com.scorenerds.ScoreNerds.integration.external.service.EspnApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/integration/espn")
public class EspnApiResource {

    private EspnApiService espnApiService;

    public  EspnApiResource(EspnApiService espnApiService) {
        this.espnApiService = espnApiService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getEspn() {
        return new ResponseEntity<>(espnApiService.getEspnApi(), HttpStatus.OK);
    }

}