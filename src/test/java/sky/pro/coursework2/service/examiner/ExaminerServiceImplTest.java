package sky.pro.coursework2.service.examiner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.coursework2.domain.Question;
import sky.pro.coursework2.exeptions.ExcessAmountException;
import sky.pro.coursework2.service.question.JavaQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void shouldThrowExcWhenAmountMoreThanSize() {
        Set<Question> zaglushko = new HashSet<>();
        zaglushko.add(new Question("вопрос1", "ответ1"));
        Mockito.when(javaQuestionService.getAll()).thenReturn(zaglushko);
        assertThrows(ExcessAmountException.class, () ->
                examinerService.getQuestions(3));
    }


    @Test
    void shouldGetRandomQuestionFromQServ() {
        Question tmpQ = new Question("Вопрос1", "Ответ1");
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(tmpQ);
        Set<Question> tmpS = new HashSet<>(Set.of(tmpQ));
        Mockito.when(javaQuestionService.getAll()).thenReturn(tmpS);
        assertEquals(tmpS, examinerService.getQuestions(1));
    }
}