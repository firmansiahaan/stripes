package stripesbook.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Cars extends HashMap<String,List<String>> {

	private static final long serialVersionUID = 1L;

	public Cars() {
		put("Acura" , Arrays.asList("CSX","MDX","TL","TSX" ));
		put("Ford" , Arrays.asList("Escape","Explorer","Focus","Mustang"));
		put("Honda", Arrays.asList("Accord","Civic","CR-V","S2000"));
		put("Porsche", Arrays.asList("911 Carrera","Boxster"));
	}
	
}
