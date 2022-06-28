package tinkoff.tourism.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tinkoff.tourism.validation.UserConstraint;

import javax.validation.constraints.NotBlank;

@UserConstraint

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    Long id;
    @NotBlank
    String name;
    @NotBlank
    String login;
    @NotBlank
    String password;
    @NotBlank
    String authority;
}
