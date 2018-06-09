package quanlythuvien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import quanlythuvien.service.Listener;
import quanlythuvien.service.LoginService;

/*
 *@author: nguyenkhue
 *@version 1.0 Nov 19, 2015
 */
@Controller
@SessionAttributes({ "fullName", "countUserOnline" })
@SuppressWarnings("static-access")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	Listener listener;

	//Create session attribute at fist time
	 @ModelAttribute("fullName")
	 public String initAttributeFullName() {
	 return new String();
	 }

	 //Handle request home page (set fullName and countUserOnline)
	@RequestMapping(value = "home", method = RequestMethod.GET)
	ModelAndView accessHome(ModelMap model, Authentication activeUser,
			@ModelAttribute("fullName") String fullName) {
		if (fullName.equals("")) {
			fullName = loginService.getUserFullName(activeUser.getName());
			model.addAttribute("fullName", fullName);
			model.addAttribute("countUserOnline", listener.getCountUserOnline());
		}
		return new ModelAndView("home", model);
	}

	//Handle request login
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	//Handle request login fail
	@RequestMapping(value = "loginFail", method = RequestMethod.GET)
	String loginFail(ModelMap model) {
		model.addAttribute("error", "Username or password is invalid");
		return "login";
	}

	//Handle request 403
	@RequestMapping(value = "forbidden")
	String forbiddenHandle() {
		return "common/forbidden";
	}

	//Handle request 404
	@RequestMapping(value = "opps.html")
	String resourceNotFound() {
		return "common/oops";
	}
	
	//Handle request 405
	@RequestMapping(value = "illegalaccess.html")
	String illegalAccess() {
		return "common/illegalaccess";
	}
}
