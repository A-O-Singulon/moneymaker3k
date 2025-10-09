package com.scorenerds.ScoreNerds.integration.external.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EspnApiService {

    private static final String ESPN_API_ADDRESS = "https://site.api.espn.com/apis/site/v2/sports/soccer/eng.1/scoreboard";

    public EspnApiService() {}

    public Object getEspnApi() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(ESPN_API_ADDRESS, String.class);

            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
