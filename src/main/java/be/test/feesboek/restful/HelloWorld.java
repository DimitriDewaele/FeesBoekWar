package be.test.feesboek.restful;

import be.test.feesboek.business.user.boundary.UserBoundary;
import be.test.feesboek.entity.UserEntity;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Root resource (exposed at "helloworld" path)
 */
@Path("helloworld/{extra}")
public class HelloWorld {

    @Context
    private UriInfo context;

    @Inject
    UserBoundary userBoundary;

    //param: Inject as class field with default value
    //userName: Injected as method parameter and with validation
    @QueryParam("message")
    @DefaultValue("No message")
    private String param;

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }

    /**
     * GET method for URI /helloworld/{extra} Add extra queryParameter: param
     *
     * param: Inject as class field userName: Injected as method parameter and
     * with validation
     */
    @GET
    @Produces("text/html")
    public String getHtml(@NotNull @PathParam("extra") String userName) {

        String firstname = "Empty";
        String lastname = "Empty";

        if (userName != null) {
            UserEntity user = userBoundary.findByUserName(userName);
            firstname = user.getFirstname();
            lastname = user.getLastname();
        }

        StringBuilder build = new StringBuilder();
        build.append("<html lang=\"en\">");
        build.append("<body>");
        build.append("<h1>Hello, REST user!!</h1>");
        build.append("<p>User: " + firstname + " " + lastname + "</p>");
        build.append("<p>Message: " + param + "</p>");
        build.append("<p><a href=\"http://localhost:8080/MavenWebApplication-1.0-SNAPSHOT/index.xhtml\">Back to index</a></p>");
        build.append("<p><b>Use Chrome App: REST Console or Postman to request application/json and appliction/xml and text/xml</b></p>");
        build.append("</body>");
        build.append("</html>");
        return build.toString();
    }

    /**
     * Test with Chrome apps: REST console
     *
     * param: Inject as class field and with validation. userName: Injected as
     * method parameter and with validation
     */
    @GET
    @Produces("text/xml")
    public String getXml(@NotNull @PathParam("extra") String userName) {
        String firstname = "Empty";
        String lastname = "Empty";

        if (userName != null) {
            UserEntity user = userBoundary.findByUserName(userName);
            firstname = user.getFirstname();
            lastname = user.getLastname();
        }

        StringBuilder build = new StringBuilder();
        build.append("<xml>");
        build.append("<user firstname=\"" + firstname + "\" lastname=\"" + lastname + "\"/>");
        build.append("<param>" + param + "</param>");
        build.append("</xml>");
        return build.toString();
    }

    //Test in Chrome with App Rest console and type: application/json
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UserEntity getUser(@NotNull @PathParam("extra") String userName) {
        UserEntity user = null;

        if (userName != null) {
            user = userBoundary.findByUserName(userName);
        }
        return user;
    }

    /**
     * PUT method for updating or creating an instance of HelloWorld
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }

    /**
     * @return the param
     */
    public String getParam() {
        return param;
    }

    /**
     * @param param the param to set
     */
    public void setParam(String param) {
        this.param = param;
    }
}
