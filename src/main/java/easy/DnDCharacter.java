package easy;

import java.util.Random;

class DnDCharacter {

    private final int constitution = ability();
    private final int strength = ability();
    private final int dexterity = ability();
    private final int intelligence = ability();
    private final int wisdom = ability();
    private final int charisma = ability();

    int ability() {
        return new Random().ints(4, 1, 7).skip(1).sum();
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10.0) / 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(constitution);
    }

}
