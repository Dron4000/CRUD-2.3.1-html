package com.javaspringclub.entity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role  implements GrantedAuthority {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

     @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    public Role() {

    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role(Long id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> userSet) {
        this.users = userSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return getName();
    }
}
