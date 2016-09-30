///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Converter;
//
//import Entity.Person;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author LouiseB
// */
//public class JSONConverterTest
//{
//    
//    public JSONConverterTest()
//    {
//    }
//    
//    @BeforeClass
//    public static void setUpClass()
//    {
//    }
//    
//    @AfterClass
//    public static void tearDownClass()
//    {
//    }
//    
//    @Before
//    public void setUp()
//    {
//    }
//    
//    @After
//    public void tearDown()
//    {
//    }
//
//    /**
//     * Test of getPersonFromJson method, of class JSONConverter.
//     */
//    @Test
//    public void testGetPersonFromJson()
//    {
//        System.out.println("getPersonFromJson");
//        String js = "";
//        Person expResult = null;
//        Person result = JSONConverter.getPersonFromJson(js);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getJSONFromPerson method, of class JSONConverter.
//     */
//    @Test
//    public void testGetJSONFromPerson_Person()
//    {
//        System.out.println("getJSONFromPerson");
//        Person p = null;
//        String expResult = "";
//        String result = JSONConverter.getJSONFromPerson(p);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getJSONFromPerson method, of class JSONConverter.
//     */
//    @Test
//    public void testGetJSONFromPerson_List()
//    {
//        System.out.println("getJSONFromPerson");
//        List<Person> persons = null;
//        String expResult = "";
//        String result = JSONConverter.getJSONFromPerson(persons);
//        assertEquals(expResult, result);
//    
//    }
//    
//}
