package net.tmhub;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 *
 * @author remal
 */
public class JSON extends ObjectMapper {

	JSON() {
		super();
		this.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,
			false);
		this.configure(SerializationFeature.WRAP_ROOT_VALUE,
			false);
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,
			false);
		//this.setSerializationInclusion(Include.NON_NULL);
	}
}
