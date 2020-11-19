package com.samples.common;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Objects;

@SpaceClass
public class Cellphone extends Product implements java.io.Serializable {

    private static final long serialVersionUID = 0L;

    private Integer id;
    private String name;
    private String code;
    private String model;
    private String brand;

    public Cellphone() {}

    @Override
    public String getCode() {
        return code;
    }
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @SpaceId
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cellphone cellphone = (Cellphone) o;
        return Objects.equals(id, cellphone.id) &&
                Objects.equals(name, cellphone.name) &&
                Objects.equals(code, cellphone.code) &&
                Objects.equals(model, cellphone.model) &&
                Objects.equals(brand, cellphone.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, model, brand);
    }
}
