package dev.kal.service;

import dev.kal.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TutorScoreServiceTest {

    static TutorScoreService tutorScoreService;

    MultiSelectQuestion multiSelectQuestion;
    SingleSelectQuestion singleSelectQuestion;

    @BeforeAll
    public static void setup() {
        tutorScoreService = new TutorScoreServiceImpl();
    }

    @BeforeEach
    public void init() {
        Answer a1 = new Answer(1, "Online tutoring", 1);
        Answer a2 = new Answer(2, "Home schooling", 1);
        Answer a3 = new Answer(3, "After school club", 1);
        Answer a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);
        a2.setSelected(true);
        a3.setSelected(true);
        multiSelectQuestion = new MultiSelectQuestion(
                "What kind of tutoring experience do you have?",
                answers);


        Answer a5 = new Answer(5, "0-1 years", 0);
        Answer a6 = new Answer(6, "1-2 years", 1);
        Answer a7 = new Answer(7, "3 or more", 2);
        Answer a8 = new Answer(8, "None", 0);
        List<Answer> answers2 = List.of(a5, a6, a7, a8);
        a7.setSelected(true);
        singleSelectQuestion = new SingleSelectQuestion(
                "How much overall tutoring experience do you have?",
                answers2);
    }

    @Test
    public void testScoreSingleSelectOnly() {
        List<Question> questions = List.of(singleSelectQuestion);

        Questionnaire questionnaire = new Questionnaire(questions, 1);
        tutorScoreService.calculateScore(questionnaire);

        assertEquals(2, questionnaire.getScore());
        assertTrue(questionnaire.isScored());
    }

    @Test
    public void testScoreMultiSelectOnly() {
        List<Question> questions = List.of(multiSelectQuestion);

        Questionnaire questionnaire = new Questionnaire(questions, 1);
        tutorScoreService.calculateScore(questionnaire);

        assertEquals(2, questionnaire.getScore());
        assertTrue(questionnaire.isScored());
    }

    @Test
    public void testScoreSingleSelectAndMultiSelect() {
        List<Question> questions = List.of(singleSelectQuestion, multiSelectQuestion);

        Questionnaire questionnaire = new Questionnaire(questions, 1);
        tutorScoreService.calculateScore(questionnaire);

        assertEquals(4, questionnaire.getScore());
        assertTrue(questionnaire.isScored());
    }
}
