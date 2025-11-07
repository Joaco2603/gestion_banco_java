package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Operacion;
import java.util.ArrayList;
import java.util.List;

public class DataOperacion {
    private List<Operacion> operaciones;

    public DataOperacion() {
        this.operaciones = new ArrayList<>();
    }

    public boolean agregar(Operacion operacion) {
        return operaciones.add(operacion);
    }

    public List<Operacion> listarTodos() {
        return new ArrayList<>(operaciones);
    }

    public Operacion buscar(int numero) {
        for (Operacion operacion : operaciones) {
            if (operacion.getNumero() == numero) {
                return operacion;
            }
        }
        return null;
    }
}
