package com.example.pfeesprit.entities;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Rating {
    @Id
    @GeneratedValue
    private int idRating;
    @ManyToOne
    private User user;
    @Column
    private Long points;

    public Rating() {
        throw new Error("Unresolved compilation problems: \n\tThe declared package \"esprit.pidev.entities\" does not match the expected package \"src.main.java.esprit.pidev.entities\"\n\tThe import java.io cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tSerializable cannot be resolved to a type\n\tId cannot be resolved to a type\n\tGeneratedValue cannot be resolved to a type\n\tGenerationType cannot be resolved to a variable\n\tManyToOne cannot be resolved to a type\n\tColumn cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tThe constructor Object() is undefined\n\tLong cannot be resolved to a type\n\tThe constructor Object() is undefined\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n");
    }

    public Rating(int var1, User var2, Long var3) {
        throw new Error("Unresolved compilation problems: \n\tThe declared package \"esprit.pidev.entities\" does not match the expected package \"src.main.java.esprit.pidev.entities\"\n\tThe import java.io cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tThe import javax cannot be resolved\n\tSerializable cannot be resolved to a type\n\tId cannot be resolved to a type\n\tGeneratedValue cannot be resolved to a type\n\tGenerationType cannot be resolved to a variable\n\tManyToOne cannot be resolved to a type\n\tColumn cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tThe constructor Object() is undefined\n\tLong cannot be resolved to a type\n\tThe constructor Object() is undefined\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n");
    }

    public int getIdRating() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setIdRating(int var1) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public User getUser() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setUser(User var1) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public Long getPoints() {
        throw new Error("Unresolved compilation problems: \n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n");
    }

    public void setPoints(Long var1) {
        throw new Error("Unresolved compilation problems: \n\tLong cannot be resolved to a type\n\tLong cannot be resolved to a type\n");
    }
}

