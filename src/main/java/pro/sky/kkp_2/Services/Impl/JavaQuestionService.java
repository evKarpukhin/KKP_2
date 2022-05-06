package pro.sky.kkp_2.Services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.kkp_2.Data.Question;
import pro.sky.kkp_2.Exceptions.ExistsQuestionException;
import pro.sky.kkp_2.Exceptions.NotExistsQuestionException;
import pro.sky.kkp_2.Services.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions;

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question qs = new Question(question, answer);
        return add(qs);
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new ExistsQuestionException("Question yet exists.");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotExistsQuestionException("Question not exists.");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> gelAll() {
        return questions.stream()
                .collect(Collectors.toSet()); // or toList ?
    }

    @Override
    public Question getRandomQuestion() {
        java.util.Random random = new java.util.Random();
        Collection<Question> cl = questions.stream().collect(Collectors.toList());
        ArrayList<Question> al = (ArrayList)cl;
        return al.get(random.nextInt(cl.size())) ;
    }

}
