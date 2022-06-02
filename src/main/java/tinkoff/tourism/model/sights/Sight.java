package tinkoff.tourism.model.sights;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tinkoff.tourism.validation.sights.SightConstraint;

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
    @NotBlank
    String type;
    Double coordinateX;
    Double coordinateY;
    String description;
    String siteLink;
    String openTime;
    String closeTime;
    @PositiveOrZero
    int price;
}
