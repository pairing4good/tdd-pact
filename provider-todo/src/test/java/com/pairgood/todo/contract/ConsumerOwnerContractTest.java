package com.pairgood.todo.contract;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.pairgood.todo.service.Owner;
import com.pairgood.todo.service.OwnerService;

public class ConsumerOwnerContractTest {

    private int port = 8080;

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("OwnerAPI", "localhost", port, this);

    @Pact(consumer = "ToDoAPI", provider = "OwnerAPI")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = Collections.singletonMap("Content-Type", "application/json");
        PactDslJsonBody body = new PactDslJsonBody().stringType("username", "testUsername");

        return builder
          .uponReceiving("GET REQUEST")
            .path("/owners/1")
            .method("GET")
          .willRespondWith()
            .status(200)
            .headers(headers)
            .body(body)
          .toPact();
    }

    @Test
    @PactVerification()
    public void shouldReturnOnwer(){
        Owner owner = new OwnerService("http://localhost:" + port).findById(1);
        assertNotNull(owner);
        assertEquals("testUsername", owner.getUsername());
    }
}

