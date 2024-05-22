package com.argusoft.notp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class NotpApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotpApplication.class, args);
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("https://graph.facebook.com/v18.0/275897422269662/messages"))
							.header("Authorization", "Bearer EAAtuc55qQlcBO6HtJ7ZCmZAZBu7HBeoE3GNPiF8JR17WJHt1t5sSgMaRMZAWfiAWpD1CC06i0z2pyOczuyuZBr7AaeN2Yvni19L0uO5LKpGGNS27siHlZAxvw28f8WZBPZCzTQ0EUR7XG9RsTydOw93LHbghTRQ2sDaiIVJ6LVP6mdRl91wKzIOmQcF4qK0kErJX0LjjTyPZCGgTAZAzHTrnRIAlWPYl8ZD")
							.header("Content-Type", "application/json")
							.POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"to\": \"919601987784\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }"))
							.build();
			HttpClient http = HttpClient.newHttpClient();
			HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		}
		catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
    }
}