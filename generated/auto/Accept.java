package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="accept")
public class Accept {

    @Column(name="count")
    public int count;
    @Column(name="customer_name")
    public String customer_name;

}
