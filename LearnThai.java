package LabTuto03;

import java.util.ArrayList;
import java.util.List;

public class LearnThai {

    // M1: Create mid-tone consonant list
    public static List<ThaiConsonantFlashCard> createMidToneCards() {
        List<ThaiConsonantFlashCard> ThaiConsonantsCards = new ArrayList<>();

        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("ก", "ko kai", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("จ", "cho chan", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("ฎ", "do cha-da", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("ฏ", "to pa-tak", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("ด", "do dek", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("ต", "to tao", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("บ", "bo baimai", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("ป", "po pla", "Mid"));
        ThaiConsonantsCards.add(new ThaiConsonantFlashCard("อ", "o ang", "Mid"));

        return ThaiConsonantsCards;
    }

    // M4: Check if all cards are learned
    public static boolean allLearned(List<ThaiConsonantFlashCard> cards) {
        for (ThaiConsonantFlashCard card : cards) {
            if (!card.isLearned()) return false;
        }
        return true;
    }

    // M5: Main function (sequential flow)
    public static void main(String[] args) {
        List<ThaiConsonantFlashCard> thaiCards = createMidToneCards();

        for (int i = 0; i < thaiCards.size(); i++) {
            ThaiConsonantFlashCard card = thaiCards.get(i);

            // Keep showing this card until it is learned
            while (!card.isLearned()) {
                card.showCard(i);  // blocks until window closes
            }
        }

        System.out.println("🎉 All cards learned!");
    }
}
