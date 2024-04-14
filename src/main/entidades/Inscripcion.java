package entidades;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Data
public class Inscripcion {

    // Atributos
    private Alumno alumno;
    private List<Materia> materias;

    // Constructor
    public Inscripcion() {
        this.materias = new ArrayList<>();
    }

    // Metodos
    public void inscribirseA(Materia ... materias) {
        Collections.addAll(this.materias, materias);
    }

    public boolean estaAprobada() {
        return this.materias.stream().allMatch(m -> this.alumno.cumpleCorrelativasParaCursar(m));
    }
}