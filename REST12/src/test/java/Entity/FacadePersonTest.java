/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LouiseB
 */
public class FacadePersonTest
{

    FacadePerson facadePerson;

    public FacadePersonTest()
    {
        facadePerson = new FacadePerson();
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        HashMap<String, Object> puProperties = new HashMap<>();
        puProperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        puProperties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        Persistence.generateSchema("rest12", puProperties);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rest12");
        facadePerson.addEntityManagerFactory(emf);
        facadePerson.addPerson(new Person("Louise", "Nielsen", 12312315));
        facadePerson.addPerson(new Person("Caroline", "Nielsen", 82534455));

    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetPerson()
    {
        System.out.println("getPerson");
        Person expResult = new Person("Louise", "Nielsen", 12312315);
        Person result = facadePerson.getPerson(1);
        assertEquals(expResult.getFname(), result.getFname());

    }


}
