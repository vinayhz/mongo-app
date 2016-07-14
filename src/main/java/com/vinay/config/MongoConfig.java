package com.vinay.config;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongoConfig {

	private static Datastore datastore = null;

	private MongoConfig() {
	}

	synchronized public static Datastore getDatastore() {

		if (datastore == null) {

			try {

				Morphia morphia = new Morphia();
				MongoClient mongoClient = new MongoClient(DBConfig.hostName);

				datastore = morphia.createDatastore(mongoClient, DBConfig.dbName);

			} catch (Exception exception) {
				exception.printStackTrace();
				System.exit(0);
			}

		}

		return datastore;
	}

}
