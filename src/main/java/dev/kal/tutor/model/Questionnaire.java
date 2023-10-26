package dev.kal.tutor.model;

import java.util.List;

/**
 * A class that represents a set of questions presented to a specific tutor ,
 * answers selected by them to those questions and their overall score once the
 * scoring has been done
 */
public class Questionnaire {

    // Questions in this questionnaire, along with answers and user selections
    private final List<Question> questions;
    // Id of the Tutor this questionnaire was presented to
    private final long tutorId;
    // Flag that indicates if this questionnaire has been scored or not
    private boolean isScored;
    // Once the questionnaire has been scored, this contains the total score for the tutor
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
