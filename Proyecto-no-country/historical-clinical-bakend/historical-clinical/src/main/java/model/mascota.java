package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mascota")
public class mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false, length = 10)
    private String edad;

    @Column(nullable = false, length = 10)
    private String genero;

    @Column(nullable = false, length = 150)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_tipoMascota")
    private tipoMascota tipoMascota;

    @OneToMany(mappedBy = "mascota")
    private List<historiaclinica> historiasClinicas;

    // Getters y setters

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public model.tipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(model.tipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public List<historiaclinica> getHistoriasClinicas() {
        return historiasClinicas;
    }

    public void setHistoriasClinicas(List<historiaclinica> historiasClinicas) {
        this.historiasClinicas = historiasClinicas;
    }

    public mascota() {

    }

    public mascota(Integer idMascota, String nombre, String apellidos, String edad, String genero, String descripcion) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.descripcion = descripcion;
    }

}
