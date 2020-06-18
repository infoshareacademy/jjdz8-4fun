package com.infoshare.fourfan.servlet.config;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class WebInfPathResolver {

private String webInfPath;

public void setWebInfPath(String webInfPath) {
    this.webInfPath = webInfPath;
}

public String getFilePath(String fileName) {
    return !webInfPath.isEmpty() ? webInfPath + "/classes/" + fileName : Objects.requireNonNull(getClass().getClassLoader()
            .getResource(fileName))
            .getPath();
    }
}
