package edu.caferrerb.personConsumer.model.msj;

public class PersonMessage {

    private String name;
    private String cedula;
    private String email;

    public PersonMessage() {
    }

    public PersonMessage(String name, String cedula, String email) {
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
