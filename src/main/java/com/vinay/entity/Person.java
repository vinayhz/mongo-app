package com.vinay.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "person", noClassnameStored = true)
public class Person {

	@Id
	private ObjectId objectId;

	private String personName;

	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Person() {
	}

	public Person(String personName, Address address) {
		this.personName = personName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "{ _id: " + objectId + ", personName: " + personName + ", address: { city: " + address.getCity() + ", state: " + address.getState()
				+ ", pincode: " + address.getPincode() + "}}";
	}
}
