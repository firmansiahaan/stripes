package stripesbook.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import stripesbook.model.Cars;

public class PartialFormActionBean extends BaseActionBean {

	private static final String VIEW = "/WEB-INF/jsp/cars.jsp" ;
	private static final String RESULT = "/WEB-INF/jsp/partial_form.jsp" ;
	private Cars cars = new Cars();
	public String make;
	private List<String> models;
	
	@DefaultHandler
	public Resolution view() {
		return new ForwardResolution(VIEW);
	}
	
	public Cars getCars() {
		return cars;
	}
	
	public List<String> getModels() {
		return models;
	}
	
	public Resolution updateModels() {
		models = cars.get(make);
		return new ForwardResolution(RESULT);
	}
	
}
