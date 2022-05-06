package pro.sky.kkp_2.Services.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.kkp_2.Data.Question;
import pro.sky.kkp_2.Services.QuestionService;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private static JavaQuestionService outQs = new JavaQuestionService();

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    private static Question qs1 = new Question("Question_1", "Answer_1");
    private static Question qs2 = new Question("Question_2", "Answer_2");
    private static Question qs3 = new Question("Question_3", "Answer_3");
    private static Question qs4 = new Question("Question_4", "Answer_4");
    private static Question qs5 = new Question("Question_5", "Answer_5");

    public static Collection<Question> questions1 = new HashSet<>(Set.of(qs1));
    public static Collection<Question> questions2 = new HashSet<>(Set.of(qs1, qs2));
    public static Collection<Question> questions5 = Set.of(qs1, qs2, qs3, qs4, qs5);

    @Test
    public void getRandomQuestion() {
        when(questionServiceMock.gelAll()).thenReturn(questions1);
        when(questionServiceMock.getRandomQuestion()).thenReturn(qs1);

        Collection<Question> cloQs = out.getQuestions(1);
        Collection<Question> cl = cloQs.stream().collect(Collectors.toList());
        ArrayList<Question> al = (ArrayList)cl;
        assertEquals(qs1, al.get(0));
    }

}