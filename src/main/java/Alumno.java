import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Alumno {
    private String nombre;
    private String Legajo;
    private List<Materia> materiaAprobadas;

    public Alumno(String Legajo, String nombre, List<Materia> materiaAprobadas){
        this.nombre = nombre;
        this.Legajo = Legajo;
        this.materiaAprobadas = materiaAprobadas;
    }

    public Alumno(String Legajo, String nombre){
        this.nombre = nombre;
        this.Legajo = Legajo;
        this.materiaAprobadas = new ArrayList<>();
    }

    public void aprobarMateria(Materia materia){
        this.materiaAprobadas.add(materia);
    }

    public List<Materia> getMateriasAprobadas(){
        return this.materiaAprobadas;
    }




}
