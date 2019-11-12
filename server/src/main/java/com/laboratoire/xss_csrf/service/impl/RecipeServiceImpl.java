package com.laboratoire.xss_csrf.service.impl;

import com.laboratoire.xss_csrf.dto.RecipeDto;
import com.laboratoire.xss_csrf.dto.mapper.RecipeMapper;
import com.laboratoire.xss_csrf.model.RecipeModel;
import com.laboratoire.xss_csrf.repository.RecipeRepository;
import com.laboratoire.xss_csrf.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeMapper recipeMapper;

    @Override
    public RecipeDto create(RecipeDto dto) {

        RecipeModel recipe = recipeMapper.convertToModel(dto);

        logger.info(String.format("Création de : %s", dto.getTitle()) );
        RecipeModel created;
        try {
            created = recipeRepository.save(recipe);
        } catch (Exception e) {
            logger.error(String.format("L'erreur : %s, %s", e.getClass().getName(), e.getMessage()));
            logger.error("Stack Trace : ", e);
            throw e;
        }

        RecipeDto dtoCreated = recipeMapper.convertToDto(created);

        return dtoCreated;
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<RecipeModel> recipes = recipeRepository.findAll();

        return recipes.stream().map(recipe -> recipeMapper.convertToDto(recipe)).collect(Collectors.toList());
    }

    @Override
    public void deleteAllRecipe() {
        recipeRepository.deleteAll();
    }
}
