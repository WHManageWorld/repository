/*
 * Copyright © 2017 ctcc cloud sdn team and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package com.ctcc.ticc.persistence.service;

import java.util.List;

import com.ctcc.ticc.persistence.entity.Person;

public interface PersonService {

	void add(Person person);

	void deleteAll();

	List<Person> getAll();

}
