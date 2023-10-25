package dev.kal.service;

import dev.kal.model.Questionnaire;

public interface TutorScoreService {

    /**
     *
     * @param questionnaire {@link dev.kal.model.Questionnaire}
     *
     * This method runs through all the questions in given questionnaire and calculates
     * the sum of all scores based on user selected answers for those questions.
     * Note - Questionnaire object passed as parameter is updated with score value and
     * a flag indicating that it has been scored.
     *
     * @throws IllegalStateException if Questionnaire is already scored
     */
    void calculateScore(Questionnaire questionnaire);
}
