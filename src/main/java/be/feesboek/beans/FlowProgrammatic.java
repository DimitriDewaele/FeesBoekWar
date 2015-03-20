package be.feesboek.beans;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

@Stateless
public class FlowProgrammatic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {

        String flowId = "flowProgrammatic";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, 
                "/" + flowId + "/" + flowId + ".xhtml").
                markAsStartNode();

        flowBuilder.returnNode("returnFromFlowProgrammatic").
                fromOutcome("#{flowProgrammaticBean.returnValue}");

        flowBuilder.inboundParameter("paramFromConfigurationValue1", 
                "#{flowScope.paramFromConfigurationValue1}");
        flowBuilder.inboundParameter("paramFromConfigurationValue2", 
                "#{flowScope.paramFromConfigurationValue2}");

        flowBuilder.flowCallNode("calljoin").flowReference("", "flowConfiguration").
                outboundParameter("paramFromProgrammaticValue1", 
                "#{flowProgrammaticBean.value1}").
                outboundParameter("paramFromProgrammaticValue2", 
                "#{flowProgrammaticBean.value2}");
        return flowBuilder.getFlow();
    }
}
