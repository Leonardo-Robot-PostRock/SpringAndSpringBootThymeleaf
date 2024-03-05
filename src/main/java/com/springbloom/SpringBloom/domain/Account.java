package com.springbloom.SpringBloom.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author mrRobot
 */

@Entity
@Data
@Table(name="account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Rol> roles;

}
