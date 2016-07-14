package com.vinay.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "person", noClassnameStored = true)
public class Person {

	@Id
	private ObjectId objectId;

	private String personName;

	private String personAddress;

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

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public Person() {
	}

	public Person(String personName, String personAddress) {
		this.personName = personName;
		this.personAddress = personAddress;
	}

	@Override
	public String toString() {
		return "{ _id: " + objectId + ", personName: " + personName + ", personAddress: " + personAddress + "}";
	}
}
