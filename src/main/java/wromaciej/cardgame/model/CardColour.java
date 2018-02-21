package wromaciej.cardgame.model;

public enum CardColour {
    HEARTS("Hearts", "He", 100),
    DIAMONDS("Diamonds", "Di", 200),
    CLUBS("Clubs", "Cl", 300),
    SPADES("Spades", "Sp", 400);

    String fullName;
    String shortName;
    int colourValue;

    CardColour(String fullName, String shortName, int colourValue) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.colourValue = colourValue;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getColourValue() {
        return colourValue;
    }
}
