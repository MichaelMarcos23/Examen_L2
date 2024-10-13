package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.repository.EmpleadoRepository;
import pe.com.cibertec.service.EmpleadoService;
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired EmpleadoRepository empleadoRepository;
	@Override
	public List<EmpleadoEntity> listarEmpleado() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public void crearEmpleado(EmpleadoEntity empleadoEntity) {
		empleadoRepository.save(empleadoEntity);
		
	}

	@Override
	public EmpleadoEntity buscarEmpleadoPorId(Integer id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id).get();
	}

	@Override
	public void actualizarEmpleado(Integer id, EmpleadoEntity empleadoActualizado) {
		// TODO Auto-generated method stub
		EmpleadoEntity empleadoencontrado = buscarEmpleadoPorId(id);
		if(empleadoencontrado == null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		try {
			empleadoencontrado.setDni_empleado(empleadoActualizado.getDni_empleado());
			empleadoencontrado.setNombreEmpleado(empleadoActualizado.getNombreEmpleado());
			empleadoencontrado.setApellidoEmpleado(empleadoActualizado.getApellidoEmpleado());
			empleadoencontrado.setFechaNacimiento(empleadoActualizado.getFechaNacimiento());
			empleadoencontrado.setDireccion(empleadoActualizado.getDireccion());
			empleadoencontrado.setCorreo(empleadoActualizado.getCorreo());
			empleadoencontrado.setAreaEntity(empleadoActualizado.getAreaEntity());
			empleadoRepository.save(empleadoencontrado);
		}catch (Exception e) {
			throw new RuntimeException("Error al actualizar");
		}
	}

	@Override
	public void eliminarEmpleado(Integer id) {
		EmpleadoEntity empleadoEncontrado = buscarEmpleadoPorId(id);
		if(empleadoEncontrado == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		empleadoRepository.delete(empleadoEncontrado);
		
	}

}
