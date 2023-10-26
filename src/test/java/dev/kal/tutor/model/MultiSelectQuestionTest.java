package dev.kal.tutor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MultiSelectQuestionTest {
    private MultiSelectQuestion multiSelectQuestion;
    private Answer a1, a2, a3, a4;

    @BeforeEach
    public void init() {
        a1 = new Answer(1, "Online tutoring", 1);
        a2 = new Answer(2, "Home schooling", 1);
        a3 = new Answer(3, "After school club", 1);
        a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);

        multiSelectQuestion = new MultiSelectQuestion(
                "What kind of tutoring experience do you have?",
                answers);
    }

    @Test
    void testScoreNothingSelected() {
        // No answer selected, all answers un-selected by default
        assertEquals(0, multiSelectQuestion.calculateScore());
    }

    @Test
    void testScoreSingleSelected() {
        // select only one answer
        a3.setSelected(true);

        assertEquals(1, multiSelectQuestion.calculateScore());
    }

    @Test
    void testScoreMultiSelected() {
        // select multiple answers
        a2.setSelected(true);
        a3.setSelected(true);

        assertEquals(2, multiSelectQuestion.calculateScore());
    }
}
