package sky.pro.coursework2.service.question;

import org.junit.jupiter.api.Test;
import sky.pro.coursework2.domain.Question;
import sky.pro.coursework2.exeptions.OneOfParamIsNullException;
import sky.pro.coursework2.exeptions.QuestionAlreadyExistsException;
import sky.pro.coursework2.exeptions.QuestionEqualsAnswerException;
import sky.pro.coursework2.exeptions.QuestionNotFondException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void shouldAddOneQuestionByStrings() {

        assertAll(

                () -> assertThrows(QuestionEqualsAnswerException.class, () ->
                        javaQuestionService.add("SAME", "SAME")),
                () -> assertThrows(OneOfParamIsNullException.class, () ->
                        javaQuestionService.add("", "ответ")),
                () -> assertThrows(OneOfParamIsNullException.class, () ->
                        javaQuestionService.add("вопрос", "")),
                () -> assertEquals(new Question("вопрос1", "ответ1"),
                        javaQuestionService.add("вопрос1", "ответ1")),
                () -> assertThrows(QuestionAlreadyExistsException.class, () ->
                        javaQuestionService.add("вопрос1", "ответ1"))

        );
    }

    @Test
    void shouldRemoveQuestionByObject() {
        javaQuestionService.add("вопрос1", "ответ1");
        Question tmpQ = new Question("вопрос1", "ответ1");
        assertEquals(tmpQ, javaQuestionService.remove(tmpQ));
    }

    @Test
    void shouldTrowExcByRemoveQuestionByObject() {
        Question question = new Question("вопрос1", "ответ1");
        assertThrows(QuestionNotFondException.class, () ->
                javaQuestionService.remove(question));
    }


    @Test
    void shouldReturnCollection() {
        javaQuestionService.add("вопрос1", "ответ1");
        javaQuestionService.add("вопрос2", "ответ2");
        Set<Question> tempCollection = new HashSet<>();
        tempCollection.add(new Question("вопрос1", "ответ1"));
        tempCollection.add(new Question("вопрос2", "ответ2"));
        assertEquals(tempCollection, javaQuestionService.getAll());
    }

    @Test
    void shouldReturnOneRandomQuestionFromOneQ() {
        javaQuestionService.add("вопрос1", "ответ1");
        javaQuestionService.add("вопрос2", "ответ2");
        Set<Question> tempCollectionExpected = new HashSet<>();
        tempCollectionExpected.add(new Question("вопрос1", "ответ1"));
        tempCollectionExpected.add(new Question("вопрос2", "ответ2"));

        Set<Question> tempCollectionFromMethod = new HashSet<>();
        while (tempCollectionFromMethod.size() < 2) {
            tempCollectionFromMethod.add(javaQuestionService.getRandomQuestion());
        }

        assertEquals(tempCollectionExpected, tempCollectionFromMethod);

    }
}