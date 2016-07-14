package com.vinay.test;

import java.util.List;

import com.vinay.config.MongoConfig;
import com.vinay.dao.PersonDAO;
import com.vinay.dao.impl.PersonDAOImpl;
import com.vinay.entity.Person;

public class MongoTest {

	public static void main(String[] args) {

		PersonDAO personDAO = new PersonDAOImpl(Person.class, MongoConfig.getDatastore());
		// personDAO.save(new Person("Vinay Kumar", "Jharkhand"));

		List<Person> persons = personDAO.find().asList();
		System.out.println(persons);

	}
}
