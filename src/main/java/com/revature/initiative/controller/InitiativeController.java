package com.revature.initiative.controller;

import com.revature.initiative.dto.InitiativeDTO;
import com.revature.initiative.service.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InitiativeController {

    private InitiativeService initiativeService;

    @Autowired
    public InitiativeController(InitiativeService initiativeService) {
        this.initiativeService = initiativeService;
    }

    @PostMapping("initiative")
    public ResponseEntity<InitiativeDTO> createInitiative(@RequestBody InitiativeDTO initiativeDTO) {
        return ResponseEntity.ok(initiativeService.addInitiative(initiativeDTO));
    }

    @GetMapping("initiatives")
    public ResponseEntity<List<InitiativeDTO>> getAllInitiatives() {
        return ResponseEntity.ok(initiativeService.getInitiatives());
    }
}
