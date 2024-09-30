package com.example.test1.controllers;

import com.example.test1.commons.Genre;
import com.example.test1.config.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
    private final Genre actionGenre;
    private Genre anotherActionGenre;
    private final Genre comedyGenre;
    private final Genre horrorGenre;

    private final CustomProperties customProperties;

    @Autowired
    public GenreController(
            @Qualifier("action") Genre actionGenre,
            @Qualifier("comedy") Genre comedyGenre,
            @Qualifier("horror") Genre horrorGenre,
            CustomProperties customProperties) {
        this.actionGenre = actionGenre;
        this.comedyGenre = comedyGenre;
        this.horrorGenre = horrorGenre;
        this.customProperties = customProperties;
    }

    @Autowired
    public void setAnotherActionGenre(@Qualifier("action") Genre anotherActionGenre) {
        this.anotherActionGenre = anotherActionGenre;
    }

    @GetMapping("/action")
    public String actionDesc() {
        return actionGenre.gereDescription();
    }

    @GetMapping("/comedy")
    public String comedyDesc() {
        return comedyGenre.gereDescription();
    }

    @GetMapping("/genre-checker")
    public String genreChecker() {
        return "Two genre equal? " + (actionGenre == anotherActionGenre);
    }

    @GetMapping("/horror")
    public String horrorDesc() {
        return horrorGenre.gereDescription();
    }

    @GetMapping("/build")
    public String getBuildVersion() {
        return customProperties.getBuildVersion();
    }

    @GetMapping("/java")
    public String getJavaVersion() {
        return customProperties.getJavaVersion();
    }
}
