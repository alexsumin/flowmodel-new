package ru.alexsumin.flowmodel.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id;

    private String password;

    public Account() {
    }

}
