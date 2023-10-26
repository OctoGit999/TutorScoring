package dev.kal.tutor.model;

import java.util.List;

/**
 * Subclass of {@link Question} that represents a single choice question
 * i.e. user can select only one answer from the list of options given
 */
public class SingleSelectQuestion extends Question {

    public SingleSelectQuestion(String text, List<Answer> answers) {
        super(text, answers);
    }

    /**
     * {@inheritDoc}
     * Assumption here is that the user is allowed to select only one answer
     * from the list of options. This method returns the score associated with that
     * one answer
     */
    @Override
    public int calculateScore() {
        // find the first answer that is selected and return its score
        return this.answers.stream()
                .filter(Answer::isSelected)
                .findFirst()
                .map(Answer::getScore)
                .orElse(0);
    }
}
