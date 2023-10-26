package dev.kal.tutor.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SingleSelectQuestionTest {

    private SingleSelectQuestion singleSelectQuestion;
    private Answer a1, a2, a3, a4;

    @BeforeEach
    public void init() {
        a1 = new Answer(1, "0-1 years", 0);
        a2 = new Answer(2, "1-2 years", 1);
        a3 = new Answer(3, "3 or more", 2);
        a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);

        singleSelectQuestion = new SingleSelectQuestion(
                "How much overall tutoring experience do you have?",
                answers);
    }

    @Test
    void testScoreNothingSelected() {
        // No answer selected, all answers un-selected by default
        assertEquals(0, singleSelectQuestion.calculateScore());
    }

    @Test
    void testScoreSingleSelected() {
        // select only one answer
        a3.setSelected(true);

        assertEquals(2, singleSelectQuestion.calculateScore());
    }
}
