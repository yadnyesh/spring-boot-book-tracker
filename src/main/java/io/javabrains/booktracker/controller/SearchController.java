package io.javabrains.booktracker.controller;

import io.javabrains.booktracker.model.SearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
public class SearchController {

    private final WebClient webClient;


    public SearchController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://openlibrary.org/search.json")
                .build();
    }

    public String getSearchResults(@RequestParam String query) {
        Mono<SearchResult> foo = this.webClient.get()
                .uri("?q={query", query)
                .retrieve().bodyToMono(SearchResult.class);
        SearchResult searchResult = foo.block();


        return "search";
    }
}
