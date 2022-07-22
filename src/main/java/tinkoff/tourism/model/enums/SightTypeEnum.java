package tinkoff.tourism.model.enums;

public enum SightTypeEnum {
    BAR("BAR"), CAFE("CAFE"), MUSEUM("MUSEUM"), STREET("STREET");

    public final String name;

    SightTypeEnum(String s) {
        this.name = s;
    }
}
