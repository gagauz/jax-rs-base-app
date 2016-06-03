package com.gagauz.javaee.jaxrs.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SomeBean {
    private String name;
    private int age;

    public SomeBean() {
    }

    public SomeBean(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @NotNull(message = "{SomeBean.name.notnull}")
    @Size(min = 2, message = "{SomeBean.name.size}")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value = 18, message = "{SomeBean.age.size}")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
