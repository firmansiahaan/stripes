package stripesbook.action;

import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.ajax.JavaScriptResolution;
import stripesbook.model.Money;

public class JavaScriptResolutionActionBean extends HelloAjaxActionBean {

	public Resolution doubleMoney() {
		Money money = new Money(youGiveMe, youGiveMe * 2);
		return new JavaScriptResolution(money);
	}
	
}
