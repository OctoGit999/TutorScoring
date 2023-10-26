package dev.kal.tutor.service;

import dev.kal.tutor.model.Question;
import dev.kal.tutor.model.Questionnaire;

public class TutorScoreServiceImpl implements TutorScoreService {
    /**
     *
     * @param questionnaire {@link Questionnaire}
     *
     * This method runs through all the questions in given questionnaire and calculates
     * the sum of all scores based on user selected answers for those questions.
     * Note - Questionnaire object passed as parameter is updated with score value and
     * a flag indicating that it has been scored.
     *
     * @throws IllegalStateException if Questionnaire is already scored
     */
    public void calculateScore(Questionnaire questionnaire) {
        if(questionnaire.isScored()) {
            throw new IllegalStateException("Questionnaire already scored!");
        }

        int totalScore = questionnaire.getQuestions().stream()
                .mapToInt(Question::calculateScore)
                .sum();

        questionnaire.setScore(totalScore);
        questionnaire.setScored(true);
    }
}

