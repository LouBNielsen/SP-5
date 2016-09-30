/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author LouiseB
 */
@Entity
public class Person implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String fName;
    String lName;
    int phone;

    public Person()
    {
    }

    public Person(String fName, String lName, int phone)
    {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
    }

    public String getFname()
    {
        return fName;
    }

    public void setFname(String fName)
    {
        this.fName = fName;
    }

    public String getLname()
    {
        return lName;
    }

    public void setLname(String lName)
    {
        this.lName = lName;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Person{" + "id=" + id + ", fname=" + fName + ", lname=" + lName + ", phone=" + phone + '}';
    }

}
