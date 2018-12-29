package com.diaosichengxuyuan.spring.boot.dao.test.entity;

import javax.persistence.*;

@Table(name = "test")
public class TestDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name1;

    private String name2;

    private String name3;

    private Short age;

    private String location;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name1
     */
    public String getName1() {
        return name1;
    }

    /**
     * @param name1
     */
    public void setName1(String name1) {
        this.name1 = name1;
    }

    /**
     * @return name2
     */
    public String getName2() {
        return name2;
    }

    /**
     * @param name2
     */
    public void setName2(String name2) {
        this.name2 = name2;
    }

    /**
     * @return name3
     */
    public String getName3() {
        return name3;
    }

    /**
     * @param name3
     */
    public void setName3(String name3) {
        this.name3 = name3;
    }

    /**
     * @return age
     */
    public Short getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Short age) {
        this.age = age;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }
}