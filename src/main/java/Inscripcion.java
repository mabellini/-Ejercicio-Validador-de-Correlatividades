import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias){
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        return materias.stream()
                .allMatch(materia -> materia.comprobarCorrelativas(alumno.getMateriasAprobadas()));
    }
}
