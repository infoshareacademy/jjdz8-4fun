package com.infoshare.fourfan.servlet.utils;

import javax.enterprise.context.RequestScoped;
import java.util.Optional;

@RequestScoped
public class WebInfPathResolver {

    private String webInfPath;

    public void setWebInfPath(String webInfPath) {
        this.webInfPath = webInfPath;
    }

    public String getJsonRepositoryPath() {
        Optional<String> webInfPath = Optional.of(this.webInfPath);
        return webInfPath.map(s -> s + "/json-repository/").orElse("");
    }
}