package entidades;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Materia{

    // Atributos
    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    private String idMateria;

    @Getter
    private List<Materia> correlativas;

    // Constructor

    public Materia(String nombre, String idMateria) {
        this.nombre = nombre;
        this.idMateria = idMateria;
        this.correlativas = new ArrayList<>();
    }


    // Metodo

    public void agregarCorrelativa(Materia ... correlativas){
        Collections.addAll(this.correlativas, correlativas);

    }

}