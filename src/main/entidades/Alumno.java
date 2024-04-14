package entidades;



import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
public class Alumno {

    // Atributos

    @Setter
    private String nombre;

    @Setter
    private String apellido;

    @Setter
    private String legajo;

    private List<Materia> materiasAprobadas;


    // Constructor

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }


    // Metodo

    public void agregarMateriaAprobada(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }

    public boolean estaAprobada(Materia unaMateria) {
        return this.materiasAprobadas.contains(unaMateria);
    }

    public boolean cumpleCorrelativasParaCursar(Materia unaMateria) {
        return unaMateria.getCorrelativas().stream().allMatch(this::estaAprobada);
    }
}