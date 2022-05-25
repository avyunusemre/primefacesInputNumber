package org.primefaces.test;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

@Data
@Named
@SessionScoped
public class LanguageBean {
    private Locale locale;

    /**
     * init.
     */
    @PostConstruct
    public void init() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        locale = facesContext.getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    /**
     * This method sets language of current faces-context.
     *
     * @param language .
     */
    public void setLanguage(String language) throws IOException {
        System.out.println("worked");
        FacesContext fc = FacesContext.getCurrentInstance();
        locale = new Locale(language.toLowerCase());
        System.out.println(locale.getLanguage());
        fc.getViewRoot().setLocale(locale);
    }
}
