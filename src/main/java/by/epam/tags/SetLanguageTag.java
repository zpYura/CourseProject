package by.epam.tags;

import by.epam.managers.LanguageManager;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Locale;

/**
 * Created by zpYura on 16.12.2015.
 */
@SuppressWarnings("serial")
public class SetLanguageTag extends TagSupport {
    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public int doStartTag() throws JspException {

        Locale current = Locale.getDefault();
        LanguageManager.setLanguage(current, session);
        // save current locale
        session.setAttribute("current_locale", current);
        //pageContext.getOut().write("<hr/>" + to + "<hr/>");

        return SKIP_BODY;
    }
}
