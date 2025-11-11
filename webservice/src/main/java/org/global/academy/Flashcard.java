package org.global.academy;

public class Flashcard {
    private String front;
    private String back;
    private boolean learned;

    public Flashcard(String front, String back) {
        this.front = front;
        this.back = back;
        this.learned = false;
    }

    public String getFront() { return front; }
    public void setFront(String s) { front = s; }

    public String getBack() { return back; }
    public void setBack(String s) { back = s; }

    public boolean isLearned() { return learned; }
    public void setLearned(boolean b) { learned = b; }
}
