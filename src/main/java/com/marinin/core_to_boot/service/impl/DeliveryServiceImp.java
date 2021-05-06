package com.marinin.core_to_boot.service.impl;

import com.marinin.core_to_boot.service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeliveryServiceImp implements DeliveryService {

    private RestTemplate restTemplate;

    public DeliveryServiceImp() {
    }

    private final String dToken = "C765CFAC10FD56D2B079BABB01D195EFBC0A3D03";
    private final String dHeader = "X-DV-Auth-Token";
    private final String dURL = "https://robotapitest.dostavista.ru/api/business/1.1";

    @Autowired
    public DeliveryServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void getMathApi() {
        Long lng = Math.round(Math.random() * 1000);
        String url = "http://numbersapi.com/" + lng;
        toMathApi(url);
    }

    @Override
    public void getMathApi(Long lng) {
        String url = "http://numbersapi.com/" + lng;
        toMathApi(url);
    }

    private void toMathApi(String url) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println("Status " + responseEntity.getStatusCode());
        System.out.println("Body " + responseEntity.getBody());
    }

    @Override
    public void doDost(Long lng) {

    }

    @Override
    public void dost1() {
        HttpHeaders headers = new HttpHeaders();

        headers.set(dHeader, dURL);
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(dURL, HttpMethod.GET, request, String.class);

        System.out.println("Status " + responseEntity.getStatusCode());
        System.out.println("Body " + responseEntity.getBody());
    }
}
