package stripesbook.ext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.controller.DefaultActionBeanContextFactory;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.integration.spring.SpringHelper;

public class MyActionBeanContextFactory
    extends DefaultActionBeanContextFactory
{
    @Override
    public ActionBeanContext getContextInstance(
        HttpServletRequest req, HttpServletResponse resp)
        throws ServletException        
    {
        ActionBeanContext actionBeanContext
            = super.getContextInstance(req, resp);

        ServletContext servletContext =
            StripesFilter.getConfiguration().getServletContext();

        SpringHelper.injectBeans(actionBeanContext, servletContext);

        return actionBeanContext;
    }
}

