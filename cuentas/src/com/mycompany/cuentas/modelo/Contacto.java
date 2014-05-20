package com.mycompany.cuentas.modelo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Contacto {
	
	@NotEmpty
	private String nombre;

	@NotEmpty
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void enviarEmail() {
		// codigo para envío de email
	}
}