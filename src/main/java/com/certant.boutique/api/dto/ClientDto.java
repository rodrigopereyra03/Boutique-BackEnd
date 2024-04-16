package com.certant.boutique.api.dto;

public class ClientDto {

    private Long id;
    private int dni;
    private String name;
    private String lastName;
    private int servicesTaken;
    private boolean premium;

    public ClientDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getServicesTaken() {
        return servicesTaken;
    }

    public void setServicesTaken(int servicesTaken) {
        this.servicesTaken = servicesTaken;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
