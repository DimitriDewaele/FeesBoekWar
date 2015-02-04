package be.test.mavenwebapplication.beans;

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

        flowBuilder.inboundParameter("param1FromFlowConfiguration", 
                "#{flowScope.param1Value}");
        flowBuilder.inboundParameter("param2FromFlowConfiguration", 
                "#{flowScope.param2Value}");

        flowBuilder.flowCallNode("calljoin").flowReference("", "flowConfiguration").
                outboundParameter("param1FromFlowProgrammatic", 
                "#{flowProgrammaticBean.name}").
                outboundParameter("param2FromFlowProgrammatic", 
                "#{flowProgrammaticBean.city}");
        return flowBuilder.getFlow();
    }
}
