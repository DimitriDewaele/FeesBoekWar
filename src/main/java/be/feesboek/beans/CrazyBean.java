package be.feesboek.beans;

import be.feesboek.models.ComplexVO;
import be.feesboek.gridform.component.MyGridComplex;
import be.feesboek.gridform.component.MyGridCounter;
import be.feesboek.gridform.component.MyGridDate;
import be.feesboek.gridform.component.MyGridDropdown;
import be.feesboek.gridform.component.MyGridInputSwitch;
import be.feesboek.gridform.component.MyGridInputText;
import be.feesboek.gridform.component.MyGridInputTextArea;
import be.feesboek.gridform.component.MyGridRadio;
import be.feesboek.gridform.component.MyGridSelectBooleanCheckbox;
import be.feesboek.gridform.component.MyGridSpinner;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlPanelGroup;

/**
 *
 * @author dimitridw
 */
@Named(value = "crazyBean")
@SessionScoped
public class CrazyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CrazyBean.class);

    private String text;
    private String textArea;
    private Boolean check;
    private boolean switcher = true;
    private int spinner = 10;
    private int count = 0;
    private String radio = "B";
    private String dropdown = "B";
    private Date date;
    private ComplexVO complexVO;

    private transient HtmlPanelGroup htmlText;
    private transient HtmlPanelGroup htmlTextArea;
    private transient HtmlPanelGroup htmlCheck;
    private transient HtmlPanelGroup htmlSwitch;
    private transient HtmlPanelGroup htmlSpinner;
    private transient HtmlPanelGroup htmlCounter;
    private transient HtmlPanelGroup htmlRadio;
    private transient HtmlPanelGroup htmlDropdown;
    private transient HtmlPanelGroup htmlDate;
    private transient HtmlPanelGroup htmlComplex;

    /**
     * Creates a new instance of CrazyForm
     */
    public CrazyBean() {
        LOGGER.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    @PostConstruct
    public void start() {
        complexVO = new ComplexVO();
        htmlText = MyGridInputText.generate();
        htmlTextArea = MyGridInputTextArea.generate();
        htmlCheck = MyGridSelectBooleanCheckbox.generate();
        htmlSwitch = MyGridInputSwitch.generate();
        htmlSpinner = MyGridSpinner.generate();
        htmlCounter = MyGridCounter.generate();
        htmlRadio = MyGridRadio.generate();
        htmlDropdown = MyGridDropdown.generate();
        htmlDate = MyGridDate.generate();
        htmlComplex = MyGridComplex.generate();
    }

    public void increment() {
        count++;
    }

    public void save() {
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the switcher
     */
    public boolean isSwitcher() {
        return switcher;
    }

    /**
     * @param switcher the switcher to set
     */
    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the textArea
     */
    public String getTextArea() {
        return textArea;
    }

    /**
     * @param textArea the textArea to set
     */
    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    /**
     * @return the check
     */
    public Boolean getCheck() {
        return check;
    }

    /**
     * @param check the check to set
     */
    public void setCheck(Boolean check) {
        this.check = check;
    }

    /**
     * @return the htmlText
     */
    public HtmlPanelGroup getHtmlText() {
        return htmlText;
    }

    /**
     * @param htmlText the htmlText to set
     */
    public void setHtmlText(HtmlPanelGroup htmlText) {
        this.htmlText = htmlText;
    }

    /**
     * @return the htmlTextArea
     */
    public HtmlPanelGroup getHtmlTextArea() {
        return htmlTextArea;
    }

    /**
     * @param htmlTextArea the htmlTextArea to set
     */
    public void setHtmlTextArea(HtmlPanelGroup htmlTextArea) {
        this.htmlTextArea = htmlTextArea;
    }

    /**
     * @return the htmlCheck
     */
    public HtmlPanelGroup getHtmlCheck() {
        return htmlCheck;
    }

    /**
     * @param htmlCheck the htmlCheck to set
     */
    public void setHtmlCheck(HtmlPanelGroup htmlCheck) {
        this.htmlCheck = htmlCheck;
    }

    /**
     * @return the htmlSwitch
     */
    public HtmlPanelGroup getHtmlSwitch() {
        return htmlSwitch;
    }

    /**
     * @param htmlSwitch the htmlSwitch to set
     */
    public void setHtmlSwitch(HtmlPanelGroup htmlSwitch) {
        this.htmlSwitch = htmlSwitch;
    }

    /**
     * @return the htmlSpinner
     */
    public HtmlPanelGroup getHtmlSpinner() {
        return htmlSpinner;
    }

    /**
     * @param htmlSpinner the htmlSpinner to set
     */
    public void setHtmlSpinner(HtmlPanelGroup htmlSpinner) {
        this.htmlSpinner = htmlSpinner;
    }

    /**
     * @return the spinner
     */
    public int getSpinner() {
        return spinner;
    }

    /**
     * @param spinner the spinner to set
     */
    public void setSpinner(int spinner) {
        this.spinner = spinner;
    }

    /**
     * @return the htmlCounter
     */
    public HtmlPanelGroup getHtmlCounter() {
        return htmlCounter;
    }

    /**
     * @param htmlCounter the htmlCounter to set
     */
    public void setHtmlCounter(HtmlPanelGroup htmlCounter) {
        this.htmlCounter = htmlCounter;
    }

    /**
     * @return the htmlRadio
     */
    public HtmlPanelGroup getHtmlRadio() {
        return htmlRadio;
    }

    /**
     * @param htmlRadio the htmlRadio to set
     */
    public void setHtmlRadio(HtmlPanelGroup htmlRadio) {
        this.htmlRadio = htmlRadio;
    }

    /**
     * @return the htmlDropdown
     */
    public HtmlPanelGroup getHtmlDropdown() {
        return htmlDropdown;
    }

    /**
     * @param htmlDropdown the htmlDropdown to set
     */
    public void setHtmlDropdown(HtmlPanelGroup htmlDropdown) {
        this.htmlDropdown = htmlDropdown;
    }

    /**
     * @return the radio
     */
    public String getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(String radio) {
        this.radio = radio;
    }

    /**
     * @return the dropdown
     */
    public String getDropdown() {
        return dropdown;
    }

    /**
     * @param dropdown the dropdown to set
     */
    public void setDropdown(String dropdown) {
        this.dropdown = dropdown;
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
     * @return the htmlDate
     */
    public HtmlPanelGroup getHtmlDate() {
        return htmlDate;
    }

    /**
     * @param htmlDate the htmlDate to set
     */
    public void setHtmlDate(HtmlPanelGroup htmlDate) {
        this.htmlDate = htmlDate;
    }

    /**
     * @return the complexVO
     */
    public ComplexVO getComplexVO() {
        return complexVO;
    }

    /**
     * @param complexVO the complexVO to set
     */
    public void setComplexVO(ComplexVO complexVO) {
        this.complexVO = complexVO;
    }

    /**
     * @return the htmlComplex
     */
    public HtmlPanelGroup getHtmlComplex() {
        return htmlComplex;
    }

    /**
     * @param htmlComplex the htmlComplex to set
     */
    public void setHtmlComplex(HtmlPanelGroup htmlComplex) {
        this.htmlComplex = htmlComplex;
    }

}
