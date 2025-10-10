package com.scorenerds.ScoreNerds.controller.score;

import com.scorenerds.ScoreNerds.service.score.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreResource {

    private ScoreService scoreService;

    public ScoreResource(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public ResponseEntity<?> getAllScores() {
        return new ResponseEntity<>(scoreService.getAllScores(), HttpStatus.OK);
    }

}
