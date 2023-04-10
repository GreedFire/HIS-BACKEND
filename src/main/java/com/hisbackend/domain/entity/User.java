package com.hisbackend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "User.signIn",
                query = "UPDATE USERS SET SIGNED_IN = 'TRUE' WHERE ID = :ID",
                resultClass = User.class
        ),

        @NamedNativeQuery(
                name = "User.signOut",
                query = "UPDATE USERS SET SIGNED_IN = 'FALSE' WHERE ID = :ID",
                resultClass = User.class
        ),

})

@Data
@AllArgsConstructor
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private boolean signedIn;

    public User() {

    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.signedIn = false;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}


