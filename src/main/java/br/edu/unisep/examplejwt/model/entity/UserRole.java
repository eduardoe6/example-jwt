package br.edu.unisep.examplejwt.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_role")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @OneToOne
    @JoinColumn(name="id_role")
    private Role role;
}
