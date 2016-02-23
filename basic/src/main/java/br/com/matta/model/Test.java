package br.com.matta.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by MFalzetta on 12/05/15.
 */
@Entity
@SequenceGenerator(name=Test.SEQUENCE_NAME, sequenceName=Test.SEQUENCE_NAME, allocationSize=1)
public class Test {

    public static final String SEQUENCE_NAME = "SEQ_TEST";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SEQUENCE_NAME)
    private long id;
    private String name;
    private String value;

    public Test() {
        super();
    }

    public Test(String name, String value) {
        super();
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
