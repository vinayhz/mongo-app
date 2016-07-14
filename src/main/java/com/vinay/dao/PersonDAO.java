package com.vinay.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

import com.vinay.entity.Person;

public interface PersonDAO extends DAO<Person, ObjectId> {

}
