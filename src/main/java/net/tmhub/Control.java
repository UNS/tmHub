package net.tmhub;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.tmhub.obj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author remal
 */
@Controller
public class Control {

	@Autowired
	Repa rep;

	@RequestMapping(value = "/{user}/", method = RequestMethod.POST) 
	@ResponseBody
	public Profile createProfile(@PathVariable("user") String user, @ModelAttribute("Profile") Profile p) {
		p.setName(user);
		rep.saveProfile(p);
		return p;
	}
	
	@RequestMapping(value = "/{user}/", method = RequestMethod.GET)
	@ResponseBody
	public Profile getProfile(@PathVariable("user") String user) {
		return rep.getProfile(user);
	}

	@RequestMapping(value = "/{user}/{tm}/state", method = RequestMethod.GET)
	@ResponseBody
	public Profile handler(@PathVariable("user") String user, @PathVariable("tm") String tm) {
//		return new Ok(user + "|" + tm);
		Profile p = new Profile();
		p.setEmail(user + "@tmHub.net");
		p.setLogin(user);
		return p;
	}

	public class Ok {

		long id = 1;
		String msg = "Ok";

		public Ok(String msg) {
			this.msg = msg;
		}

		@JsonProperty
		public String getMsg() {
			return msg;
		}

		@JsonProperty
		public long getId() {
			return id;
		}
	}
}
