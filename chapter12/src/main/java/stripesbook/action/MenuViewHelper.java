package stripesbook.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class MenuViewHelper extends BaseActionBean {
    public Section[] getSections() {
        return Section.values();
    }
    private Section currentSection;
    public Section getCurrentSection() {
        return currentSection;
    }
    public void setCurrentSection(Section currentSection) {
        this.currentSection = currentSection;
    }
    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/WEB-INF/jsp/common/menu.jsp");
    }
    public enum Section {
        MessageList(MessageListActionBean.class),
        ContactList(ContactListActionBean.class),
        Compose(MessageComposeActionBean.class);

        private String textKey, beanclass;
        Section(Class<? extends ActionBean> beanclass) {
            this.textKey = "section." + name();
            this.beanclass = beanclass.getName();
        }
        public String getTextKey() { return textKey; }
        public String getBeanclass() { return beanclass; }
    }
}
