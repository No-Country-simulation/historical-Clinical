package model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "centromedico")
public class centroMedico {
    @Id
    private Integer nitCentroMedico;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String email;

    @OneToMany(mappedBy = "centroMedico")
    private List<historiaclinica> historiasClinicas;

    // Getters y setters

    public Integer getNitCentroMedico() {
        return nitCentroMedico;
    }

    public void setNitCentroMedico(Integer nitCentroMedico) {
        this.nitCentroMedico = nitCentroMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public centroMedico(){

    }

    public centroMedico(Integer nitCentroMedico, String nombre, String direccion, String telefono, String email) {
        this.nitCentroMedico = nitCentroMedico;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
}

