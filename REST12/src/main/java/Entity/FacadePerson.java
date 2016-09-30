/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author LouiseB
 */
public class FacadePerson implements IPersonFacade
{

    EntityManagerFactory emf;

    public FacadePerson()
    {
         
    }

    public FacadePerson(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public Person addPerson(Person p)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person deletePerson(int id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person getPerson(int id)
    {
        EntityManager em = emf.createEntityManager();

        Person p = null;

        try
        {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        List<Person> persons = null;

        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person editPerson(Person p)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person person = em.find(Person.class, p.getId());
            if (person != null)
            {
                person = p;
                em.merge(person);
                em.getTransaction().commit();
                return person;
            }
        } finally
        {
            em.close();
        }

        return null;
    }

}
