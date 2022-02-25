package com.pairgood.todo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OwnerService {

    private WebClient webClient;

    public OwnerService(@Value("${owner.provider.url}") String baseUrl){
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
