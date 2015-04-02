package be.feesboek.gridform;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

/**
 *
 * @author dimitridw
 */
public class Utility {

    public static ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().getExpressionFactory()
                .createValueExpression(context.getELContext(), valueExpression, valueType);
    }

    public static MethodExpression createMethodExpression(String expression, Class<?> returnType, Class<?>... parameterTypes) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().getExpressionFactory()
                .createMethodExpression(context.getELContext(), expression, returnType, parameterTypes);
    }

}
