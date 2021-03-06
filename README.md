# Features

* Using the database takes only 1 line of code
* Generic ORM functions(CRUD)
* Auto-Generate DTOs
* Object fields
* Reload SQL dynamically
* Sharding support 
* Write multi-line strings easily

5 minutes video: [Youtube](http://www.youtube.com/watch?v=3qpr0J7D7cQ) / [YouKu](http://v.youku.com/v_show/id_XMTU0ODk1MzA2MA==.html) 

[Example Project](https://github.com/11039850/monalisa-example) |  [Eclipse Plugin](https://github.com/11039850/monalisa-orm/wiki/Code-Generator#eclipse-plugin)


# Usage


## Using Database with plugin

![image](https://github.com/11039850/monalisa-orm/raw/master/doc/images/db.gif)

## Using Database without plugin

```java  

	@DB(url="jdbc:mysql://127.0.0.1:3306/test" ,username="root", password="root")
	public interface TestDB{
		public static DBConfig DB=DBConfig.fromClass(TestDB.class);  
		
		public static class NewsModelGenerator{
			public static void main(String[] args) {
				DBModelGenerateMain.generateModelClass(TestDB.class);
			}
		}
	}
```

```java
	new User().setName("zzg.zhou").setStatus(1).save();
```	
 

## Auto-Generate DTOs (need eclipse-plugin)

![image](https://github.com/11039850/monalisa-orm/raw/master/doc/images/select.gif)

```java
	public class UserBlogDao {
		@Select(name="test.result.UserBlogs")      // <--- Auto create/update: test.result.UserBlogs
		public List  selectUserBlogs(int user_id){ // <--- Auto replace List to List<UserBlogs>
			Query q=TestDB.DB.createQuery();
			            
			q.add(""/**~{
				SELECT a.id, a.name, b.title, b.content, b.create_time
					FROM user a, blog b   
					WHERE a.id=b.user_id AND a.id=?		
			}*/, user_id);
			 
			return q.getList();               // <--- Auto replace getList() to getList<UserBlogs>
		} 
	}
```


## Database Service

Direct Database Access by HTTP, see: [monalisa-service](https://github.com/11039850/monalisa-service)
```
  curl http://localhost:8080/your_web_app/dbs/testdb/your_table_name
```

## Query Example

### Insert

```java
	//insert
	new User().setName("zzg.zhou").setStatus(1).save();
	
	//parse data from type: Map, json/xml string, JsonObject(Gson), HttpServletRequest, JavaBean
	new User().parse("{'name':'oschina','status':0}").save();
	new User().parse("<data> <name>china01</name><status>1</status> </data>").save();
	new User().parse(request).save();
	
	//Object field
	Address address=new Address("guangdong","shenzhen");
	user.setAddress(address).save();
	
	//File field
	String detail_save_path="path/001.txt";
	String content="This is a big text.";
	user.setDetail(path,content.getBytes()).save(); 
	user.getDetailAsString();
```


### Delete

```java
	//delete user by primary key or unique key
	user.delete();
	
	//SQL: DELETE FROM `user` WHERE `name`='china01'
	User.WHERE().name.eq("china01").delete();
	
	User.DELETE().deleteAll();
	User.DELETE().truncate();     
```


### Update

```java
	//update by primary key
	User user=User.SELECT().selectOne("name=?", "zzg.zhou");
	user.setStatus(3).update();
	
		
	//SQL: UPDATE user SET name='tsc9526' WHERE name like 'zzg%'	
	User updateTo=new User().setName("tsc9526");
	User.WHERE().name.like("zzg%").update(updateTo);
```
 

### Select

```java
	//select by primary key
	User.SELECT().selectByPrimaryKey(1);
	
	//SQL: SELECT * FROM `user` WHERE `name` = 'zzg.zhou'
	User.SELECT().selectOne("name=?", "zzg.zhou");
	
	//SQL: SELECT `name`, `status` FROM `user`
	User.SELECT().include("name","status").select();
 
 	//SQL: SELECT * FROM `user` WHERE (`name` like 'zzg%' AND `status` >= 0) 
	//                             OR (`name` = 'zzg' AND `status` > 1) ORDER BY `status` ASC 
	for(User x:User.WHERE()
			.name.like("zzg%").status.ge(0)
			.OR()
			.name.eq("zzg").status.gt(1)
			.status.asc()
			.SELECT().select()){ //SELECT / delete / update
		System.out.println(x);
	}
	
 	//Page
	Page<User> page=User.WHERE()
		.name.like("zzg%")
		.status.in(1,2,3)
		.SELECT().selectPage(10,0);	
	
```

### Query

```java
	TestDB.DB.select("SELECT * FROM user WHERE name like ?","zzg%");
	
	TestDB.DB.createQuery()
		.add("SELECT * FROM user WHERE name like ?","zzg%")
		.getList(User.class);
	 
```

### DataTable	

```java
	Query q=new Query(TestDB.DB);
	DataTable<DataMap> rs=q.add("SELECT * FROM user WHERE name like ?","zzg%")
	 .add(" AND status ").in(1,2,3)
	 .getList();
	 
	//Query inside DataTable
	//SQL: SELECT name, count(*) as cnt FROM _THIS_TABLE WHERE status>=0 GROUP BY name ORDER BY name ASC
	DataTable<DataMap> newTable=rs.select("name, count(*) as cnt","status>=0","name ASC","GROUP BY name");	
```

### Transaction

```java
	//transaction
	Tx.execute(new Tx.Atom() {
		public int execute() {
			new User().setName("name001").setStatus(1).save();
			new User().setName("name002").setStatus(2).save();
			//... other database operation
			return 0;
		}
	});
```

### Record

```java
	//Dynamic model: Record
	Record r=new Record("user").use(TestDB.DB);
	r.set("name", "jjyy").set("status",1)
	 .save();
		
	//SQL: SELECT * FROM `user` WHERE (`name` like 'jjyy%' AND `status` >= 0)
	//                             OR (`name` = 'zzg' AND `status` > 1) ORDER BY `status` ASC 
	for(Record x:r.WHERE()
			.field("name").like("jjyy%").field("status").ge(0)
			.OR()
			.field("name").eq("zzg").field("status").gt(1)
			.field("status").asc()
			.SELECT().select()){
		System.out.println(x);
	} 
		
	//SQL: DELETE FROM `user` WHERE `name` like 'jjyy%' AND `status` >= 0
	r.WHERE()
	 .field("name").like("jjyy%").field("status").ge(0)
	 .delete();
```		  

### Sharding

```java
	public class ShardingUser extends User{
		//Override
		public Table table(){
			String tableName= "user_"+( getId()%10 );
			return ModelMeta.createTable(tableName);
		}
		
		//Override
		public DBConfig db(){
			return getId()<10 ? TestDB.DB1 : TestDB.DB2;
		}
	}
	
	ShardingUser user1=new ShardingUser(1);
	user1.save(); //Will be saved to table: user_1, database: TestDB.DB1
	
	ShardingUser user2=new ShardingUser(15);
	user2.save(); //Will be saved to table: user_5, database: TestDB.DB2
```	


## Multi-line strings

see [Multiple-line-syntax](https://github.com/11039850/monalisa-orm/wiki/Multiple-line-syntax)

```java
	public static void main(String[] args) {
		String name="zzg";
		
		String lines = ""/**~!{
			SELECT * 
				FROM user
				WHERE name="$name"
		}*/;
		
		System.out.println(lines);
	}
```

Output will be:

```sql
	SELECT * 
		FROM user
		WHERE name="zzg"
```


[Details](https://github.com/11039850/monalisa-orm/wiki)

# Maven: 
```xml	
	<dependency>
		<groupId>com.tsc9526</groupId>
		<artifactId>monalisa-orm</artifactId>
		<version>2.1.0</version>
	</dependency>
``` 

# Change Log

* 2.1.0  Add oracle dialect
* 2.0.0  Only Mysql     
    
# TODO list

* Other database's dialect
* Automatic refresh the query cache in the background
* ...


If you have any ideas or you want to help with the development just write me a message.

**zzg zhou**, 11039850@qq.com
