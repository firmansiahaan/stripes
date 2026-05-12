package stripesbook.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import stripesbook.ext.MyActionBeanContext;
import stripesbook.model.Folder;

public abstract class BaseActionBean implements ActionBean {
    private MyActionBeanContext context;

    public MyActionBeanContext getContext() {
        return context;
    }
    public void setContext(ActionBeanContext context) {
        this.context = (MyActionBeanContext) context;
    }

    public void setFolder(Folder folder) {
        getContext().setCurrentFolder(folder);
    }
}