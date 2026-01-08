package com.trocapuc.trocapuc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trocapuc.trocapuc.model.Proposal;
import com.trocapuc.trocapuc.model.ProposalStatus;
import com.trocapuc.trocapuc.model.User;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByItemOwner(User owner);
    List<Proposal> findByItemInterested(User interested);

    List<Proposal> findByItemInterestedId(Long interestedId);
    List<Proposal> findByItemOwnerId(Long ownerId);
    List<Proposal> findByItemInterestedIdAndStatus(Long interestedId, ProposalStatus status);
    List<Proposal> findByItemOwnerIdAndStatus(Long ownerId, ProposalStatus status);

    Long countByStatus(String status);
}