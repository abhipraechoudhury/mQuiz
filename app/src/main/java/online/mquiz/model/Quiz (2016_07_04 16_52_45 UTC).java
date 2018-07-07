package online.mquiz.model;

/**
 * Created by Abhiprae on 6/28/2016.
 */
public class Quiz {
    public String name;
    public String description;
    public int quizId;
    public int noq;
    public int maxScore;
    public String time;
    public String createdBy;


    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoq(int noq) {
        this.noq = noq;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getNoq() {
        return noq;
    }

    public int getQuizId() {
        return quizId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getTime() {
        return time;
    }
}
