package com.pairgood.todo.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class OwnerService {

    private WebClient webClient;

    public OwnerService(String baseUrl){
        webClient= WebClient.builder()
        .baseUrl(baseUrl)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
    }

    public Owner findById(long id){
        return webClient.get()
		.uri("/owners/" + id)
		.retrieve()
		.bodyToMono(Owner.class).block();
    }
}
