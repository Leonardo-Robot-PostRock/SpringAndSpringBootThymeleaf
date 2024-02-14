package com.springbloom.SpringBloom.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data//Acceso a todos los metodos get, set y toString
@Entity//Pojo
@Table(name = "person")//solución a letra mayúscula de Person to person of the database.
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long idPerson;
    private  String name;
    private  String surname;
    private  String email;
    private  String phone;
}
