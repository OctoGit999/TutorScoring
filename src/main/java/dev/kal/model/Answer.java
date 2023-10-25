package dev.kal.model;

/**
 * A class that represents one of the possible choices for answering a {@link dev.kal.model.Question}
 */
public class Answer {

    // unique id
    private final int answerId;
    // text of the answer
    private final String text;
    // score associated with the answer
    private final int score;
    // flag that indicates if the user has selected this answer or not, false by default
    private boolean selected;

    public Answer(int answerId, String text, int score) {
        this.answerId = answerId;
        this.text = text;
        this.score = score;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;
    }

    public int getAnswerId() {
        return answerId;
    }
}
