package dev.kal.tutor.model;

import dev.kal.tutor.model.Answer;
import dev.kal.tutor.model.MultiSelectQuestion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MultiSelectQuestionTest {

    @Test
    void testScoreNothingSelected() {
        Answer a1 = new Answer(1, "Online tutoring", 1);
        Answer a2 = new Answer(2, "Home schooling", 1);
        Answer a3 = new Answer(3, "After school club", 1);
        Answer a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);

        MultiSelectQuestion multiSelectQuestion = new MultiSelectQuestion(
                "What kind of tutoring experience do you have?",
                answers);

        assertEquals(0, multiSelectQuestion.calculateScore());
    }

    @Test
    void testScoreSingleSelected() {
        Answer a1 = new Answer(1, "Online tutoring", 1);
        Answer a2 = new Answer(2, "Home schooling", 1);
        Answer a3 = new Answer(3, "After school club", 1);
        Answer a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);
        a3.setSelected(true);
        MultiSelectQuestion multiSelectQuestion = new MultiSelectQuestion(
                "What kind of tutoring experience do you have?",
                answers);

        assertEquals(1, multiSelectQuestion.calculateScore());
    }

    @Test
    void testScoreMultiSelected() {
        Answer a1 = new Answer(1, "Online tutoring", 1);
        Answer a2 = new Answer(2, "Home schooling", 1);
        Answer a3 = new Answer(3, "After school club", 1);
        Answer a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);
        a2.setSelected(true);
        a3.setSelected(true);
        MultiSelectQuestion multiSelectQuestion = new MultiSelectQuestion(
                "What kind of tutoring experience do you have?",
                answers);

        assertEquals(2, multiSelectQuestion.calculateScore());
    }
}
