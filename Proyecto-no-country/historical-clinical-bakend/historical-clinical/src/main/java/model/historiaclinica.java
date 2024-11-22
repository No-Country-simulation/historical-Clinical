package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historiaclinica")
public class historiaclinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoriaClinica;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 255)
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private mascota mascota;

    @ManyToOne
    @JoinColumn(name = "cedula_usuario")
    private usuario usuario;

    @ManyToOne
    @JoinColumn(name = "nit_centroMedico")
    private centroMedico centroMedico;

    // Getters y setters


    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }


    public historiaclinica(){

    }
    public historiaclinica(Integer idHistoriaClinica, LocalDate fecha, String descripcion, String diagnostico) {
        this.idHistoriaClinica = idHistoriaClinica;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;


    }
}
