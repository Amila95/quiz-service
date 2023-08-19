package com.adinz.quizeService.service;


import com.adinz.quizeService.DTO.QuestionDTO;
import com.adinz.quizeService.DTO.ResponseDTO;
import com.adinz.quizeService.feign.QuizInterface;
import com.adinz.quizeService.modal.Quize;
import com.adinz.quizeService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

//    @Autowired
//    QuestionRepository questionRepository;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuize(String category, int noQ, String title) {

//        List<Question> questionList = questionRepository.createRandomQuestionUsingTypeandNoQ(category,noQ);
//
//
//        Quize quize = new Quize();
//        quize.setTitle(title);
//        quize.setQuestions(questionList);
//        quizRepository.save(quize);
        List<Integer> questionList = quizInterface.getQuestionForQuiz(category,noQ).getBody();
        Quize quize = new Quize();
        quize.setTitle(title);
        quize.setQuestionIds(questionList);
        quizRepository.save(quize);

        return new ResponseEntity("Created", HttpStatus.CREATED) ;
    }

    public ResponseEntity<List<QuestionDTO>> getQueiz(int id) {
        Optional<Quize> quize = quizRepository.findById(id);
       List<Integer> questionsIdList = quize.get().getQuestionIds();
        List<QuestionDTO> questionDTOList =quizInterface.getQustionFromId(questionsIdList).getBody();
        return new ResponseEntity(questionDTOList, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(int id, List<ResponseDTO> responseDTOS) {
        Optional<Quize> quize = quizRepository.findById(id);
        Integer score = quizInterface.getScore(responseDTOS).getBody();


        return new ResponseEntity(score,HttpStatus.OK);
    }

}
