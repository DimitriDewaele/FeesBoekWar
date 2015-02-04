/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.test.mavenwebapplication.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.flow.FlowScoped;

/**
 *
 * @author dimitridw
 */
@Named
@FlowScoped("flowConfiguration")
public class FlowConfigurationBean implements Serializable {

    private String value;

    /**
     * Creates a new instance of FlowConfigurationBean
     */
    public FlowConfigurationBean() {
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    public String getReturnValue() {
        return "/index";
    }

}
