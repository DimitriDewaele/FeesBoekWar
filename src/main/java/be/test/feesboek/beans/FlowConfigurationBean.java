/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.test.feesboek.beans;

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

    private String value1;
    private String value2;

    /**
     * Creates a new instance of FlowConfigurationBean
     */
    public FlowConfigurationBean() {
    }

    public String getReturnValue() {
        return "/flowConfigurationReturn";
    }

    /**
     * @return the value1
     */
    public String getValue1() {
        return value1;
    }

    /**
     * @param value1 the value1 to set
     */
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    /**
     * @return the value2
     */
    public String getValue2() {
        return value2;
    }

    /**
     * @param value2 the value2 to set
     */
    public void setValue2(String value2) {
        this.value2 = value2;
    }

}
