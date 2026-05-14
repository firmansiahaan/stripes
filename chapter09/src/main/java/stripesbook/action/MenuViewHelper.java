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
        MessageList("Messages", MessageListActionBean.class),
        ContactList("Contact List", ContactListActionBean.class),
        Compose("Compose", MessageComposeActionBean.class);

        private String text, beanclass;
        Section(String text, Class<? extends ActionBean> beanclass) {
            this.text = text;
            this.beanclass = beanclass.getName();
        }
        public String getText() { return text; }
        public String getBeanclass() { return beanclass; }
    }
}
