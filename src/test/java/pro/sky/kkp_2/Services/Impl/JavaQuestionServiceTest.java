package pro.sky.kkp_2.Services.Impl;

import org.junit.jupiter.api.Test;
import pro.sky.kkp_2.Data.Question;
import pro.sky.kkp_2.Exceptions.ExistsQuestionException;
import pro.sky.kkp_2.Exceptions.NotExistsQuestionException;
import pro.sky.kkp_2.Services.QuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class JavaQuestionServiceTest {

    private static final JavaQuestionService out = new JavaQuestionService();

    private static Question qs1 = new Question("Question_1", "Answer_1");
    private static Question qs2 = new Question("Question_2", "Answer_2");

    public static Set<Question> questions = new HashSet<>();

    @Test
    public void addNewQuestion() {
        assertEquals(qs1, out.add(qs1));
    }

    @Test
    public void addNewQuestionTeils() {
        Question qs = new Question("Q_1", "A_1");
        assertEquals(qs, out.add(qs));
    }

    @Test
    public void addQuestionDuplicate() {
        Question outQs = out.add(qs2);
        assertThrows(ExistsQuestionException.class, ()-> out.add(qs2) );
    }

    @Test
    public void removeExistingQuestion() {
        Question qs = new Question("Q_2", "A_2");
        questions.add(qs);
        out.setQuestions(questions);
        assertEquals(qs, out.remove(qs));
    }

    @Test
    public void removeNotExistingQuestion() {
        Question qs = new Question("Q_3", "A_3");
        out.setQuestions(questions);
        assertThrows(NotExistsQuestionException.class, ()-> out.remove(qs) );
    }



}