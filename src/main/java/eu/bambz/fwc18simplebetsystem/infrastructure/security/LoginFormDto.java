package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
class LoginFormDto {

    @NotNull
    private String login;

    @NotNull
    private String password;

}
