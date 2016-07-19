package com.vinay;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mongodb.morphia.query.Query;

import com.vinay.config.MongoConfig;
import com.vinay.dao.PersonDAO;
import com.vinay.dao.impl.PersonDAOImpl;
import com.vinay.entity.Address;
import com.vinay.entity.Person;
import com.vinay.util.Utils;

public class Application {

	public static void main(String[] args) {

		/**
		 * This will disable mongoDB logging on the console.
		 * */
		Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);

		System.out.println("MongoDB started?(YES/NO):");
		String choice = Utils.readString();

		if (choice.equalsIgnoreCase("YES")) {
			PersonDAO personDAO = new PersonDAOImpl(Person.class, MongoConfig.getDatastore());
			mainMenu(personDAO);
		}

	}
	
	/**
	 * Test push
	 * */

	private static void displayAll(PersonDAO personDAO) {
		printLine();

		List<Person> persons = personDAO.find().asList();
		System.out.println(persons);
	}

	private static void savePerson(PersonDAO personDAO) {
		printLine();
		Utils.readString();

		System.out.print("Enter name: ");
		String name = Utils.readString();

		System.out.print("Enter city: ");
		String city = Utils.readString();

		System.out.print("Enter state: ");
		String state = Utils.readString();

		System.out.print("Enter pincode: ");
		String pincode = Utils.readString();

		Person person = new Person();
		Address address = new Address();

		person.setPersonName(name);
		address.setCity(city);
		address.setState(state);
		address.setPincode(pincode);
		person.setAddress(address);

		personDAO.save(person);

		System.out.println(person);
		System.out.println("Saved successfully...!!!");
	}

	private static void mainMenu(PersonDAO personDAO) {

		int choice = -1;

		do {
			printLine();
			System.out.println("1. Add person");
			System.out.println("2. View all");
			System.out.println("3. Delete all");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			choice = Utils.readLong().intValue();

			switch (choice) {

			case 1:
				savePerson(personDAO);
				break;
			case 2:
				displayAll(personDAO);
				break;
			case 3:
				deleteAll(personDAO);
				break;

			}
		} while (choice != 0);
	}

	private static void deleteAll(PersonDAO personDAO) {

		Query<Person> query = personDAO.createQuery();

		personDAO.deleteByQuery(query);

	}

	private static void printLine() {
		System.out.println("=================================================");
	}
}
