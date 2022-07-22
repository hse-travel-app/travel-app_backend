package tinkoff.tourism.model.sights;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tinkoff.tourism.model.enums.SightTypeEnum;
import tinkoff.tourism.validation.sights.SightConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@SightConstraint

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Sight {
    Long id;
    @NotBlank
    String name;
    @NotNull
    SightTypeEnum type;
    Double coordinateX;
    Double coordinateY;
    String description;
    String siteLink;
    String openTime;
    String closeTime;
    @PositiveOrZero
    int price;
}
