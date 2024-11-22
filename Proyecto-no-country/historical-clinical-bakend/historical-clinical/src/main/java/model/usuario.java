package model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "usuario")
public class usuario {
    @Id
    private Integer cedula;

    @Column(nullable = false, length = 255)
    private String contraseña;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private persona persona;

    @ManyToOne
    @JoinColumn(name = "id_tipoUsuario")
    private tipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<historiaclinica> historiasClinicas;

    // Getters y setters

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



    public usuario(){

    }

    public usuario(Integer cedula, String contraseña) {
        this.cedula = cedula;
        this.contraseña = contraseña;
    }
}
