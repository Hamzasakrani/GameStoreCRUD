package com.springproject.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "games")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Game {
    @Id
    @SequenceGenerator(name = "game_id", sequenceName = "game_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
   
    private Long Id;
    @Column(name = "title")
    private String title;
    @Column(name = "url")
    private String url;

    Game(String title, String url) {
        this.title = title;
        this.url = url;
    }

    Game() {
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
