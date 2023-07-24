package sky.pro.coursework2.service.question;

import org.springframework.stereotype.Service;
import sky.pro.coursework2.domain.Question;
import sky.pro.coursework2.exeptions.OneOfParamIsNullException;
import sky.pro.coursework2.exeptions.QuestionAlreadyExistsException;
import sky.pro.coursework2.exeptions.QuestionEqualsAnswerException;
import sky.pro.coursework2.exeptions.QuestionNotFondException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (question.equals(answer))
            throw new QuestionEqualsAnswerException("вопрос и ответ имеют один и тот же текст");
        if (question.equals("") || answer.isEmpty())
            throw new OneOfParamIsNullException("Что-то тут пусто");
        Question e = new Question(question, answer);
        if (!questions.add(e))
            throw new QuestionAlreadyExistsException("Вопрос уже существует");
        return e;
    }

    //я вообще не понимаю, зачем он нужен
//    @Override
//    public Question add(Question question) {
//        if (questions.contains(question)) {
//            throw new QuestionAlreadyExistsException("уже есть");
//        }
//        questions.add(question);
//        return question;

    //    }


    @Override
    public Question remove(Question question) {
        if (!questions.remove(question))
            throw new QuestionNotFondException("Вопрос не найден");

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> qList = new ArrayList<>(questions);
        Random rnd = new Random(System.currentTimeMillis());
        // [0,1)
        int i = rnd.nextInt(questions.size());
        return qList.get(i);
    }
}