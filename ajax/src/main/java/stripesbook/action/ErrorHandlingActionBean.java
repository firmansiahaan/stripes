package stripesbook.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

public class ErrorHandlingActionBean extends BaseActionBean implements ValidationErrorHandler {
	private static final String ERRORS ="/WEB-INF/jsp/errors.jsp" ;

	@Override
	public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
		return new ForwardResolution(ERRORS);
	}
	
}