package com.lmr.backendnetflixplusplus.services;

import com.lmr.backendnetflixplusplus.models.MovieCatalogModel;
import com.lmr.backendnetflixplusplus.repositories.MovieCatalogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Page<MovieCatalogModel> findAll(Pageable pageable) {
        return movieCatalogRepository.findAll(pageable);
    }

    public Optional<MovieCatalogModel> findById(UUID id) {
        return movieCatalogRepository.findById(id);
    }

    @Transactional
    public void delete(MovieCatalogModel movieCatalogModel) {
        movieCatalogRepository.delete(movieCatalogModel);
    }
}
