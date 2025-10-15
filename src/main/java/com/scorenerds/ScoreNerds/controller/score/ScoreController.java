package com.scorenerds.ScoreNerds.controller.score;

import com.scorenerds.ScoreNerds.scheduled.EspnApiScheduled;
import com.scorenerds.ScoreNerds.service.score.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private ScoreService scoreService;
    private EspnApiScheduled espnApiScheduled;

    public ScoreController(ScoreService scoreService, EspnApiScheduled espnApiScheduled) {
        this.scoreService = scoreService;
        this.espnApiScheduled = espnApiScheduled;
    }

    @GetMapping
    public ResponseEntity<?> getAllScores() {
        return new ResponseEntity<>(scoreService.getAllScores(), HttpStatus.OK);
    }

    @GetMapping("/manual-hit")
    public void getScoresManualHit() {
        espnApiScheduled.espnApiScheduled();
    }

}
