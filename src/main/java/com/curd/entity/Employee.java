package com.curd.entity;


import lombok.Data;

import javax.persistence.*;


@Table
@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String location;

}
