package net.tmhub;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

/**
 *
 * @author remal
 */
public class JSON extends ObjectMapper {

	JSON() {
		super();
		this.registerModule(new Hibernate4Module());
		Hibernate4Module hm = new Hibernate4Module();
		hm.configure(Feature.FORCE_LAZY_LOADING, true);
		hm.configure(Feature.USE_TRANSIENT_ANNOTATION, true);
		this.registerModule(hm);
		hm.configure(Feature.FORCE_LAZY_LOADING, true);
		hm.configure(Feature.USE_TRANSIENT_ANNOTATION, true);
		this.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,
			false);
		this.configure(SerializationFeature.WRAP_ROOT_VALUE,
			false);
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,
			false);
		//this.setSerializationInclusion(Include.NON_NULL);
	}

	//public void setPrettyPrint(boolean prettyPrint) {
	//}
	
}
