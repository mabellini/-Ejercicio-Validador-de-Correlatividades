import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InscripcionTest {
    Alumno juan = new Alumno("1234567", "Juan");




    @Test
    @DisplayName("Se anoto a una Materia que cumple las correlativas")
    public void Aprobada1Correlativa(){
        Materia diseno = mock(Materia.class);
        when(diseno.comprobarCorrelativas(juan.getMateriasAprobadas())).thenReturn(true);

        Inscripcion inscripcion = new Inscripcion(juan, List.of(diseno));

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Se anoto a una Materia que no cumple las correlativas")
    public void RechazadaCorrelativa(){
        Materia diseno = mock(Materia.class);
        when(diseno.comprobarCorrelativas(juan.getMateriasAprobadas())).thenReturn(false);

        Inscripcion inscripcion = new Inscripcion(juan, List.of(diseno));

        Assertions.assertFalse(inscripcion.aprobada());
    }


    @Test
    @DisplayName("Se anoto a varias materias, tiene todas las correlativas")
    public void MuchasAprobadas(){
        Materia diseno = mock(Materia.class);
        when(diseno.comprobarCorrelativas(juan.getMateriasAprobadas())).thenReturn(true);

        Materia algoritmos = mock(Materia.class);
        when(algoritmos.comprobarCorrelativas(juan.getMateriasAprobadas())).thenReturn(true);

        Inscripcion inscripcion = new Inscripcion(juan, List.of(diseno, algoritmos));

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Se anoto a varias materias, una sola no cumple")
    public void RechazaPorUnaSoal(){
        Materia diseno = mock(Materia.class);
        when(diseno.comprobarCorrelativas(juan.getMateriasAprobadas())).thenReturn(true);

        Materia algoritmos = mock(Materia.class);
        when(algoritmos.comprobarCorrelativas(juan.getMateriasAprobadas())).thenReturn(false);

        Inscripcion inscripcion = new Inscripcion(juan, List.of(diseno, algoritmos));

        Assertions.assertFalse(inscripcion.aprobada());
    }


}