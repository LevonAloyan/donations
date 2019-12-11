package com.sagittarius.donations.service.donation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagittarius.donations.model.dto.DonationDto;
import com.sagittarius.donations.persistance.domain.Country;
import com.sagittarius.donations.persistance.domain.Donation;
import com.sagittarius.donations.persistance.repository.country.CountryRepository;
import com.sagittarius.donations.persistance.repository.donation.DonationRepository;
import com.sagittarius.donations.service.currencyconverter.CurrencyConverterService;
import com.sagittarius.donations.service.donation.mapper.DonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public String create(DonationDto donationDto) {

        Donation donation = donationMapper.toEntity(donationDto);
        String countryName = donation.getCountry().getName();
        Country country = countryRepository.findByName(countryName);
        donation.setConvertedAmount(currencyConverterService.convert(country.getCurrencyCode(), "AMD", donation.getAmount()));
        Donation savedDonation = donationRepository.save(donation);
        try {
            return objectMapper.writeValueAsString(savedDonation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DonationDto> getAll() {
        return donationMapper.toDtos(donationRepository.findAll());
    }

    @Override
    public BigDecimal calculateTotalAmount() {
        return donationRepository.total();
    }
}
