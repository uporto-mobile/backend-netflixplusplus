package com.lmr.backendnetflixplusplus.controllers;

import com.lmr.backendnetflixplusplus.dtos.MovieCatalogDto;
import com.lmr.backendnetflixplusplus.models.MovieCatalogModel;
import com.lmr.backendnetflixplusplus.services.MovieCatalogService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/movie-catalog")
public class MovieCatalogController {
    final MovieCatalogService movieCatalogService;

    public MovieCatalogController(MovieCatalogService movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }

    @PostMapping
    public ResponseEntity<Object> saveMovieCatalog(@RequestBody @Valid MovieCatalogDto movieCatalogDto) {
        var movieCatalogModel = new MovieCatalogModel();
        BeanUtils.copyProperties(movieCatalogDto, movieCatalogModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieCatalogService.save(movieCatalogModel));
    }

    @GetMapping("/")
    public ResponseEntity<Page<MovieCatalogModel>> getAllMovieCatalog(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(movieCatalogService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMovieCatalog(@PathVariable(value = "id") UUID id) {
        Optional<MovieCatalogModel> movieCatalogModelOptional = movieCatalogService.findById(id);
        if (movieCatalogModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(movieCatalogModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovieCatalog(@PathVariable(value = "id") UUID id) {
        Optional<MovieCatalogModel> movieCatalogModelOptional = movieCatalogService.findById(id);
        if (movieCatalogModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
        movieCatalogService.delete(movieCatalogModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Movie Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putMovieCatalog(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Valid MovieCatalogDto movieCatalogDto) {
        Optional<MovieCatalogModel> movieCatalogModelOptional = movieCatalogService.findById(id);
        if (movieCatalogModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
        var movieCatalogModel = new MovieCatalogModel();
        BeanUtils.copyProperties(movieCatalogDto, movieCatalogModel);
        movieCatalogModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(movieCatalogService.save(movieCatalogModel));
    }

}
