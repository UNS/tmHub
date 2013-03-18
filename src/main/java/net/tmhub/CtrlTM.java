package net.tmhub;

import java.util.List;
import net.tmhub.obj.TM;
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
@RequestMapping(value = "/tms")
public class CtrlTM {
	final private Logger log = LoggerFactory.getLogger(CtrlTM.class);

	@Autowired
	Repa rep;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public TM createTM(
		@RequestBody TM tm,
		BindingResult bind) {
		rep.saveTM(tm);
		return tm;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public TM readTM(
		@PathVariable("id") long id) {
		return rep.getTM(id);

	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TM> readTM() {
		return rep.getTM();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public TM updateTM(
		@RequestBody TM tm,
		@PathVariable("id") long id) {
		tm.setId(id);
		rep.updateTM(tm);
		return tm;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public TM deleteTM(
		@RequestBody TM tm,
		@PathVariable("id") long id) {
		tm.setId(id);
		rep.deleteTM(tm);
		return tm;
	}
}
