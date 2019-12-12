package com.sagittarius.donations.persistance.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author LEVON
 */

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "pop_up_timeout", nullable = false)
    private long popUpTimeout;

    @Column(name = "converted_amount", nullable = false)
    private BigDecimal convertedAmount;

    @Column(name = "currency", nullable = false)
    private Currency currency;

    public Donation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPopUpTimeout() {
        return popUpTimeout;
    }

    public void setPopUpTimeout(long popUpTimeout) {
        this.popUpTimeout = popUpTimeout;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
