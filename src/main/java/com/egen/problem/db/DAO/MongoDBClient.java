package com.egen.problem.db.DAO;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

/**
* MongoDBClient gives DataStore to perfom CRUD operations
* @author  Rajala Mourya
* @version 1.0
*/
public final class MongoDBClient {
	
	private static Datastore datastore = null;
	public static Datastore createDataStore() throws UnknownHostException 
	{
		if(datastore == null)
		{
			final Morphia morphia = new Morphia();
			morphia.mapPackage("com.egen.problem.ws.model");
			datastore = morphia.createDatastore(new MongoClient(), "egendata");
			datastore.ensureIndexes();
			return datastore;
		}
		return datastore;
		
	}
	private MongoDBClient()
	{
		
	}

}
