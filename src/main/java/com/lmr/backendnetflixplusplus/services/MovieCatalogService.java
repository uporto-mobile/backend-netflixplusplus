package com.lmr.backendnetflixplusplus.services;

import com.lmr.backendnetflixplusplus.models.MovieCatalogModel;
import com.lmr.backendnetflixplusplus.repositories.MovieCatalogRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieCatalogService {

    final MovieCatalogRepository movieCatalogRepository;

    public MovieCatalogService(MovieCatalogRepository movieCatalogRepository) {
        this.movieCatalogRepository = movieCatalogRepository;
    }

    @Transactional
    public Object save(MovieCatalogModel movieCatalogModel) {
        return movieCatalogRepository.save(movieCatalogModel);
    }

    public List<MovieCatalogModel> findAll() {
        return movieCatalogRepository.findAll();
    }

    public Optional<MovieCatalogModel> findById(UUID id) {
        return movieCatalogRepository.findById(id);
    }

    public void delete(MovieCatalogModel movieCatalogModel) {
        movieCatalogRepository.delete(movieCatalogModel);
    }
}
