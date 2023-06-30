package com.alston.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="member")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(generator="nano_id")
    @GenericGenerator(name="nano_id", strategy = "com.alston.utils.IdGenerator")
    private String id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    public Member() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}