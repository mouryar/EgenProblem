package com.egen.problem.db.DAO;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

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
