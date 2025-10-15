package com.scorenerds.ScoreNerds.scheduled;

import com.scorenerds.ScoreNerds.dto.EspnDataDTO;
import com.scorenerds.ScoreNerds.integration.external.controller.EspnApiController;
import com.scorenerds.ScoreNerds.integration.external.service.EspnApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EspnApiScheduled {

    @Autowired
    private EspnApiController espnApiController;

    @Autowired
    private EspnApiService espnApiService;

    @Scheduled(cron = "0 0 9 * * MON")
    public void espnApiScheduled() {
        EspnDataDTO espnDataDTO = espnApiController.getEspnApiData();
        espnApiService.fillDatabase(espnDataDTO);
    }

}
