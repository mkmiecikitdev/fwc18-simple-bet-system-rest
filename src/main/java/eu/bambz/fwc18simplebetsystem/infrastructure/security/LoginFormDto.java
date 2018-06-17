package eu.bambz.fwc18simplebetsystem.infrastructure.security;

import lombok.Getter;

import javax.validation.constraints.NotNull;


@Getter
class LoginFormDto {

    @NotNull
    private String login;

    @NotNull
    private String password;

}
