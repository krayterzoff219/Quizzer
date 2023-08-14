package model;

public class QuizQuestion {

    private String question;
    private int correctAnswer;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;

    public QuizQuestion(){
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n1) " + choice1 + "\t2) " + choice2 + "\t3) " + choice3 + "\t4) " + choice4;
    }
}
