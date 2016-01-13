package be.feesboek.managedbeans;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "componentBean")
@RequestScoped
public class ComponentBean {
    
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    private String text6;
    private String text7;
    private String text8;
    private String text9;
    
    private Boolean select1;
    private String select2;
    private String select3;
    private String select4;
    
    private String[] many1;
    private String[] many2;
    private String[] many3;
    
     private Map<String, String> availableItems;

    /**
     * Creates a new instance of ComponentBean
     */
    public ComponentBean() {
    }
    
    @PostConstruct
    public void initialize() {
        text1 = "text1";
        text2 = "text2";
        text3 = "text3";
        text4 = "text4";
        text5 = "text5";
        text6 = "text6";
        text7 = "text7";
        text8 = "text8";
        text9 = "text9";
        
        select1 = Boolean.FALSE;
        select2 = "A";
        select3 = "B";
        select4 = "C";
        
        availableItems = new LinkedHashMap<String, String>();
        availableItems.put("A", "Item A");
        availableItems.put("B", "Item B");
        availableItems.put("C", "Item C");
        availableItems.put("D", "Item D");
    }

    /**
     * @return the text1
     */
    public String getText1() {
        return text1;
    }

    /**
     * @param text1 the text1 to set
     */
    public void setText1(String text1) {
        this.text1 = text1;
    }

    /**
     * @return the text2
     */
    public String getText2() {
        return text2;
    }

    /**
     * @param text2 the text2 to set
     */
    public void setText2(String text2) {
        this.text2 = text2;
    }

    /**
     * @return the text3
     */
    public String getText3() {
        return text3;
    }

    /**
     * @param text3 the text3 to set
     */
    public void setText3(String text3) {
        this.text3 = text3;
    }

    /**
     * @return the text4
     */
    public String getText4() {
        return text4;
    }

    /**
     * @param text4 the text4 to set
     */
    public void setText4(String text4) {
        this.text4 = text4;
    }

    /**
     * @return the text5
     */
    public String getText5() {
        return text5;
    }

    /**
     * @param text5 the text5 to set
     */
    public void setText5(String text5) {
        this.text5 = text5;
    }

    /**
     * @return the text6
     */
    public String getText6() {
        return text6;
    }

    /**
     * @param text6 the text6 to set
     */
    public void setText6(String text6) {
        this.text6 = text6;
    }

    /**
     * @return the text7
     */
    public String getText7() {
        return text7;
    }

    /**
     * @param text7 the text7 to set
     */
    public void setText7(String text7) {
        this.text7 = text7;
    }

    /**
     * @return the text8
     */
    public String getText8() {
        return text8;
    }

    /**
     * @param text8 the text8 to set
     */
    public void setText8(String text8) {
        this.text8 = text8;
    }

    /**
     * @return the text9
     */
    public String getText9() {
        return text9;
    }

    /**
     * @param text9 the text9 to set
     */
    public void setText9(String text9) {
        this.text9 = text9;
    }

    /**
     * @return the select1
     */
    public Boolean getSelect1() {
        return select1;
    }

    /**
     * @param select1 the select1 to set
     */
    public void setSelect1(Boolean select1) {
        this.select1 = select1;
    }

    /**
     * @return the select2
     */
    public String getSelect2() {
        return select2;
    }

    /**
     * @param select2 the select2 to set
     */
    public void setSelect2(String select2) {
        this.select2 = select2;
    }

    /**
     * @return the select3
     */
    public String getSelect3() {
        return select3;
    }

    /**
     * @param select3 the select3 to set
     */
    public void setSelect3(String select3) {
        this.select3 = select3;
    }

    /**
     * @return the select4
     */
    public String getSelect4() {
        return select4;
    }

    /**
     * @param select4 the select4 to set
     */
    public void setSelect4(String select4) {
        this.select4 = select4;
    }

    /**
     * @return the availableItems
     */
    public Map<String, String> getAvailableItems() {
        return availableItems;
    }

    /**
     * @param availableItems the availableItems to set
     */
    public void setAvailableItems(Map<String, String> availableItems) {
        this.availableItems = availableItems;
    }

    /**
     * @return the many1
     */
    public String[] getMany1() {
        return many1;
    }

    /**
     * @param many1 the many1 to set
     */
    public void setMany1(String[] many1) {
        this.many1 = many1;
    }

    /**
     * @return the many2
     */
    public String[] getMany2() {
        return many2;
    }

    /**
     * @param many2 the many2 to set
     */
    public void setMany2(String[] many2) {
        this.many2 = many2;
    }

    /**
     * @return the many3
     */
    public String[] getMany3() {
        return many3;
    }

    /**
     * @param many3 the many3 to set
     */
    public void setMany3(String[] many3) {
        this.many3 = many3;
    }
    
}
