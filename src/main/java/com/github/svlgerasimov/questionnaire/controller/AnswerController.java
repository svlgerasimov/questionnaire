package com.github.svlgerasimov.questionnaire.controller;

import com.github.svlgerasimov.questionnaire.dto.AnswersSetPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.AnswersSetResponseDto;
import com.github.svlgerasimov.questionnaire.service.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Answers controller", description = "Operations with answers")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnswerController {

    private final AnswerService answerService;

    @Operation(summary = "Post an answers set")
    @PostMapping("/api/forms/{formId}/answers")
    public AnswersSetResponseDto post(@Parameter(required = true) @RequestBody @Valid AnswersSetPostRequestDto dto,
                                      @Parameter(required = true) @PathVariable Long formId) {
        return answerService.add(dto, formId);
    }

    @Operation(summary = "Get all answers sets")
    @GetMapping("/api/forms/{formId}/answers")
    public List<AnswersSetResponseDto> findAll(@Parameter(required = true) @PathVariable Long formId) {
        return answerService.findAll(formId);
    }
}
