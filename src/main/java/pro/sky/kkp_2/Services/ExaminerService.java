package pro.sky.kkp_2.Services;

import pro.sky.kkp_2.Data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
