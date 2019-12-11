package com.sagittarius.donations.service.donation;

import com.sagittarius.donations.model.dto.DonationDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LEVON
 */
public interface DonationService {

    String create(DonationDto donationDto);

    List<DonationDto> getAll();

    BigDecimal calculateTotalAmount();
}
