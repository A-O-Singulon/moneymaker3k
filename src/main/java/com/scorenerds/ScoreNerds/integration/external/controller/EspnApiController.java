package com.scorenerds.ScoreNerds.integration.external.controller;

import com.scorenerds.ScoreNerds.dto.EspnDataDTO;
import com.scorenerds.ScoreNerds.integration.external.service.EspnApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/integration/espn")
public class EspnApiController {

    private static final String ESPN_API_ADDRESS = "https://site.api.espn.com/apis/site/v2/sports/soccer/eng.1/scoreboard";

    private EspnApiService espnApiService;

    public EspnApiController(EspnApiService espnApiService) {
        this.espnApiService = espnApiService;
    }

    @GetMapping
    public ResponseEntity<Object> getEspnApi() {
        try {
            RestTemplate restTemplate = new RestTemplate();
//            ResponseEntity<String> response = restTemplate.getForEntity(ESPN_API_ADDRESS, String.class);
            ResponseEntity<EspnDataDTO> response = restTemplate.getForEntity(ESPN_API_ADDRESS, EspnDataDTO.class);

            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EspnDataDTO getEspnApiData() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(ESPN_API_ADDRESS, EspnDataDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}