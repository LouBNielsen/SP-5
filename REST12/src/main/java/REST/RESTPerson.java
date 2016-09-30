/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Entity.FacadePerson;
import Entity.Person;
import com.google.gson.Gson;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author LouiseB
 */
@Path("person")
public class RESTPerson
{

    @Context
    private UriInfo context;

    FacadePerson facadePerson;

    public RESTPerson()
    {
        facadePerson = new FacadePerson(Persistence.createEntityManagerFactory("rest12"));
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons()
    {
        
        System.out.println("getPersons");
        return new Gson().toJson(facadePerson.getPersons());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") int id) //throws PersonNotFoundException
    {
        
        System.out.println("getPerson");
        Person p = facadePerson.getPerson(id);
        if(p == null)
        {
            //throw new PersonNotFoundException("{"code": 404, "message": "No person with provided id found", "stackTrace": "…."}");
        }
        return new Gson().toJson(facadePerson.getPerson(id));
        
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public void postPerson(String content)
    {
        System.out.println("add person metode");
        facadePerson.addPerson(new Gson().fromJson(content, Person.class));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPerson(Person p)
    {
        System.out.println("putPerson");
       // facadePerson.editPerson(p);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteQuote(@PathParam("id") int id)
    {
        System.out.println("deletePerson");
        new Gson().toJson(facadePerson.deletePerson(id));
    }

}
