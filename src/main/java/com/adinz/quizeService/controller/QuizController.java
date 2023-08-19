package com.adinz.quizeService.controller;


import com.adinz.quizeService.DTO.QuestionDTO;
import com.adinz.quizeService.DTO.QuizDTO;
import com.adinz.quizeService.DTO.ResponseDTO;
import com.adinz.quizeService.feign.QuizInterface;
import com.adinz.quizeService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuizInterface quizInterface;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDto){
        return quizService.createQuize(quizDto.getCategory(),quizDto.getNoOfQuestion(),quizDto.getTitle());
        //return new ResponseEntity("Created", HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuize(@PathVariable int id){
        return quizService.getQueiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuize(@PathVariable int id, @RequestBody List<ResponseDTO> responseDTOS){
        return quizService.submitQuiz(id,responseDTOS);
    }
}
