package ar.com.whiskydb.whiskydb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {
    @Id
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
