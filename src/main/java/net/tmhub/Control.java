package net.tmhub;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public Pack Hello() {
		return new Pack();
	}

	public class Pack {
		String foo;

		@JsonProperty
		public String foo() {
			rep.saveMe();
			return rep.helloWorld();
		}
		String bar = null;

		@JsonProperty
		public String bar() {
			return bar;
		}
	}
}
