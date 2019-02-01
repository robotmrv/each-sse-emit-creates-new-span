package com.example.eachsseemitcreatesnewspan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@RestController
	public static class MyController {
		@GetMapping("/events")
		public Flux<ServerSentEvent<String>> events() {
			return Flux.interval(Duration.ofSeconds(1))
					.map(i -> ServerSentEvent.builder("ping: " + i).build())
					.log("sse");
		}
	}

}

