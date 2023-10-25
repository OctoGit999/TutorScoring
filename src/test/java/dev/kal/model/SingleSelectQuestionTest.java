package dev.kal.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SingleSelectQuestionTest {

    @Test
    void testScoreNothingSelected() {
        Answer a1 = new Answer(1, "0-1 years", 0);
        Answer a2 = new Answer(2, "1-2 years", 1);
        Answer a3 = new Answer(3, "3 or more", 2);
        Answer a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);

        SingleSelectQuestion singleSelectQuestion = new SingleSelectQuestion(
                "How much overall tutoring experience do you have?",
                answers);

        assertEquals(0, singleSelectQuestion.calculateScore());
    }

    @Test
    void testScoreSingleSelected() {
        Answer a1 = new Answer(1, "0-1 years", 0);
        Answer a2 = new Answer(2, "1-2 years", 1);
        Answer a3 = new Answer(3, "3 or more", 2);
        Answer a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);
        a3.setSelected(true);
        SingleSelectQuestion singleSelectQuestion = new SingleSelectQuestion(
                "How much overall tutoring experience do you have?",
                answers);

        assertEquals(2, singleSelectQuestion.calculateScore());
    }
}
