package com.sagittarius.donations.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sagittarius.donations.model.dto.DonationDto;
import com.sagittarius.donations.service.donation.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LEVON
 */
@Controller
public class DonationController {

    @Autowired
    private DonationService donationService;

    @MessageMapping("/donations")
    @SendTo("/topic/donations")
    public String createDonation(DonationDto donationDto)  {
        return donationService.create(donationDto);
    }

    @GetMapping("/donations")
    @ResponseBody
    public List<DonationDto> getAllDonations(){
        return donationService.getAll();
    }
}
