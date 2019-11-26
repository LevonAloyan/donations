package com.sagittarius.donations.service.donation;

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

    @Override
    public DonationDto create(DonationDto donationDto) {
        Donation donation = donationMapper.toEntity(donationDto);
        Donation savedDonation = donationRepository.save(donation);

        return donationMapper.toDto(savedDonation);
    }
}
