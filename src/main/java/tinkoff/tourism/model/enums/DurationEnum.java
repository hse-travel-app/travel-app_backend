package tinkoff.tourism.model.enums;

public enum DurationEnum {
    SHORT(new int[]{2, 3}),
    MEDIUM(new int[]{4, 5, 6}),
    LONG(new int[]{7, 8});

    private final int[] possibleNumberOfPlaces;

    DurationEnum(int[] places) {
        possibleNumberOfPlaces = places;
    }

    public int[] getPossibleNumberOfPlaces() {
        return this.possibleNumberOfPlaces;
    }
}
