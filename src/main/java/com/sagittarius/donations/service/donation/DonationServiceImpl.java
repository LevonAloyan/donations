package com.sagittarius.donations.service.donation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagittarius.donations.model.dto.DonationDto;
import com.sagittarius.donations.persistance.entity.Donation;
import com.sagittarius.donations.persistance.repository.donation.DonationRepository;
import com.sagittarius.donations.service.donation.mapper.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LEVON
 */
@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationMapper donationMapper;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String create(DonationDto donationDto)  {

        Donation donation = donationMapper.toEntity(donationDto);
        Donation savedDonation = donationRepository.save(donation);

        try {
            return objectMapper.writeValueAsString(savedDonation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
