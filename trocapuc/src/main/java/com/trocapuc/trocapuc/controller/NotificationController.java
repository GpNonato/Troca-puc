package com.trocapuc.trocapuc.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trocapuc.trocapuc.model.Proposal;
import com.trocapuc.trocapuc.model.User;
import com.trocapuc.trocapuc.service.ProposalService;
import com.trocapuc.trocapuc.service.UserService;


@Controller
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private UserService userService;

    @GetMapping("/sent")
    public String showNotificationSent(@RequestParam(required = false) String status, Model model, Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());

        List<Proposal> proposals = proposalService.getProposalsBySenderAndStatus(currentUser.getId(), status);
        model.addAttribute("proposals", proposals);
        return "notificationsent";
    }

    @GetMapping("/received")
    public String showNotificationReceived(@RequestParam(required = false) String status, Model model, Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());

        List<Proposal> proposals = proposalService.getProposalsByReceiverAndStatus(currentUser.getId(), status);
        model.addAttribute("proposals", proposals);
        return "notificationreceived";
    }
}
