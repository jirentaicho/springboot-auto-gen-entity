package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="stocks")
public class Stocks {

    @Column(name="count")
    public int count;

}
