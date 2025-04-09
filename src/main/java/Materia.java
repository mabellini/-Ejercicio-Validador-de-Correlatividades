import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
 public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(List<Materia> correlativas, String nombre){
        this.correlativas = correlativas;
        this.nombre = nombre;
    }

    public Materia( String nombre){
        this.correlativas = new ArrayList<>();
        this.nombre = nombre;
    }

    public Boolean comprobarCorrelativas(List<Materia> materias){

        return materias.containsAll(this.correlativas);
    }
}
