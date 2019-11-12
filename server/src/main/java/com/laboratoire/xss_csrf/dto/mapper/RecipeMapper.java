package com.laboratoire.xss_csrf.dto.mapper;

import com.laboratoire.xss_csrf.dto.RecipeDto;
import com.laboratoire.xss_csrf.model.RecipeModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RecipeDto convertToDto(RecipeModel model) {
        RecipeDto dto = modelMapper.map(model, RecipeDto.class);
        return dto;
    }

    public RecipeModel convertToModel(RecipeDto dto) {
        RecipeModel model = modelMapper.map(dto, RecipeModel.class);
        return model;
    }
}
