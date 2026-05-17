package stripesbook.ext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.controller.FileUploadLimitExceededException;
import net.sourceforge.stripes.exception.ActionBeanNotFoundException;
import net.sourceforge.stripes.exception.DefaultExceptionHandler;
import net.sourceforge.stripes.util.Log;
import stripesbook.action.MessageComposeActionBean;

public class MyExceptionHandler extends DefaultExceptionHandler {
	private static final String VIEW ="/WEB-INF/jsp/exception.jsp";
	private static final Log log = Log.getInstance(MyExceptionHandler.class);
	
	public Resolution catchAll(Throwable exc, HttpServletRequest req,
		HttpServletResponse resp) {
		log.error(exc);
		return new ForwardResolution(VIEW);
	}
	
	public Resolution catchActionBeanNotFound(ActionBeanNotFoundException exc,
		HttpServletRequest req, HttpServletResponse resp) {
		return new ErrorResolution(HttpServletResponse.SC_NOT_FOUND);
	}
	
	public Resolution catchAttachmentsTooBig(FileUploadLimitExceededException exc,
		HttpServletRequest req, HttpServletResponse resp) {
		return new RedirectResolution(MessageComposeActionBean.class, "recover" )
			.addParameter("maximumSize" , exc.getMaximum())
			.addParameter("postedSize" , exc.getPosted());
	}
	
	public void init(Configuration configuration) { }
}