package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@MicronautTest
class BugproofTest
{

	@Inject
	@Client("/")
	HttpClient client;


	@Test
	void shouldReturnHelloWorld()
	{
		final String response = client.toBlocking().retrieve(HttpRequest.GET("/").header("tenantId", "tenant"), String.class);
		assertEquals("Hello tenant", response);
	}

}
