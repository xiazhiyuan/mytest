package test.mongo;

import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.util.JSON;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MongoTest {
	public static void main(String args[]) {
		try {
			MongoTest mongoTest = new MongoTest() ;
//			connectDb("localhost", 27017) ;
//			mongoTest.testInsert(); 
			mongoTest.testRetrieve("name", "杨俊明") ;
//			mongoTest.testUpdate();
			



			// 复杂对象
//			UserData userData = new UserData("jimmy", "123456");
//			Set<String> pets = new HashSet<String>();
//			pets.add("cat");
//			pets.add("dog");
//			Map<String, String> favoriteMovies = new HashMap<String, String>();
//			favoriteMovies.put("dragons", "Dragons II");
//			favoriteMovies.put("avator", "Avator I");
//			userData.setFavoriteMovies(favoriteMovies);
//			userData.setPets(pets);
//			userData.setBirthday(getDate(1990, 5, 1));
//			BasicDBObject objUser = new BasicDBObject("key", "jimmy").append("value", toDBObject(userData));
//			coll.insert(objUser);
//			System.out.println(coll.findOne(objUser));
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	public DB  connectDb(String host,int port) {
		// 连接到 mongodb 服务
//		Mongo mongoClient = new Mongo("localhost", 27017);
		try{
			Mongo mongoClient = new Mongo(host, port);
			// 连接到数据库
			DB db = mongoClient.getDB("test1111");
			System.out.println("Connect to database successfully");
			return db ;
			// boolean auth = db.authenticate("xiazhiyuan",
			// "xiazhiyuan".toCharArray());
			// System.out.println("Authentication: "+auth);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null ;
	}
	
	public void testInsert() throws UnknownHostException, MongoException {
//		DB db = connectDb("localhost",27017);
		Mongo mongoClient = new Mongo("127.0.0.1", 27017);
		// 连接到数据库
		DB db = mongoClient.getDB("test1111");
		System.out.println("Connect to database successfully");
		DBCollection coll = db.getCollection("emp");
		BasicDBObject doc = new BasicDBObject("name", "杨俊明").append("sex", "男").append("address",
				new BasicDBObject("postcode", "201202").append("street", "田林路888号").append("city", "上海"));
		coll.insert(doc);
	}
	
	public DBObject testRetrieve(String key,String value) {
		DB db = connectDb("127.0.0.1",27017);
		DBCollection coll = db.getCollection("emp");
		// retrieve
//		BasicDBObject docFind = new BasicDBObject("name", "杨俊明");
		BasicDBObject docFind = new BasicDBObject(key, value);
		DBObject findResult = coll.findOne(docFind);
		System.out.println(findResult);
		return findResult ;
	}
	
	public void testUpdate(){
		DB db = connectDb("127.0.0.1",27017);
		DBCollection coll = db.getCollection("emp");
		// update
		DBObject findResult = testRetrieve("name", "杨俊明") ;
	    BasicDBObject newBasicDBObject =new BasicDBObject().append("$set",new BasicDBObject().append("sex", "MALE") );  
//       collection.update(new BasicDBObject().append("id", 1).append("name", "小明"),newBasicDBObject); 
		coll.update(findResult,newBasicDBObject);
		findResult = coll.findOne(findResult);
		System.out.println(findResult);
	}
    /**
     * 将普通Object对象转换成mongodb的DBObject对象
     * 
     * @param obj
     * @return
     */
    private static DBObject toDBObject(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return (DBObject) JSON.parse(json);
    }

    /**
     * 获取指定日期
     * 
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day);
        return calendar.getTime();

    }
}
