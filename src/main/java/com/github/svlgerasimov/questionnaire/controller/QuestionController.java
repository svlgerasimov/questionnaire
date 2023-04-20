package com.github.svlgerasimov.questionnaire.controller;

import com.github.svlgerasimov.questionnaire.dto.QuestionPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.QuestionResponseDto;
import com.github.svlgerasimov.questionnaire.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Questions controller", description = "Operations with questions in a form")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "Post new question", description = "Post new question to a form")
    @PostMapping("/api/forms/{formId}/questions")
    public QuestionResponseDto post(@Parameter(required = true) @RequestBody @Valid QuestionPostRequestDto dto,
                                    @Parameter(required = true) @PathVariable Long formId) {
        return questionService.add(dto, formId);
    }

    @Operation(summary = "Find question by id", description = "Get full information about a question of a form")
    @GetMapping("/api/forms/{formId}/questions/{questionId}")
    public QuestionResponseDto findById(@Parameter(required = true) @PathVariable Long formId,
                                        @Parameter(required = true) @PathVariable Long questionId) {
        return questionService.findById(questionId, formId);
    }
}
