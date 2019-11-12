package com.laboratoire.xss_csrf.repository;

import com.laboratoire.xss_csrf.model.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RecipeRepository extends JpaRepository<RecipeModel, UUID> {
    List<RecipeModel> findAll();
}
