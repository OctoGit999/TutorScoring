package dev.kal.tutor.service;

import dev.kal.tutor.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TutorScoreServiceTest {

    private static TutorScoreService tutorScoreService;

    private MultiSelectQuestion multiSelectQuestion;
    private SingleSelectQuestion singleSelectQuestion;
    
    private Answer a1, a2, a3, a4, a5, a6, a7, a8;

    @BeforeAll
    public static void setup() {        
        tutorScoreService = new TutorScoreServiceImpl();
    }

    @BeforeEach
    public void init() {
        // set up multi-select question
        a1 = new Answer(1, "Online tutoring", 1);
        a2 = new Answer(2, "Home schooling", 1);
        a3 = new Answer(3, "After school club", 1);
        a4 = new Answer(3, "None", 0);
        List<Answer> answers = List.of(a1, a2, a3, a4);
        multiSelectQuestion = new MultiSelectQuestion(
                "What kind of tutoring experience do you have?",
                answers);

        // set up single select question
        a5 = new Answer(5, "0-1 years", 0);
        a6 = new Answer(6, "1-2 years", 1);
        a7 = new Answer(7, "3 or more", 2);
        a8 = new Answer(8, "None", 0);
        List<Answer> answers2 = List.of(a5, a6, a7, a8);
        singleSelectQuestion = new SingleSelectQuestion(
                "How much overall tutoring experience do you have?",
                answers2);
    }

    @Test
    public void testScoreSingleSelectOnly() {
        // Questionnaire contains both questions, only the single select question answered
        List<Question> questions = List.of(multiSelectQuestion, singleSelectQuestion);
        Questionnaire questionnaire = new Questionnaire(questions, 1);
        a7.setSelected(true);

        tutorScoreService.calculateScore(questionnaire);

        assertEquals(2, questionnaire.getScore());
        assertTrue(questionnaire.isScored());
    }

    @Test
    public void testScoreMultiSelectOnly() {
        // Questionnaire contains both questions, only the multi select question answered with 2 answers
        List<Question> questions = List.of(multiSelectQuestion, singleSelectQuestion);
        Questionnaire questionnaire = new Questionnaire(questions, 1);
        a2.setSelected(true);
        a3.setSelected(true);
        
        tutorScoreService.calculateScore(questionnaire);

        assertEquals(2, questionnaire.getScore());
        assertTrue(questionnaire.isScored());
    }

    @Test
    public void testScoreSingleSelectAndMultiSelect() {
        // Questionnaire contains both questions, both answered
        List<Question> questions = List.of(multiSelectQuestion, singleSelectQuestion);
        Questionnaire questionnaire = new Questionnaire(questions, 1);
        a2.setSelected(true);
        a3.setSelected(true);
        a7.setSelected(true);
        tutorScoreService.calculateScore(questionnaire);

        assertEquals(4, questionnaire.getScore());
        assertTrue(questionnaire.isScored());
    }
}
