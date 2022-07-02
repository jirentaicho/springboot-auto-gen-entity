package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="items")
public class Items {

    @Id
    public int id;
    @Column(name="name")
    public String name;

}
