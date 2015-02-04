/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.test.mavenwebapplication.beans;

import java.io.Serializable;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named
@FlowScoped("flowProgrammatic")
public class FlowProgrammaticBean implements Serializable {

    private String value;

    /**
     * Creates a new instance of FlowProgrammaticBean
     */
    public FlowProgrammaticBean() {
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
