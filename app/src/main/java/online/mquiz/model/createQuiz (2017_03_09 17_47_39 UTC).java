package online.mquiz.model;

/**
 * Created by Shikher on 28-06-2016.
 */
public class createQuiz
{   static int i=0;
    String name;
    String time;
    String description;
    int noq;
    Question[] question = new Question[noq];

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoq(int noq) {
        this.noq = noq;
    }

    public void setQuestion(Question[] question) {
        this.question = question;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNoq() {
        return noq;
    }

    public Question[] getQuestion() {
        return question;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}


