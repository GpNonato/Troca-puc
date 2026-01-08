package com.trocapuc.trocapuc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trocapuc.trocapuc.dto.ProposalDTO;
import com.trocapuc.trocapuc.model.ProposalStatus;
import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.repository.UserRepository;
import com.trocapuc.trocapuc.service.ProposalService;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<String> createProposal(@RequestBody ProposalDTO proposalDTO, Principal principal) {
        if (proposalDTO.getItemId() == null || proposalDTO.getDescription() == null) {
            return ResponseEntity.badRequest().body("Missing required fields.");
        }

        User currentUser = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        proposalService.createProposal(
                proposalDTO.getItemId(),
                currentUser.getId(),
                proposalDTO.getDescription(),
                proposalDTO.getPrice());

        return ResponseEntity.ok("Proposal created successfully");
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<String> updateProposalStatus(@PathVariable Long id, @RequestParam String status) {
        // Lógica para atualizar o status
        try {
            // Valide o status e atualize no banco de dados
            ProposalStatus newStatus = ProposalStatus.valueOf(status);
            proposalService.updateStatus(id, newStatus);
            return ResponseEntity.ok("Status updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid status");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
