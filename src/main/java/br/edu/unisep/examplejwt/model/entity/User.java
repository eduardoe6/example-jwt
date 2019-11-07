package br.edu.unisep.examplejwt.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> roles;

}
