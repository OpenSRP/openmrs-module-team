/**
 *  @author Shakeeb Raza
 */
package org.openmrs.module.teammodule.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.teammodule.Team;
import org.openmrs.module.webservices.rest.web.v1_0.search.openmrs1_8.LocationSearchHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Muhammad Safwan
 * 
 */
@Controller
@RequestMapping(value = "module/teammodule/team.form")
public class TeamController {
	HttpServletRequest request;
	/** Logger for this class and subclasses */
	protected final Log log = LogFactory.getLog(getClass());

	/** Success form view name */
	private final String SUCCESS_FORM_VIEW = "/module/teammodule/team";

	/**
	 * Initially called after the formBackingObject method to get the landing
	 * form name
	 * 
	 * @return String form view name
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model, HttpServletRequest request) {
		try {
			List<Location> locations = Context.getLocationService().getAllLocations();
			for(Location location:locations) {
				location.setName(location.getName().replace("\"", "'"));
			}
			model.addAttribute("allLocations", locations);
		}
		catch(Exception e) { e.printStackTrace(); throw new RuntimeException(e); }
		
		
		return SUCCESS_FORM_VIEW;
	}

	/**
	 * All the parameters are optional based on the necessity
	 * 
	 * @param httpSession
	 * @param anyRequestObject
	 * @param errors
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Model model, HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject, BindingResult errors, @ModelAttribute("searchTeam") Team searchTeam) {

		if (errors.hasErrors()) {
			// return error view
		}

		return "redirect:/module/teammodule/team.form?searchTeam=" + searchTeam.getTeamName();
	}

}