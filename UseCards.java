package LabTuto03;

import java.util.ArrayList;
import java.util.List;

public class UseCards {
    public static void main(String[] args) {
        // E1: Create a list of ThaiConsonantFlashCards (1 line)
        List<ThaiConsonantFlashCard> cards = new ArrayList<>();

        // E2: Put 3 Thai consonants into the list
        cards.add(new ThaiConsonantFlashCard("ก (กอ ไก่)", "ko kai", "Mid"));
        cards.add(new ThaiConsonantFlashCard("ข (ขอ ไข่)", "kho khai", "High"));
        cards.add(new ThaiConsonantFlashCard("ค (คอ ควาย)", "kho khwai", "Low"));

        // E3: Print the value of learned for each
        for (ThaiConsonantFlashCard card : cards) {
            System.out.println(card.getFront() + " → Learned? " + card.isLearned());
            card.showCard(0);
        }
    }
}
