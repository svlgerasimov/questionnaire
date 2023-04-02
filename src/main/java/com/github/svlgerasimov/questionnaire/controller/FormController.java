package com.github.svlgerasimov.questionnaire.controller;

import com.github.svlgerasimov.questionnaire.dto.FormPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.FormResponseDto;
import com.github.svlgerasimov.questionnaire.service.FormService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FormController {

    private final FormService formService;

    @PostMapping("/api/forms")
    public FormResponseDto post(@RequestBody @Valid FormPostRequestDto dto) {
        return formService.add(dto);
    }

    @GetMapping("/api/forms/{id}")
    public FormResponseDto findById(@PathVariable Long id) {
        return formService.findById(id);
    }
}
