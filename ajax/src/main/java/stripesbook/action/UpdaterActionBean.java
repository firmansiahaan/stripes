package stripesbook.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import stripesbook.model.Money;

public class UpdaterActionBean extends BaseActionBean {

	private static final String RESULT = "/WEB-INF/jsp/result.jsp";
	private static final String VIEW = "/WEB-INF/jsp/updater.jsp";
	public int youGiveMe;
	private Money money;
	
	@DefaultHandler
	public Resolution current() {
		return new ForwardResolution(VIEW);
	}
	
	public Money getMoney() {
		return money;
	}
	
	public Resolution doubleMoney() {
		money = new Money(youGiveMe, youGiveMe * 2);
		return new ForwardResolution(RESULT);
	}
}
