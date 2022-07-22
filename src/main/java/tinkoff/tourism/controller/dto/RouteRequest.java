package tinkoff.tourism.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tinkoff.tourism.model.enums.DurationEnum;
import tinkoff.tourism.model.enums.SightTypeEnum;
import tinkoff.tourism.validation.RouteRequestConstraint;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RouteRequestConstraint

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteRequest {
    @NotEmpty
    List<SightTypeEnum> categories;
    String startTime;
    String endTime;
    @PositiveOrZero
    Integer budget;
    DurationEnum duration;
}
