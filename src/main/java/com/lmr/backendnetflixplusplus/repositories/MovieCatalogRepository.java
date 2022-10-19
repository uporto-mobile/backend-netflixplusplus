package com.lmr.backendnetflixplusplus.repositories;

import com.lmr.backendnetflixplusplus.models.MovieCatalogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieCatalogRepository extends JpaRepository<MovieCatalogModel, UUID> {

}
