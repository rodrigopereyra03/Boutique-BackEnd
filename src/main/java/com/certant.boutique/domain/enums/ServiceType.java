package com.certant.boutique.domain.enums;

public enum ServiceType {

    ALINEACION_BASICO("Alineacion y balanceo"),
    ALINEACION_COMPLETO( "Alineacion y balanceo con cambio de cubiertas"),
    LAVADO_BASICO("Basico"),
    LAVADO_COMPLETO("Completo"),
    LAVADO_PREMIUM("Premium"),
    ACEITE_BASICO("Basico"),
    ACEITE_COMPLETO("Alto rendimiento, motores diesel o nafteros");

    private final String description;

    private ServiceType (String description){
        this.description = description;

    }

    public String getDescription() {
        return description;
    }
}
