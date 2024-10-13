package pe.com.cibertec.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_empleado")

@NoArgsConstructor
@AllArgsConstructor

public class EmpleadoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empleado_id", nullable = false)
	private Integer empleadoId;
	
	@Column(name = "dni_empleado", nullable = false, unique = true, length = 8)
	private Integer dni_empleado;
	
	@Column(name = "nombre_empleado", nullable = false, length = 45)
	private String nombreEmpleado;
	
	@Column(name = "apellido_empleado", nullable = false, length = 45)
	private String apellidoEmpleado;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento; //YYYY-mm-dd | LocalDateTime YYYY-mm-dd hh:mm:ss
	
	@Column(name = "direccion", nullable = false, length = 45)
	private String direccion;
	
	@Column(name = "correo", nullable = false, length = 45)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "fk_area", nullable = false)
	private AreaEntity areaEntity;

	

	public Integer getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Integer empleadoId) {
		this.empleadoId = empleadoId;
	}

	public Integer getDni_empleado() {
		return dni_empleado;
	}

	public void setDni_empleado(Integer dni_empleado) {
		this.dni_empleado = dni_empleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public AreaEntity getAreaEntity() {
		return areaEntity;
	}

	public void setAreaEntity(AreaEntity areaEntity) {
		this.areaEntity = areaEntity;
	}
	
	

}
