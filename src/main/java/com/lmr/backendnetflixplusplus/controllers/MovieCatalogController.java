package com.lmr.backendnetflixplusplus.controllers;

import com.lmr.backendnetflixplusplus.services.MovieCatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/movie-catalog")
public class MovieCatalogController {
    final MovieCatalogService movieCatalogService;

    public MovieCatalogController(MovieCatalogService movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }
}
