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
@Table(name = "friends", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Friend implements Serializable {
    @Id
    @SequenceGenerator(name = "friend_id_seq", sequenceName = "friend_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friend_id_seq")
    @Column(name = "id", updatable = false)
    private Long Id;
    @Column(name = "idfriend")
    private Long idfriend;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Friend(Long idfriend) {
        this.idfriend = idfriend;

    }

    public Friend() {
        System.out.println("hello i am her");
    }

    /*public Long getId() {
        return this.Id;
    }*/

    public Long getIdFriend() {
        return idfriend;
    }

    public User getUser() {
        return this.user;
    }

   /* public void setId(Long Id) {
        this.Id = Id;
    }*/

    public void setfriend(User user) {
        this.user = user;
    }

    public void setIdFriend(Long idfriend) {
        this.idfriend = idfriend;
    }

}
