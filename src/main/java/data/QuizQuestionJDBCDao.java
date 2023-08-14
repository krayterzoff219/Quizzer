package data;

import model.QuizQuestion;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class QuizQuestionJDBCDao implements QuizQuestionDAO{

    private JdbcTemplate jdbcTemplate;

    public QuizQuestionJDBCDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public QuizQuestion getRandomQuestion() {
        String sql = "SELECT * FROM quiz_questions ORDER BY RANDOM() LIMIT 1;";
        return null;
    }

    @Override
    public QuizQuestion getQuestionByNumber() {
        return null;
    }

    @Override
    public List<QuizQuestion> getRandomQuiz(int numOfQuestions) {
        String totalQuestionsSql = "SELECT COUNT(*) AS total FROM quiz_questions;";
        String sql = "SELECT * FROM quiz_questions ORDER BY RANDOM() LIMIT ?;";
        List<QuizQuestion> quiz = new ArrayList<>();
        int totalQuestions = 0;
        try{
            SqlRowSet totalRow = this.jdbcTemplate.queryForRowSet(totalQuestionsSql);
            if(totalRow.next()){
                totalQuestions = totalRow.getInt("total");
            }
            if (numOfQuestions > totalQuestions){
                numOfQuestions = totalQuestions;
                System.out.println("We cannot currently support a quiz that size, so your quiz will only have "
                        + totalQuestions + " questions. Sorry for the inconvenience.");
            }
            SqlRowSet row = this.jdbcTemplate.queryForRowSet(sql, numOfQuestions);
            while(row.next()){
                QuizQuestion question = mapRowToQuestion(row);
                quiz.add(question);
            }
        } catch(CannotGetJdbcConnectionException e){
            System.out.println("Cannot connect");
        }

        return quiz;
    }

    public QuizQuestion mapRowToQuestion(SqlRowSet row){
        QuizQuestion question = new QuizQuestion();
        question.setQuestion(row.getString("question"));
        question.setCorrectAnswer(row.getInt("correct_answer"));
        question.setChoice1(row.getString("choice_1"));
        question.setChoice2(row.getString("choice_2"));
        question.setChoice3(row.getString("choice_3"));
        question.setChoice4(row.getString("choice_4"));

        return question;
    }

}
