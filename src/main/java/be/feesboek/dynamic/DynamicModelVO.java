package be.feesboek.dynamic;

import be.feesboek.beans.ComplexVO;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;

public class DynamicModelVO {

    //TODO: sterke vragen tussen link van model en form
    // is 1 op 1 link.
    
    private String firstname;
    private String middlename;
    private String lastname;

    private String country;
    private String city;

    private String street;
    private String number;
    private String appendix;

    private String ordername;
    private Date date;
    private String selectorder;
    private ComplexVO amount;

    private String deliverycountry;
    private String deliverycity;
    private String deliverystreet;
    private String deliverynumber;
    private String deliveryappendix;
    
    private List<String> customFields;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the middlename
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * @param middlename the middlename to set
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the appendix
     */
    public String getAppendix() {
        return appendix;
    }

    /**
     * @param appendix the appendix to set
     */
    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    /**
     * @return the ordername
     */
    public String getOrdername() {
        return ordername;
    }

    /**
     * @param ordername the ordername to set
     */
    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    /**
     * @return the selectorder
     */
    public String getSelectorder() {
        return selectorder;
    }

    /**
     * @param selectorder the selectorder to set
     */
    public void setSelectorder(String selectorder) {
        this.selectorder = selectorder;
    }

    /**
     * @return the deliverycountry
     */
    public String getDeliverycountry() {
        return deliverycountry;
    }

    /**
     * @param deliverycountry the deliverycountry to set
     */
    public void setDeliverycountry(String deliverycountry) {
        this.deliverycountry = deliverycountry;
    }

    /**
     * @return the deliverycity
     */
    public String getDeliverycity() {
        return deliverycity;
    }

    /**
     * @param deliverycity the deliverycity to set
     */
    public void setDeliverycity(String deliverycity) {
        this.deliverycity = deliverycity;
    }

    /**
     * @return the deliverystreet
     */
    public String getDeliverystreet() {
        return deliverystreet;
    }

    /**
     * @param deliverystreet the deliverystreet to set
     */
    public void setDeliverystreet(String deliverystreet) {
        this.deliverystreet = deliverystreet;
    }

    /**
     * @return the deliverynumber
     */
    public String getDeliverynumber() {
        return deliverynumber;
    }

    /**
     * @param deliverynumber the deliverynumber to set
     */
    public void setDeliverynumber(String deliverynumber) {
        this.deliverynumber = deliverynumber;
    }

    /**
     * @return the deliveryappendix
     */
    public String getDeliveryappendix() {
        return deliveryappendix;
    }

    /**
     * @param deliveryappendix the deliveryappendix to set
     */
    public void setDeliveryappendix(String deliveryappendix) {
        this.deliveryappendix = deliveryappendix;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public ComplexVO getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(ComplexVO amount) {
        this.amount = amount;
    }

    /**
     * @return the customFields
     */
    public List<String> getCustomFields() {
        return customFields;
    }

    /**
     * @param customFields the customFields to set
     */
    public void setCustomFields(List<String> customFields) {
        this.customFields = customFields;
    }

}
