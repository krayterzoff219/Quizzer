package data;

import model.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.dao.DataAccessException;

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
    public List<QuizQuestion> getRandomQuestions(int numOfQuestions) {
        String sql = "SELECT * FROM quiz_questions ORDER BY RANDOM() LIMIT ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, numOfQuestions);
        return null;
    }

}
