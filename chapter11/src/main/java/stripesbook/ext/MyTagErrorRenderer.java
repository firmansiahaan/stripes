package stripesbook.ext;

import java.io.IOException;

import net.sourceforge.stripes.exception.StripesRuntimeException;
import net.sourceforge.stripes.tag.InputTagSupport;
import net.sourceforge.stripes.tag.TagErrorRenderer;

public class MyTagErrorRenderer implements TagErrorRenderer {
	private InputTagSupport tag;
	public void init(InputTagSupport atag) { tag = atag; }
	public void doBeforeStartTag() { }
	public void doAfterEndTag() {
	try { tag.getPageContext().getOut().write(" &#x2A2F"); }
	catch (IOException exc)
		{ throw new StripesRuntimeException(exc); }
	}

}
