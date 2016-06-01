package com.gagauz.javaee.jaxrs.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JaxbBean1 {
    public String name;
    public int age;

    public JaxbBean1() {
    }

    public JaxbBean1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
