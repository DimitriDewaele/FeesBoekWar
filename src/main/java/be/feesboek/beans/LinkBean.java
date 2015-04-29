package be.feesboek.beans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dimitridw
 */
@Named(value = "linkBean")
@RequestScoped
public class LinkBean {
    
    private String link;
    
    private String parameter;
    
    private String viewParam1;
    private String viewParam2;

    /**
     * Creates a new instance of LinkBean
     */
    public LinkBean() {
    }
    
    @PostConstruct
    public void initialize() {
        link = "links2";
        parameter = "parameter from bean";
    }
    
    // Methods
    public String doThis() {
        return "links2";
    }
    
    public String requestInfo() {
        HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return origRequest.getRequestURI();
    }
    
    // Getters and setters
    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the viewParam1
     */
    public String getViewParam1() {
        return viewParam1;
    }

    /**
     * @param viewParam1 the viewParam1 to set
     */
    public void setViewParam1(String viewParam1) {
        this.viewParam1 = viewParam1;
    }

    /**
     * @return the viewParam2
     */
    public String getViewParam2() {
        return viewParam2;
    }

    /**
     * @param viewParam2 the viewParam2 to set
     */
    public void setViewParam2(String viewParam2) {
        this.viewParam2 = viewParam2;
    }

    /**
     * @return the parameter
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * @param parameter the parameter to set
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    
}
