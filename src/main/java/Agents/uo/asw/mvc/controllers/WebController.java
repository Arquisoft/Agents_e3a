package Agents.uo.asw.mvc.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Agents.uo.asw.agents.util.Check;
import Agents.uo.asw.mvc.model.Agente;
import Agents.uo.asw.mvc.services.AgentsService;

@Controller
public class WebController {


	@Autowired
	private AgentsService agentsService;
	
	
	
	/**
	 * Devuelve la pagina de incio login
	 * 
	 * @param model
	 * @return pagina log HTML
	 */
	@RequestMapping(value = { "/", "/portal" }, method = RequestMethod.GET)
	public String showView(Model model) {
		// model.addAttribute("nombre","luis");
		return "log";
	}


	/**
	 * Recibe los datos de login del usuario, busca si exite ese usuario y en
	 * caso de exitir pasa a la siguiente página que muestra la informacion en
	 * caso contrario muestra la página de error
	 * 
	 * @param session
	 *            mantiene la sesion
	 * @param user
	 *            nombre del login
	 * @param password
	 *            contresena del usuario
	 * @param model
	 * @return view si exito, error si fracaso
	 * @throws IOException 
	 */
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String showInfo(HttpSession session, @RequestParam String user, 
			@RequestParam String password, @RequestParam String kind, Model model) throws IOException {

		Agente c = null;

		if (user != null && password != null && kind != null) {
			c = agentsService.getAgent(user, password, kind);
			if (c != null) {
				session.setAttribute("loader", c);
				model.addAttribute("resultado", "Bienvenid@ " + c.getNombre());
				return "view";
			}
		}
		return "error";

	}

	/**
	 * Acceso a la página que modifica los datos del usuario
	 * 
	 * @return changeInfo html para modificar datos del usuario
	 */
	@RequestMapping(value = "/changeInfo", method = RequestMethod.GET)
	public String changeInfo() {
		return "changeInfo";
	}

	/**
	 * Cambia la contrasena de un usuario, siempre que e usuario este en sesion,
	 * la contrasena antigua se igual que la contrasena de parametro y la nueva
	 * contrasena no sea vacia
	 * 
	 * @param session
	 *            scope
	 * @param password
	 *            contrasena antigua
	 * @param newPassword
	 *            contrasena nueva
	 * @param model
	 * @return pagina siguiente
	 */
	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changePassword(HttpSession session, @RequestParam String password, @RequestParam String newPassword,
			Model model) {
		Agente c = (Agente) session.getAttribute("loader");
		if (c != null) {
			if (c.getContrasena().equals(password) && !newPassword.isEmpty()) {
				c.setContrasena(newPassword);
				agentsService.addAgente(c);
//				agentsService.setContrasenia(newPassword);
				model.addAttribute("resultado", "Contrasena actualizada correctamente");
				return "view";
			}
			return "errorContrasena";
		}
		return "error";

	}

	
	/**
	 * Modifica el email del usuario en sesión, comprueba que el email es correcto
	 * segun un patron y muestra el resultado sobre el HTML view, o redirige a la 
	 * pagina de error en caso de que no se encuentre el usuario en sesion
	 * @param session objeto session del usuario registrado
	 * @param email nuevo email de usuario
	 * @param model
	 * @return view si el usuario esta registrado, error si el usuario no esta registrado
	 */
	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
	public String changeEmail(HttpSession session, @RequestParam String email, Model model){
		Agente c = (Agente) session.getAttribute("loader");
		if(c != null){
			if(!email.isEmpty() && Check.validateEmail(email)){
				c.setEmail(email);
				agentsService.addAgente(c);
				model.addAttribute("resultado", "Email actualizado correctemente a: " + email);
			}else{
				model.addAttribute("resultado", "El email no es valido, no actualizado a: " + email);
			}
			return "view";	
		}
		return "error";
	}
}