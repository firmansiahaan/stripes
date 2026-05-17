package stripesbook.ext;

import net.sourceforge.stripes.controller.NameBasedActionResolver;

public class MyActionResolver extends NameBasedActionResolver {
	
	@Override
	protected String getBindingSuffix() {
		return ".abc" ;
	}
}
