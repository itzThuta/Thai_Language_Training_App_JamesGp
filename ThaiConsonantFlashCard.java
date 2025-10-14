package LabTuto03;

public class ThaiConsonantFlashCard extends Flashcard {
    private String toneClass;

    public ThaiConsonantFlashCard(String front, String back, String toneClass) {
        super(front + " (Tone: " + toneClass + ")", back);
        this.toneClass = toneClass;
    }

    public String getToneClass() { return toneClass; }
    public void setToneClass(String toneClass) { this.toneClass = toneClass; }
}
