import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InscripcionTest {
    private Alumno alvaro;
    private Materia algoritmos;
    private Materia paradigmas;
    private Materia disenio;
    private Materia analisisDeSistemas;

    @BeforeEach
    public void init() {
        alvaro = new Alumno();
        alvaro.setNombre("Alvaro");
        alvaro.setApellido("Diaz");

        algoritmos = new Materia("Algoritmos", "A001");
        paradigmas = new Materia("Paradigmas", "A002");
        analisisDeSistemas = new Materia("Análisis de Sistemas", "A003");
        disenio = new Materia("Diseño", "A004");

        analisisDeSistemas.agregarCorrelativa(algoritmos);
        paradigmas.agregarCorrelativa(algoritmos);
        disenio.agregarCorrelativa(paradigmas, analisisDeSistemas);
    }

    @Test
    @DisplayName("La inscripción está aceptada por cumplir con correlativas")
    public void inscripcionEstaAceptadaTest() {
        alvaro.agregarMateriaAprobada(algoritmos);

        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(alvaro);
        unaInscripcion.inscribirseA(analisisDeSistemas, paradigmas);

        Assertions.assertTrue(unaInscripcion.estaAprobada());
    }

    @Test
    @DisplayName("La inscripción no se acepta por no tener todas las correlativas")
    public void laInscripcionNoEstaAprobadaTest() {
        alvaro.agregarMateriaAprobada(paradigmas);

        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(alvaro);
        unaInscripcion.inscribirseA(disenio);

        Assertions.assertFalse(unaInscripcion.estaAprobada());
    }

}
