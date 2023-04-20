package com.github.svlgerasimov.questionnaire.controller;

import com.github.svlgerasimov.questionnaire.dto.FormPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.FormResponseDto;
import com.github.svlgerasimov.questionnaire.service.FormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Form controller", description = "Operations with forms")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FormController {

    private final FormService formService;

    @Operation(summary = "Post new form")
    @PostMapping("/api/forms")
    public FormResponseDto post(@Parameter(required = true) @RequestBody @Valid FormPostRequestDto dto) {
        return formService.add(dto);
    }

    @Operation(summary = "Find form by id", description = "Get full information about a form")
    @GetMapping("/api/forms/{id}")
    public FormResponseDto findById(@Parameter(description = "Form id", required = true) @PathVariable Long id) {
        return formService.findById(id);
    }
}
