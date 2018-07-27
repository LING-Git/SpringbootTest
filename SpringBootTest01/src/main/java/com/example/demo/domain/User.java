package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id ;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private Integer age ;

    public User( String name, Integer age ) {
        this.name = name;
        this.age = age;
    }
}
