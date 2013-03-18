package net.tmhub;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tmhub.obj.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.Param;

/**
 * Admin API
 * @author remal
 */
@Controller
@RequestMapping(value = "/profiles")
public class CtrlProfile {

	final private Logger log = LoggerFactory.getLogger(CtrlProfile.class);

	@Autowired
	Repa rep;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Profile createProfile(
		HttpServletRequest req,
		@RequestBody Profile p,
		BindingResult bind	
		) {
		rep.saveProfile(p);
		return p;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Profile readProfile(
		@PathVariable("id") long id
		) {
		return rep.getProfile(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Profile> readProfile(
		) {
		return rep.getProfiles();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Profile updateProfile(
		@RequestBody Profile p,
		@PathVariable("id") long id
		) {
		p.setId(id);
		rep.updateProfile(p);
		return p;	
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Profile deleteProfile(
		@RequestBody Profile p,	
		@PathVariable("id") long id
		) {
		p.setId(id);
		rep.deleteProfile(p);
		return p;	
	}
}
