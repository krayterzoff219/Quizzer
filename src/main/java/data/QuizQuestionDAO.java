package data;

import model.QuizQuestion;

import java.util.List;

public interface QuizQuestionDAO {

    public QuizQuestion getRandomQuestion();
    public QuizQuestion getQuestionByNumber();
    public List<QuizQuestion> getRandomQuiz(int numOfQuestions);
}
