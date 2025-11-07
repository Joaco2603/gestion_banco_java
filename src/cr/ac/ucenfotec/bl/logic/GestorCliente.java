package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.dl.DataCliente;
import java.util.List;

public class GestorCliente {
    private DataCliente dataCliente;

    public GestorCliente() {
        this.dataCliente = new DataCliente();
    }

    public String registrarCliente(String cedula, String nombre, String apellido) {
        // Validaciones
        if (cedula == null || cedula.trim().isEmpty()) {
            return "La cédula no puede estar vacía";
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre no puede estar vacío";
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            return "El apellido no puede estar vacío";
        }

        // Verificar si el cliente ya existe
        if (dataCliente.buscar(cedula) != null) {
            return "Ya existe un cliente con esa cédula";
        }

        Cliente cliente = new Cliente(cedula, nombre, apellido);
        if (dataCliente.agregar(cliente)) {
            return "Cliente registrado exitosamente";
        }
        return "Error al registrar el cliente";
    }

    public Cliente buscarCliente(String cedula) {
        return dataCliente.buscar(cedula);
    }

    public List<Cliente> listarClientes() {
        return dataCliente.listarTodos();
    }

    public String actualizarCliente(String cedula, String nombre, String apellido) {
        Cliente cliente = dataCliente.buscar(cedula);
        if (cliente == null) {
            return "Cliente no encontrado";
        }

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);

        if (dataCliente.actualizar(cliente)) {
            return "Cliente actualizado exitosamente";
        }
        return "Error al actualizar el cliente";
    }
}
