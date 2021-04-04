package edu.caferrerb.personProducer.model;

public class Person {
    private String name;
    private String cedula;
    private String email;

    public Person() {
    }

    public Person(String name, String cedula, String email) {
        this.name = name;
        this.cedula = cedula;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
