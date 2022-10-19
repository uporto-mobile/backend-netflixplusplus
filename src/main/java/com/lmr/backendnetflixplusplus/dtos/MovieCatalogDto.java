package com.lmr.backendnetflixplusplus.dtos;

import javax.validation.constraints.NotBlank;

public class MovieCatalogDto {

    @NotBlank
    private String movieName;
}
