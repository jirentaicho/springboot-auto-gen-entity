package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Items {

    @Column(name="id")
    public int id;
    @Column(name="name")
    public String name;

}
