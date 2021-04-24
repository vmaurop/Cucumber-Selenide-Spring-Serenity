package com.vmaurop.bdd.configuration;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class User {
    @NotNull
    private String userName;
    @NotNull
    private String password;

}
