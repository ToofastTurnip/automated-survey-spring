package com.twilio.survey.services;

import com.twilio.survey.models.Question;
import com.twilio.survey.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
  private QuestionRepository questionRepository;

  @Autowired
  public QuestionService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  public void create(Question question) {
    questionRepository.save(question);
  }

  public void delete(Long id) {
    questionRepository.delete(id);
  }

  public void deleteAll() {
    questionRepository.deleteAll();
  }

  public Long count() {
    return questionRepository.count();
  }

  public List<Question> findAll() {
    return questionRepository.findAll();
  }

  public Question find(Long id) {
    return questionRepository.findOne(id);
  }
}
