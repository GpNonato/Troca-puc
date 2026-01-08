package com.trocapuc.trocapuc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trocapuc.trocapuc.model.Item;
import com.trocapuc.trocapuc.model.Proposal;
import com.trocapuc.trocapuc.model.ProposalStatus;
import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.repository.ItemRepository;
import com.trocapuc.trocapuc.repository.ProposalRepository;
import com.trocapuc.trocapuc.repository.UserRepository;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    public Proposal createProposal(Long itemId, Long interestedUserId, String description, Double price) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        User owner = item.getOwner();

        // Impedir propostas para itens do próprio usuário
        if (owner.getId().equals(interestedUserId)) {
            throw new RuntimeException("You cannot propose for your own item.");
        }

        User interested = userRepository.findById(interestedUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Proposal proposal = new Proposal();
        proposal.setItem(item);
        proposal.setItemOwner(owner);
        proposal.setItemInterested(interested);
        proposal.setDescription(description);
        proposal.setPrice(price);
        proposal.setStatus(ProposalStatus.NOT_UPDATED);

        return proposalRepository.save(proposal);
    }

    public List<Proposal> getProposalsBySenderAndStatus(Long senderId, String status) {
        if (status != null) {
            return proposalRepository.findByItemInterestedIdAndStatus(senderId, ProposalStatus.valueOf(status));
        }
        return proposalRepository.findByItemInterestedId(senderId);
    }

    public List<Proposal> getProposalsByReceiverAndStatus(Long receiverId, String status) {
        if (status != null) {
            return proposalRepository.findByItemOwnerIdAndStatus(receiverId, ProposalStatus.valueOf(status));
        }
        return proposalRepository.findByItemOwnerId(receiverId);
    }

    public void updateStatus(Long id, ProposalStatus newStatus) {
        Proposal proposal = proposalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));

        // Verificar os campos obrigatórios antes de salvar
        if (proposal.getDescription() == null || proposal.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description is required.");
        }

        proposal.setStatus(newStatus);
        proposalRepository.save(proposal);
    }
}
