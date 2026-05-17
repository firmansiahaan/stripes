package stripesbook.action;

import javax.annotation.security.PermitAll;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

@PermitAll
public class LogoutActionBean extends BaseActionBean {

	public Resolution logout() {
		getContext().logout();
		return new RedirectResolution(LoginActionBean.class);
	}
}
