package dev.kal.tutor.model;

import java.util.List;

/**
 * An abstract class that represents a Question in a Questionnaire
 * Known subclasses {@link MultiSelectQuestion} and {@link SingleSelectQuestion}
 */
public abstract class Question {
        // Text of the Question
        protected String text;
        // Possible list of answers for this question
        protected List<Answer> answers;

        protected Question(String text, List<Answer> answers) {
                this.text = text;
                this.answers = answers;
        }

        /**
         * Calculate the score of this question based on answer(s) user selected and their associated scores
         * @return integer value that indicates score of user selection for this question
         */
        public abstract int calculateScore();

        // TODO - Add methods to select and deselect either all or a specific answer
}

