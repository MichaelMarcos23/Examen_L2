package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.cibertec.model.AreaEntity;
import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.repository.AreaRepository;
import pe.com.cibertec.repository.EmpleadoRepository;
import pe.com.cibertec.service.AreaService;
import pe.com.cibertec.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired EmpleadoService empleadoService;
	@Autowired AreaService areaService;
	           
	             //LISTAR EMPLEADO///
	
	@GetMapping("/")
	public String listarEmpleado(Model model) {
		List<EmpleadoEntity>listaEmpleado = empleadoService.listarEmpleado();
		model.addAttribute("listaemp", listaEmpleado);
		return "lista_empleado";
	}
	
	             //REGISTRAR EMPLEADO//
	
	@GetMapping("/registrar_empleado")
	public String mostrarRegistrarEmpleado(Model model) {
		List<AreaEntity>listaArea= areaService.listarArea();
		model.addAttribute("areas",listaArea);
		model.addAttribute("empleado", new EmpleadoEntity());
		return "registrar_empleado";
	}
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity emp
			, Model model) {
		
		empleadoService.crearEmpleado(emp);
		return "redirect:/empleado/";
		
	}
	
                    	//DETALLE EMPLEADO///
	@GetMapping("/detalle_empleado/{id}")
	public String verDetalle(Model model, @PathVariable("id") Integer id) {
		EmpleadoEntity empleado = empleadoService.buscarEmpleadoPorId(id);
		model.addAttribute("empleado", empleado);
		return "detalle_empleado";
	}
	
	
	@GetMapping("/editar_empleado/{id}")
	public String mostrarActualizar(@PathVariable("id")Integer id, Model model) {
		EmpleadoEntity empleado = empleadoService.buscarEmpleadoPorId(id);
		List<AreaEntity>listaArea= areaService.listarArea();
		model.addAttribute("areas",listaArea);
		model.addAttribute("empleado", empleado);
		return "editar_empleado";
	}
	
	@PostMapping("/editar_empleado/{id}")
	public String actualizarEmpleado(@PathVariable("id")Integer id, @ModelAttribute("empleado") EmpleadoEntity empleado, Model model) {
		empleadoService.actualizarEmpleado(id, empleado);
		return "redirect:/empleado/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmpleado(Model model, @PathVariable("id") Integer id) {
		empleadoService.eliminarEmpleado(id);
		return "redirect:/empleado/";
	}
	
	
	
	
	
	
	
	
	
	
}
