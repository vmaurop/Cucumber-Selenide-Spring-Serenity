package com.vmaurop.bdd.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.net.URL;

@Getter
@Setter
public class GoogleConfig {
    @NotNull
    private URL url;
    private URL urlAPI;
    @NotNull
    private Users users = new Users();


    @Getter
    @Setter
    public static class Users {
        @NotNull
        private User admin;
    }



}
