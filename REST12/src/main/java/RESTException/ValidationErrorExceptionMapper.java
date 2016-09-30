/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author LouiseB
 */
@Provider
public class ValidationErrorExceptionMapper implements ExceptionMapper<ValidationErrorException>
{

    @Context
    ServletContext context;

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(ValidationErrorException e)
    {
        boolean isDebug = context.getInitParameter("debug").equals("true");

        ErrorMessage err = new ErrorMessage(e, 400, isDebug);
        err.setDescription("{\"code\": 400, \"message\": \"First Name or Last Name is missing\", \"stackTrace\": \"….\"}");
        err.setMessage("{\"code\": 400, \"message\": \"First Name or Last Name is missing\", \"stackTrace\": \"….\"}");

        return Response.status(404).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }

}
