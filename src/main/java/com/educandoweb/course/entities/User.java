package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity //você está dizendo ao JPA que essa classe representa uma tabela no banco de dados, e cada instância dessa classe será um registro (linha) nessa tabela.

@Table(name = "tb_user")//O nome da tabela será, por padrão, o nome da classe. No caso, será User (mas você pode alterar o nome da tabela com a anotação @Table).
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id // Define o campo id como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define como o valor da chave primária (ID) será gerado. O valor GenerationType.IDENTITY informa ao banco de dados que ele deve ser responsável por gerar esse valor (geralmente usando auto-incremento).
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {
    }
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
