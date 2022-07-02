package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="subs")
public class Subs {

    @Column(name="count")
    public int count;

}
