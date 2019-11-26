package com.sagittarius.donations.controller;

import com.sagittarius.donations.model.Response;
import com.sagittarius.donations.model.dto.DonationDto;
import com.sagittarius.donations.service.donation.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author LEVON
 */
@Controller
public class DonationController {

    @Autowired
    private DonationService donationService;

    @MessageMapping("/donations")
    @SendTo("/topic/donations")
    Response createDonation(DonationDto donationDto){
        return new Response(donationService.create(donationDto).toString());
    }
}
