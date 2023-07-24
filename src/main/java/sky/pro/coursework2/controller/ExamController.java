package sky.pro.coursework2.controller;

import org.springframework.web.bind.annotation.*;
import sky.pro.coursework2.domain.Question;
import sky.pro.coursework2.service.examiner.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerServiceImpl examinerService;
    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
@GetMapping("/get{amount}")
public Collection<Question> getQuestion (@PathVariable int amount){
        return examinerService.getQuestions(amount);
}

}
