package com.juandiegodelacruz.bookingapi.service;


import com.juandiegodelacruz.bookingapi.model.RequestDiscount;
import com.juandiegodelacruz.bookingapi.model.ResponseDiscount;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import java.util.concurrent.CompletableFuture;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retry(name = "externalApiRetry")
    @TimeLimiter(name = "externalApiTimeout")
    public CompletableFuture<ResponseDiscount> postApiData(String apiUrl, RequestDiscount requestDiscount, Class<ResponseDiscount> responseDiscountClass) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "application/json");
                HttpEntity<RequestDiscount> requestEntity = new HttpEntity<>(requestDiscount, headers);

                ResponseEntity<ResponseDiscount> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ResponseDiscount.class);
                return responseEntity.getBody();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public ResponseDiscount validateApiData(String apiUrl,RequestDiscount requestDiscount,Class<ResponseDiscount> responseDiscountClass) {
        try {
            return postApiData(apiUrl,requestDiscount, responseDiscountClass).get(5, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            throw new RuntimeException("Error executing API call", e.getCause());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("API call timed out", e);
        }
    }
}
