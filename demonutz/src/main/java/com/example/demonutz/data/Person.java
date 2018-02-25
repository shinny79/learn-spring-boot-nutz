package com.example.demonutz.data;


import org.nutz.dao.entity.annotation.*;
import org.nutz.plugin.spring.boot.service.entity.DataBaseEntity;

@Table("person")
public class Person extends DataBaseEntity {

    @Id
    private long id;

    @Name
    private String name;

    @Column("properties")
    @ColDefine(width = 200)
    @Default("")
    private String properties;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
