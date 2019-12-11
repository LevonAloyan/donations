package com.sagittarius.donations.service.currencyconverter.rest;

import com.sagittarius.donations.service.currencyconverter.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;


/**
 * Implementation of the CurrencyConverterService interface
 *
 * @author LEVON
 */
@Service
public class CurrencyConverterServiceImpl implements CurrencyConverterService {

    private static final String CURRENCY_PARAMS = "q";
    private static final String COMPACT_TYPE = "compact";
    private static final String COMPACT_TYPE_VALUE = "ultra";
    private static final String API_KEY = "apiKey";

    @Value("${currency.converter.api.key}")
    private String apiKey;

    @Value("${currency.converter.rest.service.url}")
    private String currencyConverterUrl;

    @Value("${currency.converter.rest.service.path}")
    private String currencyConverterPath;

    @Autowired
    @Qualifier("externalRestClient")
    private RestTemplate restTemplate;

    @Override
    public BigDecimal convert(String from, String to, BigDecimal amount) {
        if(from.equalsIgnoreCase(to)){
            return amount;
        }
        String convertCurrencyKey = String.join("_", from, to);
        UriComponentsBuilder targetUrl = UriComponentsBuilder.fromUriString(currencyConverterUrl)
                .path(currencyConverterPath)
                .queryParam(CURRENCY_PARAMS, convertCurrencyKey)
                .queryParam(COMPACT_TYPE, COMPACT_TYPE_VALUE)
                .queryParam(API_KEY, apiKey);

        Map convertedRate = restTemplate.getForObject(targetUrl.toUriString(), Map.class);

        if (! CollectionUtils.isEmpty(convertedRate)) {
            Number rate = (Number) convertedRate.get(convertCurrencyKey);
            
            BigDecimal result = amount.multiply(BigDecimal.valueOf(rate.doubleValue()));
            
            return result.setScale(2, RoundingMode.UP);            
        }

        return BigDecimal.ZERO;
    }
}
