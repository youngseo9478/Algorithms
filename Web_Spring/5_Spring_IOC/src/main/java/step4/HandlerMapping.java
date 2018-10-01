package step4;

import java.util.Properties;

//controller 흉내낸 것
public class HandlerMapping {
	Properties mapping; //key,value 모두 string

	public HandlerMapping() {
		super();
	}

	public HandlerMapping(Properties mapping) {
		super();
		this.mapping = mapping;
	}

	public Properties getMapping() {
		return mapping;
	}

	public void setMapping(Properties mapping) {
		this.mapping = mapping;
	}
	
}
