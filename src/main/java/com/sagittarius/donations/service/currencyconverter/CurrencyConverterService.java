package com.sagittarius.donations.service.currencyconverter;

import java.math.BigDecimal;

/**
 * Client interface to connect to currency converter service API and retrieve data...
 *
 * @author LEVON
 */
public interface CurrencyConverterService {

    /**
     * Convert rate
     */
    BigDecimal convert(String from, String to, BigDecimal amount);
}
