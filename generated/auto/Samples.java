package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="samples")
public class Samples {

    @Column(name="count")
    public int count;

}
