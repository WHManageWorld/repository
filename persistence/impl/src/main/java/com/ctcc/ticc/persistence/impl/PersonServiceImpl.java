/*
 * Copyright © 2017 ctcc cloud sdn team and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package com.ctcc.ticc.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctcc.ticc.persistence.entity.Person;
import com.ctcc.ticc.persistence.service.PersonService;

public class PersonServiceImpl implements PersonService {
    private EntityManagerFactory emf;
    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);
    
    public void setEntityManagerFactory(EntityManagerFactory emf) { 
        this.emf = emf;
        LOG.info("test==emf :{} ", this.emf);
    }
 
    @Override
    public void add(Person person) {
    	LOG.info("add ==== getName :{}, getid:{}", person.getName(), person.getId());
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(person);
    	em.flush();
		em.getTransaction().commit();
		em.close();
    }
    
    public void deleteAll() {
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
        em.createQuery("delete from Person").executeUpdate();
        em.flush();
        em.getTransaction().commit();
		em.close();
    }
    @Override
    public List<Person> getAll() {
    	EntityManager em = emf.createEntityManager();
    	List<Person> pList = em.createQuery("from Person", Person.class).getResultList();
 
		LOG.info("pList{}", pList);
    	for (Person person : pList) {
    		System.out.println(person.getName() + ":"+ person.getId());
    		LOG.info("getAll===getName :{}, getId:{}", person.getName(), person.getId());
		}
    	
        return pList;
    }

}
