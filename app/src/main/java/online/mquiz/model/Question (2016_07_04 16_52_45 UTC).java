package online.mquiz.model;

/**
 * Created by Shikher on 28-06-2016.
 */
public class Question {
    String ques;
    int qno;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String optionE;
    String answer;
    String explanation;
    String quizId;
    String userAnswer;
    public int studentId;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getOptionE() {
        return optionE;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public int getQno() {
        return qno;
    }

    public String getQues() {
        return ques;
    }

    public String getQuizId() {
        return quizId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }
}


