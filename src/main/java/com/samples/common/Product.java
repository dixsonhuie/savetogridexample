package com.samples.common;

public abstract class Product implements java.io.Serializable {

    abstract public String getCode();
    abstract public void setCode(String code);

    abstract public String getName();
    abstract public void setName(String name);

    abstract public Integer getId();
    abstract public void setId(Integer id);

}
