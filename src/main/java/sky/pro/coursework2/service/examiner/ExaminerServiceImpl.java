package sky.pro.coursework2.service.examiner;

import org.springframework.stereotype.Service;
import sky.pro.coursework2.domain.Question;
import sky.pro.coursework2.exeptions.ExcessAmountException;
import sky.pro.coursework2.service.question.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size() < amount)
            throw new ExcessAmountException("У нас нет столько вопросов");
        Set<Question> q = new HashSet<>();
        while (q.size() != amount) {
            q.add(javaQuestionService.getRandomQuestion());
        }
        return q;
    }


}
