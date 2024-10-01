package com.example.tektokronik.controller;

import com.example.tektokronik.model.EmergencyTeam;
import com.example.tektokronik.service.EmergencyTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emergency-teams")
public class EmergencyTeamController {

    @Autowired
    private EmergencyTeamService teamService;

    @PostMapping
    public ResponseEntity<EmergencyTeam> createTeam(@Valid @RequestBody EmergencyTeam team) {
        EmergencyTeam createdTeam = teamService.createTeam(team);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyTeam> getTeamById(@PathVariable Integer id) {
        return teamService.getTeamById(id)
                .map(team -> new ResponseEntity<>(team, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<EmergencyTeam> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyTeam> updateTeam(@PathVariable Integer id, @Valid @RequestBody EmergencyTeam teamDetails) {
        EmergencyTeam updatedTeam = teamService.updateTeam(id, teamDetails);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
