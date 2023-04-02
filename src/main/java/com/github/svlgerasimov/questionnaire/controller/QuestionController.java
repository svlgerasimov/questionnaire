package com.github.svlgerasimov.questionnaire.controller;

import com.github.svlgerasimov.questionnaire.dto.QuestionPostRequestDto;
import com.github.svlgerasimov.questionnaire.dto.QuestionResponseDto;
import com.github.svlgerasimov.questionnaire.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/api/forms/{formId}/questions")
    public QuestionResponseDto post(@RequestBody @Valid QuestionPostRequestDto dto,
                                    @PathVariable Long formId) {
        return questionService.add(dto, formId);
    }

    @GetMapping("/api/forms/{formId}/questions/{questionId}")
    public QuestionResponseDto findById(@PathVariable Long formId,
                                        @PathVariable Long questionId) {
        return questionService.findById(questionId, formId);
    }
}
