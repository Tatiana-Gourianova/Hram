package com.gourianova.binocularvision.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


@Entity

public class User implements Serializable {


    @Setter
    @Id
    private int id; //TODO заменить тип на long? и в бд
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private BigDecimal balance;
    @Setter
    @Getter
    private LocalDate create_time;
    @Setter
    @Getter
    private String firstname;

    @Setter
    @Getter
    private String lastname;
    @Setter
    @Getter
    private String login;
    @Setter
    @Getter
    private String password;
    private int role_id; //TODO переделать тип Role и в бд


    public User() {

        this.create_time = LocalDate.now();
        this.role_id = 0;
    }

    public User(String firstName, String lastName, String email, String password, int userRole, int id) {
        this.create_time = LocalDate.now();
        this.firstname = firstName;
        this.lastname = lastName;
        this.login = email;
        this.password = password;
        this.role_id = userRole;
        this.id = id;
    }


    public User(UserRole userRole) {

        switch (userRole) {
            case ADMIN:
                this.role_id = 2;
                break;
            case USER:
                this.role_id = 1;
                break;
            default:
                this.role_id = 0;
        }
    }

    public User(BigDecimal bigDecimal, LocalDate now, String tatiana, String gourianova, String tg, String tatian, int i) {
        this.balance = bigDecimal;
        this.firstname = tatiana;
        this.lastname = gourianova;
        this.login = tg;
        this.password = tatian;
        this.role_id = i;
        this.create_time = now;

    }


    public long getId() {
        return id;
    }


    public int getRoleId() {
        return role_id;
    }

    public void setRoleId(int roleId) {
        this.role_id = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getFirstname(), user.getFirstname()) && Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getBalance(), user.getBalance()) && getRoleId() == user.getRoleId() && Objects.equals(getCreate_time(), user.getCreate_time());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getLastname(), getLogin(), getPassword(), getBalance(), getRoleId(), getCreate_time());
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstname + '\'' + ", lastName='" + lastname + '\'' + ", login='" + login + '\'' + ", password='" + password + '\'' + ", balance=" + balance + ", roleId=" + role_id + ", create_time=" + create_time + "} " + super.toString();
    }
}
