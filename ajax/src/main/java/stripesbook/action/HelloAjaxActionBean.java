package stripesbook.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.ajax.JavaScriptResolution;

public class HelloAjaxActionBean extends BaseActionBean {

	public int youGiveMe;
	
	public Resolution doubleMoney() {
		return new JavaScriptResolution(youGiveMe * 2);
	}
	
	@DefaultHandler
	public Resolution current() {
		return new ForwardResolution(VIEW);
	}
	
	private static final String VIEW = "/WEB-INF/jsp/javascript_resolution.jsp";
}
