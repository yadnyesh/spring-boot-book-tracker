package io.javabrains.booktracker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult {
    int numFound;
    private List<SearchResultBook> docs;

}
