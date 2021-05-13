package com.springproject.game.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usergames", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserGame implements Serializable {
    @Id
    @SequenceGenerator(name = "usergame_id_seq", sequenceName = "usergame_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usergame_id_seq")
    @Column(name = "id", updatable = false)
    private Long Id;
    @Column(name = "idgame")
    private Long idgame;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public UserGame(Long idgame) {
        this.idgame = idgame;
    }

    public UserGame() {
    }

    public Long getId() {
        return this.Id;
    }

    public Long getGame() {
        return this.idgame;
    }

    public User getUser() {
        return this.user;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setGame(User user) {
        this.user = user;
    }

    public void setIdGame(Long idgame) {
        this.idgame = idgame;
    }
}
