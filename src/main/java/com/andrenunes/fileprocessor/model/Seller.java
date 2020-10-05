package com.andrenunes.fileprocessor.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Seller extends Model implements Serializable {

    private static final long serialVersionUID = -4838050520744082549L;

    private String cpf;
    private String name;
    private BigDecimal salary;

    public Seller(String cpf, String name, BigDecimal salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public Seller() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
