/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Entity.FacadePerson;
import Entity.Person;
import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author LouiseB
 */
public class Schema
{

    FacadePerson facadePerson = new FacadePerson();

    public static void main(String[] args)
    {
        Schema schema = new Schema();
    }

    public Schema()
    {

        HashMap<String, Object> puProperties = new HashMap<>();
        //puProperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        //puProperties.put("javax.persistence.schema-generation.database.action", "drop-and-create");

        Persistence.generateSchema("rest12", puProperties);
        //Persistence.generateSchema("rest12", null);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rest12");
        facadePerson.addEntityManagerFactory(emf);
        facadePerson.addPerson(new Person("Louise", "Nielsen", 12312315));
    }

}
