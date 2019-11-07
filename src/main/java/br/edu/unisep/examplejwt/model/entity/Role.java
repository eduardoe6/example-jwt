package br.edu.unisep.examplejwt.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="roles")
public class Role {

    @Id
    @Column(name="id_role")
    private String id;

    @Column(name="ds_role")
    private String name;

}
