package net.tmhub;

import java.util.List;
import net.tmhub.obj.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Root API
 *
 * @author remal
 */
@Controller
@RequestMapping(value = "/states")
public class CtrlState {

	final private Logger log = LoggerFactory.getLogger(CtrlState.class);
	@Autowired
	Repa rep;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public State createState(
		@RequestBody State s,
		BindingResult bind) {
		rep.saveState(s);
		return s;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public State readState(
		@PathVariable("id") long id) {
		return rep.getState(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<State> readState() {
		return rep.getState();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public State updateState(
		@RequestBody State s,
		@PathVariable("id") long id) {
		s.setId(id);
		rep.updateState(s);
		return s;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public State deleteState(
		@RequestBody State s,
		@PathVariable("id") long id) {
		s.setId(id);
		rep.deleteState(s);
		return s;
	}
}
