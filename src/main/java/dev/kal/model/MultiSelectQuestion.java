package dev.kal.model;

import java.util.List;

/**
 * Subclass of {@link dev.kal.model.Question} that represents a multiple choice question
 * i.e. user can select multiple answers from the list of options given
 */
public class MultiSelectQuestion extends Question {
    public MultiSelectQuestion(String text, List<Answer> answers) {
        super(text, answers);
    }

    /**
     * {@inheritDoc}
     * Assumption here is that the user is allowed to select multiple answers
     * from the list of options. This method returns the sum of scores associated with
     * all the selected answers
     */
    @Override
    public int calculateScore() {
        return this.answers.stream()
                .filter(Answer::isSelected)
                .mapToInt(Answer::getScore)
                .sum();
    }
}
