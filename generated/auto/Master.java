package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="master")
public class Master {

    @Column(name="count")
    public int count;

}
