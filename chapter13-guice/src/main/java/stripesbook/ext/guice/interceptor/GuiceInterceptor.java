package stripesbook.ext.guice.interceptor;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.*;
import com.google.inject.Module;

import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.config.ConfigurableComponent;
import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.controller.ExecutionContext;
import net.sourceforge.stripes.controller.Interceptor;
import net.sourceforge.stripes.controller.Intercepts;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.util.Log;

@Intercepts(LifecycleStage.ActionBeanResolution)
public class GuiceInterceptor implements Interceptor, ConfigurableComponent {

	public static final String MODULES = "Guice.Modules" ;
	private static Injector injector;
	private static final Log log = Log.getInstance(GuiceInterceptor.class);
	
	@Override
	public void init(Configuration configuration) throws Exception {
		List<Class<? extends Module>> moduleClasses = 
			configuration.getBootstrapPropertyResolver().getClassPropertyList(MODULES, Module.class);
		
		int size = moduleClasses.size();
		if (size > 0) {
			List<Module> modules = new ArrayList<Module>(size);
			for (Class<? extends Module> cls : moduleClasses) {
				modules.add(cls.newInstance());
			}
			injector = Guice.createInjector(modules);
			log.info("Created Guice injector with modules: ", moduleClasses);
		}
		else {
			injector = Guice.createInjector();
		}
	}
	
	public static Injector getInjector() {
		return injector;
	}

	@Override
	public Resolution intercept(ExecutionContext context) throws Exception {
		injector.injectMembers(context.getActionBeanContext());
		Resolution resolution = context.proceed();
		injector.injectMembers(context.getActionBean());
		return resolution;
	}

}
