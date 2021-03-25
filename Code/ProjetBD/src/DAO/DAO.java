package DAO;
import java.sql.Connection;



public abstract class DAO<T> { 
	protected Connection connect = null; 
	
	public DAO(Connection conn){ 
		this.connect = conn; 
	}
	//public abstract T read(); 
	public abstract T read(int i); 
	//public abstract boolean create(T obj);
	public abstract boolean create(T obj);
	
}