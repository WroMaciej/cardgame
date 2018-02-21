package wromaciej.cardgame.model;

public enum CardRank {
    TWO("Two", "2", 2),
    THREE("Three", "3", 3),
    FOUR("Four", "4", 4),
    FIVE("Five", "5", 5),
    SIX("Six", "6", 6),
    SEVEN("Seven", "7", 7),
    EIGHT("Eight", "8", 8),
    NINE("Nine", "9", 9),
    TEN("Ten", "10", 10),
    JACK("Jack", "J", 11),
    QUEEN("Quees", "Q", 12),
    KING("King", "K", 13),
    ACE("Ace", "A", 14);

    String fullName;
    String shortName;
    int rankValue;

    CardRank(String fullName, String shortName, int rankValue) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.rankValue = rankValue;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getRankValue() {
        return rankValue;
    }
}
