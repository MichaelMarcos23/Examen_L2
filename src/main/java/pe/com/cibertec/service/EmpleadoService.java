package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.EmpleadoEntity;


public interface EmpleadoService {
	
	List<EmpleadoEntity>listarEmpleado();
	void crearEmpleado(EmpleadoEntity empleadoEntity);
	EmpleadoEntity buscarEmpleadoPorId(Integer id);
	void actualizarEmpleado(Integer id, EmpleadoEntity empleadoEntity);
	void eliminarEmpleado(Integer id);

}
