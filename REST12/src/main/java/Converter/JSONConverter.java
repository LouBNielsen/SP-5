/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Entity.Person;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author LouiseB
 */
public class JSONConverter
{

    public static Person getPersonFromJson(String js)
    {
        js = "{\"firstName\":\"Lars\",\"lastName\":\"Mortensen\",\"phoneNumber\":12345678}"; //ID?????
        Person p1 = new Gson().fromJson(js, Person.class);
        return p1;
    }

    public static String getJSONFromPerson(Person p)
    {
        p = new Person("Mads", "Madsen", 87654321);
        String p2 = new Gson().toJson(p);
        return p2;
    }

    public static String getJSONFromPerson(List<Person> persons)
    {
        return null;
    }
}
