package com.example.tektokronik.service;

import com.example.tektokronik.model.EmergencyTeam;
import com.example.tektokronik.repository.EmergencyTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergencyTeamService {

    @Autowired
    private EmergencyTeamRepository teamRepository;

    public EmergencyTeam createTeam(EmergencyTeam team) {
        return teamRepository.save(team);
    }

    public Optional<EmergencyTeam> getTeamById(Integer id) {
        return teamRepository.findById(id);
    }

    public List<EmergencyTeam> getAllTeams() {
        return teamRepository.findAll();
    }

    public EmergencyTeam updateTeam(Integer id, EmergencyTeam teamDetails) {
        return teamRepository.findById(id)
                .map(team -> {
                    team.setTeamName(teamDetails.getTeamName());
                    team.setContactDetails(teamDetails.getContactDetails());
                    team.setAssignedRegion(teamDetails.getAssignedRegion());
                    team.setCapacity(teamDetails.getCapacity());
                    team.setStatus(teamDetails.getStatus());
                    return teamRepository.save(team);
                })
                .orElseThrow(() -> new RuntimeException("Team not found with id " + id));
    }

    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }
}
