package com.sagittarius.donations.model.dto;

import java.math.BigDecimal;

/**
 * @author LEVON
 */
public class DonationDto {

    private Long id;
    private String name;
    private BigDecimal amount;
    private CountryDto country;
    private String description;
    private long popUpTimeout;
    private BigDecimal convertedAmount;

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

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
