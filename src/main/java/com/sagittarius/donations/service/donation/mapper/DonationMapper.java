package com.sagittarius.donations.service.donation.mapper;

import com.sagittarius.donations.model.dto.DonationDto;
import com.sagittarius.donations.persistance.entity.Donation;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author LEVON
 */
@Mapper(componentModel = "spring")
public interface DonationMapper {

    DonationDto toDto(Donation donor);

    Donation toEntity(DonationDto donorDto);

    /**
     * Returns the list of dtos corresponding to the given entity list.
     *
     * @param paymentDetails
     * @return
     */
    List<DonationDto> toDtos(Iterable<Donation> paymentDetails);
}
