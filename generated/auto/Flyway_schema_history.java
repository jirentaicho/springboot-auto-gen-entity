package com.volkruss.autogen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="flyway_schema_history")
public class Flyway_schema_history {

    @Column(name="success")
    public String success;
    @Column(name="installed_on")
    public java.util.Date installed_on;
    @Column(name="execution_time")
    public int execution_time;

}
