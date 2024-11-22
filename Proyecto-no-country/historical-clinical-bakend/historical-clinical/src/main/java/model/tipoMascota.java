package model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tipoMascota")
public class tipoMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPersona;

    @Column(nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "tipoPersona")
    private List<persona> personas;

    // Getters y setters

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public tipoMascota(){

    }

    public tipoMascota(Integer idTipoPersona, String nombre) {
        this.idTipoPersona = idTipoPersona;
        this.nombre = nombre;
    }
}
