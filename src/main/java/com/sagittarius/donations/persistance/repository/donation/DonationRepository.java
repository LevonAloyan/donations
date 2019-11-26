package com.sagittarius.donations.persistance.repository.donation;

import com.sagittarius.donations.persistance.entity.Donation;
import org.springframework.data.repository.CrudRepository;

public interface DonationRepository extends CrudRepository<Donation, Long> {
}
