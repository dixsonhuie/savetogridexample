package com.samples.common;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;

import java.util.Objects;

@SpaceClass
public class Car extends Product implements java.io.Serializable {

    private static final long serialVersionUID = 0L;

    // needed for Product
    private Integer id;
    private String name;
    private String code;

    // needed for Car
    private String model;
    private String make;

    public Car() {}

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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(name, car.name) &&
                Objects.equals(code, car.code) &&
                Objects.equals(model, car.model) &&
                Objects.equals(make, car.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, model, make);
    }
}
