package com.vinay.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.vinay.dao.PersonDAO;
import com.vinay.entity.Person;

public class PersonDAOImpl extends BasicDAO<Person, ObjectId> implements PersonDAO {

	public PersonDAOImpl(Class<Person> person, Datastore ds) {
		super(person, ds);
	}

}
