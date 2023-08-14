package view;

import data.DatabaseDao;
import data.QuizQuestionJDBCDao;
import model.QuizQuestion;
import java.util.List;
import java.util.Scanner;

public class QuizTaker {


    public static void main(String[] args) {

        DatabaseDao db = new DatabaseDao();
        QuizQuestionJDBCDao dao = new QuizQuestionJDBCDao(db.getDbSource(false));
        System.out.println("How many questions? ");
        try (Scanner userScan = new Scanner(System.in)){
            int numOfQuestions = Integer.parseInt(userScan.nextLine());
            List<QuizQuestion> quiz = dao.getRandomQuiz(numOfQuestions);
            int countCorrect = 0;

            for(QuizQuestion question : quiz){
                System.out.println(question);
                System.out.println("Choose an answer: ");
                int userChoice = Integer.parseInt(userScan.nextLine());

                if (userChoice == question.getCorrectAnswer()){
                    countCorrect++;
                }
                System.out.println();
                System.out.println();
            }

            System.out.println("Final Score: ");
            System.out.println("You got " + countCorrect + " questions correct out of " + numOfQuestions +
                    ". That is a score of " + (countCorrect * 100 / numOfQuestions));
        } catch (NumberFormatException e){

        }


    }



}
