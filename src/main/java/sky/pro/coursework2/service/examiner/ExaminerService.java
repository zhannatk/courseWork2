package sky.pro.coursework2.service.examiner;

import sky.pro.coursework2.domain.Question;

import java.util.Collection;


public interface ExaminerService {

Collection<Question> getQuestions(int amount);
}
