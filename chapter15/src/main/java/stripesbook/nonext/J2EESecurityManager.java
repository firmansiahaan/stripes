package stripesbook.nonext;

import java.lang.reflect.Method;

import org.stripesstuff.plugin.security.SecurityManager;

import net.sourceforge.stripes.action.ActionBean;

public class J2EESecurityManager implements SecurityManager {

	@Override
	public Boolean getAccessAllowed(ActionBean bean, Method handler) {
		return true; // bean.getContext().getRequest().getUserPrincipal() != null;
	}

	protected Boolean hasRole(ActionBean bean, Method handler, String role) {
		return bean.getContext().getRequest().isUserInRole(role);
	}

	protected Boolean isUserAuthenticated(ActionBean bean, Method handler) {
		// TODO Auto-generated method stub
		return null;
	}
}
