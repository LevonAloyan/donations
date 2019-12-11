package com.sagittarius.donations.persistance.repository.donation;

import com.sagittarius.donations.persistance.domain.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT sum(converted_amount) as total FROM donation", nativeQuery = true)
    BigDecimal total();
}
