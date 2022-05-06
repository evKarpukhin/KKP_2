package pro.sky.kkp_2.Services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.kkp_2.Data.Question;
import pro.sky.kkp_2.Exceptions.BadQuestionException;
import pro.sky.kkp_2.Services.ExaminerService;
import pro.sky.kkp_2.Services.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if ((amount > questionService.gelAll().size()) || (amount <= 0)) {
            throw new BadQuestionException("Bad value of questions " + amount);
        }
        int count = 0;
        Set<Question> examinerQuestions = new HashSet<>();
        while (count < amount) {
            Question qs = questionService.getRandomQuestion();
            if (examinerQuestions.add(qs)) {
                count++;
            }
        }
        return examinerQuestions;
    }
}
