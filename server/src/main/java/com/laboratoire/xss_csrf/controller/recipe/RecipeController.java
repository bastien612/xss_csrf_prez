package com.laboratoire.xss_csrf.controller.recipe;

import com.laboratoire.xss_csrf.dto.RecipeDto;
import com.laboratoire.xss_csrf.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    private RecipeDto createRecipe(@RequestBody RecipeDto recipe) {
        RecipeDto response;
        try {
            response = recipeService.create(recipe);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", e);
        }
        return response;
    }

    @GetMapping(value = "/list")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private List<RecipeDto> getAllRecipe() {
        return recipeService.getAllRecipes();
    }

    @DeleteMapping(value = "/list")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private void deleteAllRecipe() {
        recipeService.deleteAllRecipe();
    }
}
