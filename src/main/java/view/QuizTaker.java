package view;

import data.QuizQuestionJDBCDao;
import model.QuizQuestion;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.List;

public class QuizTaker {

    private static final String NEON_CONNECTION_STRING = "postgres://krayterzoff219:EAnbBKq9Dr2L@ep-shy-resonance-25668067.us-east-2.aws.neon.tech/neondb";

    public static void main(String[] args) {

        QuizQuestionJDBCDao dao = new QuizQuestionJDBCDao(getDbSource(false));
        System.out.println("How many questions? ");

        //add scanner

        List<QuizQuestion> quiz = dao.getRandomQuestions(10);
        int countCorrect = 0;

        for(QuizQuestion question : quiz){
            System.out.println(question);
            //user answer (if matches, count + 1)
            System.out.println();
        }

    }


    private static DataSource getDbSource(boolean useLocalhost) {
        BasicDataSource dbSource = new BasicDataSource();

        if( useLocalhost ) {

            final String databaseName = "Leaderboard";
            final String connectionStr = "jdbc:postgresql://localhost:5432/" + databaseName;
            dbSource.setUrl(connectionStr);
            dbSource.setUsername("postgres");
            dbSource.setPassword("postgres1");

        } else {

            try {


                int startUsernameIndex = NEON_CONNECTION_STRING.indexOf("//") + "//".length();
                int endUsernameIndex = NEON_CONNECTION_STRING.indexOf(":", startUsernameIndex);
                final String username = NEON_CONNECTION_STRING.substring(startUsernameIndex, endUsernameIndex);

                int endPasswordIndex = NEON_CONNECTION_STRING.indexOf("@");
                final String password = NEON_CONNECTION_STRING.substring(endUsernameIndex + 1, endPasswordIndex);

                final String address = NEON_CONNECTION_STRING.substring(endPasswordIndex + 1);

                //                           "jdbc:postgresql://<hostname/address>/<database name>
                final String connectionStr = "jdbc:postgresql://" + address;
                dbSource.setUrl(connectionStr);
                dbSource.setUsername(username);
                dbSource.setPassword(password);

            } catch(IndexOutOfBoundsException e){
                String errorMessage = "Error parsing connection string (NEON_CONNECTION_STRING).\n" +
                        "Check that it is formatted correctly at the top of this file";
                System.out.println(errorMessage);
                e.printStackTrace();
                System.exit(1);
            }
        }

        return dbSource;
    }
}
