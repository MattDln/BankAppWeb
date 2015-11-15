package ch.hearc.ig.odi.presentation.bean;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author DeillonM
 */
@Named
@SessionScoped
public class LanBean implements Serializable {

    private boolean french;

    public LanBean() {
        french = FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.FRENCH;
    }

    public boolean isFrench() {
        return french;
    }

    public void setFrench(boolean french) {
        this.french = french;
    }

    public String toFr() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
        setFrench(true);
        return "done";
    }

    public String toEn() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
        setFrench(false);
        return "done";
    }
}
