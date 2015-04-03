package be.feesboek.dynamic.form;

import be.feesboek.beans.ComplexVO;
import be.feesboek.dynamic.FieldType;
import be.feesboek.gridform.Utility;
import java.util.Date;
import javax.el.ValueExpression;
import javax.el.ValueReference;

/**
 *
 * @author dimitridw
 */
public class Field {

    private FieldType type;
    private String name;
    private String model;

    // These methods are necessary for the .xhtml to understand that the value represents a valueExpression.
    // Then the xhtml will evaluate the expression and will link it to the real data.
    public ValueExpression createValueExpression() {
        // The expression looks like: #{dynamicBean.modelVO.user.firstname}
        // modelVO  : represents a kind of data model
        // user     : represents an user object in the model
        // firstname: represents a property of the user
        String expression = "#{dynamicBean.dynamicModelVO." + model + "}";
        // Create a value expression object --> Add the type of the property (this can also be a complex type: ComplexVO)
        ValueExpression valueExpression;
        switch (type) {
            case TEXT:
                valueExpression = Utility.createValueExpression(expression, String.class);
                break;
            case CALENDAR:
                valueExpression = Utility.createValueExpression(expression, Date.class);
                break;
            case RADIO:
                valueExpression = Utility.createValueExpression(expression, String.class);
                break;
            case COMPLEX:
                valueExpression = Utility.createValueExpression(expression, ComplexVO.class);
                break;
            case CUSTOM:
                valueExpression = Utility.createValueExpression(expression, String.class);
                break;
            default:
                valueExpression = Utility.createValueExpression(expression, String.class);
                break;
        }
        return valueExpression;
    }

    // Return the base of the ValueExpression
    public Object getBase() {
        // a reference to the value object
        ValueReference valueReference = createValueExpression().getValueReference(Utility.getELContext());
        return valueReference.getBase();
    }

    // Return the property of the Value Expression
    public Object getProperty() {
        // a reference to the value object
        ValueReference valueReference = createValueExpression().getValueReference(Utility.getELContext());
        return valueReference.getProperty();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public FieldType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(FieldType type) {
        this.type = type;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

}
