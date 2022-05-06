package pro.sky.kkp_2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kkp_2.Data.Question;
import pro.sky.kkp_2.Services.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestion(@RequestParam(value = "amount") int amount) {
        Collection<Question> result;
        result = examinerService.getQuestions(amount);
        return result;
    }

}
