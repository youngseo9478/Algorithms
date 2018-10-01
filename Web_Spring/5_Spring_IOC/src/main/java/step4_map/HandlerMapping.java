package step4_map;

import java.util.Map;

//controller 흉내낸 것
public class HandlerMapping {
	Map<String, String> mapping; //key,value 모두 string

	public HandlerMapping(Map<String, String> mapping) {
		super();
		this.mapping = mapping;
	}

	public HandlerMapping() {
		super();
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}

	
	
}
