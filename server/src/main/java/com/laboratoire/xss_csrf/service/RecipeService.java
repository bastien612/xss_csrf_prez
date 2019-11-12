package com.laboratoire.xss_csrf.service;

import com.laboratoire.xss_csrf.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    RecipeDto create(RecipeDto dto);

    List<RecipeDto> getAllRecipes();

    void deleteAllRecipe();
}
