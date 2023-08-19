package com.adinz.quizeService.feign;

import com.adinz.quizeService.DTO.QuestionDTO;
import com.adinz.quizeService.DTO.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQuestions);

    @PostMapping("question/getQuestion")
    public ResponseEntity<List<QuestionDTO>> getQustionFromId(@RequestBody List<Integer> questionId);



    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<ResponseDTO> responseDTOList);
}
