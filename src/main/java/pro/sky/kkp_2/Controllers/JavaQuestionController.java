package pro.sky.kkp_2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kkp_2.Data.Question;
import pro.sky.kkp_2.Services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/hello")
    public String welcomeToDB() {
        return "Welcome to the DB questions!";
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam(value = "question") String question,
                                @RequestParam(value = "answer") String answer) {
        Question result;
        result = questionService.add(question, answer);
        return result;
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(value = "question") String question,
                                   @RequestParam(value = "answer") String answer) {
        Question qs = new Question(question, answer);
        Question result = questionService.remove(qs);
        return result;
    }

    @GetMapping("/java")
    public Collection<Question> getQuestion() {
        Collection<Question> result;
        result = questionService.gelAll();
        return result;
    }


}
