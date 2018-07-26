/*
 * Copyright © 2017 ctcc cloud sdn team and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.ctcc.ticc.persistence.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctcc.ticc.persistence.entity.Person;
import com.ctcc.ticc.persistence.service.PersonService;

public class PersistenceProvider {

    private static final Logger LOG = LoggerFactory.getLogger(PersistenceProvider.class);

    private final DataBroker dataBroker;
    private final PersonService personService;

    public PersistenceProvider(final DataBroker dataBroker,final PersonService personService) {
    	this.personService = personService;
        this.dataBroker = dataBroker;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("PersistenceProvider Session Initiated");
        
        Person person = new Person();
        person.setName("test");
        personService.add(person);
        personService.getAll();
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        LOG.info("PersistenceProvider Closed");
    }
}