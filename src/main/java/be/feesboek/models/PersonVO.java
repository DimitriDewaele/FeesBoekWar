/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.feesboek.models;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dimitridw
 */
public class PersonVO {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PersonVO.class);

    private int id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Date birthDate;
    private int age;
    private List<PersonVO> children;

    public PersonVO() {
    }

    public PersonVO(int id, String firstName, String lastName, String jobTitle, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.birthDate = birthDate;
        this.age = (new Date()).getYear() - birthDate.getYear();
        LOGGER.debug(this.toString());
    }

    // Methods
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(jobTitle)
                .append(" - ")
                .append(firstName).append(" ").append(lastName)
                .append(" (age: ").append(age).append(")");
        return sb.toString();
    }

    // Getters and setters
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the children
     */
    public List<PersonVO> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<PersonVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("PersonVO{");
        sb.append(this.firstName != null ? this.firstName : "");
        sb.append(" ");
        sb.append(this.lastName != null ? this.lastName : "");
        sb.append(" - age: ").append(this.age);
        sb.append("}");
        return sb.toString();
    }

}
