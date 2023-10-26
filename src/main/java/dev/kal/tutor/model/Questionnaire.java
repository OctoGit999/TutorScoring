package dev.kal.tutor.model;

import java.util.List;

public class Questionnaire {

    private final List<Question> questions;
    private final long tutorId;
    private boolean isScored;
    private int score;

    public Questionnaire(List<Question> questions, long tutorId) {
        this.questions = questions;
        this.tutorId = tutorId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public boolean isScored() {
        return isScored;
    }

    public void setScored(boolean scored) {
        isScored = scored;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getTutorId() {
        return tutorId;
    }

}
