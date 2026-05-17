package stripesbook.nonext;

import java.lang.reflect.Method;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.stripesstuff.plugin.security.InstanceBasedSecurityManager;
import org.stripesstuff.plugin.security.SecurityHandler;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import stripesbook.action.BaseActionBean;
import stripesbook.action.LoginActionBean;
import stripesbook.model.Role;
import stripesbook.model.User;

public class MySecurityManager extends InstanceBasedSecurityManager implements SecurityHandler {
	@Override
	protected Boolean isUserAuthenticated(ActionBean bean, Method handler) {
		return true; // getUser(bean) != null;
	}

	@Override
	protected Boolean hasRoleName(ActionBean bean, Method handler, String role) {
		User user = getUser(bean);
		if (user != null) {
			Collection<Role> roles = user.getRoles();
			return roles != null && roles.contains(new Role(role));
		} 
		return false;
	}
	
	private User getUser(ActionBean bean) {
		return ((BaseActionBean) bean).getContext().getUser();
	}

	@Override
	public Resolution handleAccessDenied(ActionBean bean, Method handler) {
		if (!isUserAuthenticated(bean, handler)) {
			RedirectResolution resolution = new RedirectResolution(LoginActionBean.class);
			if (bean.getContext().getRequest().getMethod().equalsIgnoreCase("GET" )) {
				String loginUrl = ((BaseActionBean) bean).getLastUrl();
				resolution.addParameter("loginUrl" , loginUrl);
			}
			return resolution;
		}
		return new ErrorResolution(HttpServletResponse.SC_UNAUTHORIZED);
	}
	
}
