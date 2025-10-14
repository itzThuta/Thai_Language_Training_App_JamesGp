package LabTuto03;

import javax.swing.*;
import java.awt.*;

public class Flashcard {
    private String front = "";
    private String back = "";
    private boolean learned = false;

    public Flashcard(String front, String back) {
        this.front = front;
        this.back = back;
        this.learned = false;
    }

    public void setFront(String s) { front = s; }
    public String getFront() { return front; }

    public void setBack(String s) { back = s; }
    public String getBack() { return back; }

    public void setLearned(boolean b) { learned = b; }
    public boolean isLearned() { return learned; }

    /**
     * Show flashcard window with buttons.
     * Blocks until user clicks one of the buttons and closes the window.
     */
    public void showCard(int index) {
        final JDialog dialog = new JDialog((Frame) null, "Flashcard", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new BorderLayout());

        JLabel label = new JLabel(front + " → " + back, SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        dialog.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton repeatBtn = new JButton("Repeat");
        JButton learnedBtn = new JButton("Learned already");
        buttonPanel.add(repeatBtn);
        buttonPanel.add(learnedBtn);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        repeatBtn.addActionListener(e -> {
            System.out.println("Repeat " + index);
            dialog.dispose();
        });

        learnedBtn.addActionListener(e -> {
            setLearned(true);
            System.out.println("Learned");
            System.out.println(index);
            dialog.dispose();
        });

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true); // blocks until dispose() is called
    }
}
