package com.mycompany.cuentas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.cuentas.dao.CuentaDAO;
import com.mycompany.cuentas.modelo.Cuenta;

// Controller Cuenta
@Controller
public class CuentaController {
	
	private final CuentaDAO dao;

	@Autowired
	public CuentaController(CuentaDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/form")
	public String mainFormulario() {
		return "cuenta/formulario";
	}

	@RequestMapping("/agregarCuenta")
	public String agregarCuenta(@Valid Cuenta cuenta, BindingResult result) {
		if (result.hasErrors()) {
			return "cuenta/formulario";
		}
//		System.out.println("La cuenta agregada es " + cuenta.getDescripcion());
//		if(cuenta.getDescripcion()==null || cuenta.getDescripcion().equals("")){
//			return "cuenta/formulario";
//		}
//		CuentaDAO dao = new CuentaDAO();
		dao.agregar(cuenta);
		return "cuenta/cuenta-agregada";
	}

	// @RequestMapping("/listarCuentas")
	// public ModelAndView listarCuentas(){
	// CuentaDAO dao = new CuentaDAO();
	// List<Cuenta> cuentas = dao.listar();
	//
	// ModelAndView mv = new ModelAndView("cuenta/listar-cuenta");
	// mv.addObject("cuentas", cuentas);
	// return mv;
	// }

	@RequestMapping("/listarCuentas")
	public String listar(Model mv) {
//		CuentaDAO dao = new CuentaDAO();
		List<Cuenta> cuentas = dao.listar();
		mv.addAttribute("cuentas", cuentas);
		return "cuenta/listar-cuenta";
	}

	@RequestMapping("/eliminarCuenta")
	public String remove(Cuenta cuenta) {
//		CuentaDAO dao = new CuentaDAO();
		dao.eliminar(cuenta);
		return "redirect:listarCuentas";
	}

	@RequestMapping("/muestraCuenta")
	public String muestra(Long id, Model model) {
//		CuentaDAO dao = new CuentaDAO();
		model.addAttribute("cuenta", dao.buscarPorId(id));
		return "cuenta/muestra";
	}

	@RequestMapping("/modificarCuenta")
	public String modificar(Cuenta cuenta) {
//		CuentaDAO dao = new CuentaDAO();
		dao.modificar(cuenta);
		return "redirect:listarCuentas";
	}
	
	@RequestMapping("/pagarCuenta")
	public void pagar(Long id, HttpServletResponse response) {
//		CuentaDAO dao = new CuentaDAO();
		dao.pagar(id);
		response.setStatus(200);
	}
}