package tinkoff.tourism.controller.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tinkoff.tourism.model.enums.TypeEnum;
import tinkoff.tourism.validation.RouteRequestConstraint;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RouteRequestConstraint

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteRequest {

    List<TypeEnum> categories;
    String startTime;
    String endTime;

    @PositiveOrZero
    Integer budget;
}
