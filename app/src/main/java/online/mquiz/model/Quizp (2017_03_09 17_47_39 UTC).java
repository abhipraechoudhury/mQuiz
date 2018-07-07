package online.mquiz.model;

/**
 * Created by Shikher on 28-06-2016.
 */
public class Quizp {

    public int quizId;
    public String name;
    public String description;
    public String time;
    public int noq;

    public int maxScore;
    public String createdBy;

    public void set$createdBy(String $createdBy) {
        this.createdBy = $createdBy;
    }



    public void set$description(String $description) {
        this.description = $description;
    }

    public void set$maxScore(int $maxScore) {
        this.maxScore = $maxScore;
    }

    public void set$name(String $name) {
        this.name = $name;
    }

    public void set$noq(int $noq) {
        this.noq = $noq;
    }

    public void set$quizId(int $quizId) {
        this.quizId = $quizId;
    }

    public void set$time(String $time) {
        this.time = $time;
    }

    public int get$maxScore() {
        return maxScore;
    }

    public int get$noq() {
        return noq;
    }

    public int get$quizId() {
        return quizId;
    }

    public String get$createdBy() {
        return createdBy;
    }


    public String get$description() {
        return description;
    }

    public String get$name() {
        return name;
    }

    public String get$time() {
        return time;
    }

}

