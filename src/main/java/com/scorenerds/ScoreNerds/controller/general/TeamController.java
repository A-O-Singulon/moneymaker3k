package com.scorenerds.ScoreNerds.controller.general;

import com.scorenerds.ScoreNerds.dto.TeamDTO;
import com.scorenerds.ScoreNerds.service.general.TeamService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        return new ResponseEntity<>(this.teamService.getAllTeams(), HttpStatus.OK);
    }

}
