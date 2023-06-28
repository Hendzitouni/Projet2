package packet.one;
import java.sql.*;
import java.util.*;

abstract class DAO1<T>{
	Connection cnx;
	public DAO1(Connection cnx){
		this.cnx=cnx;
	}
	public abstract boolean delete(T obj);
	public abstract boolean create(T obj);
	public abstract boolean update(T obj);
	public abstract T find(int id);
//	public abstract ArrayList<T> findAll();
}




 



class DBMSConnection {
	
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String user="system";
	private static String password="root";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	public static Connection getConnection () {
		Connection cnx=null;
		try{Class.forName(driver); 
		cnx=DriverManager.getConnection(url,user,password);
		return cnx;
		}catch(Exception e) 
		{System.out.print(e.getLocalizedMessage());
		return cnx;
		}
	}
}
public class Test {
public static void main(String[]args) {
	 DBMSConnection  j=new  DBMSConnection ();
	
	Connection cnx=j.getConnection();
//	new Requets(cnx);
	new Affichage(cnx);
	/*typeingredientDAO t=new typeingredientDAO(cnx);
	TypeIngredient tt=new TypeIngredient("43",1);
	//t.delete(tt);
	try {
		Statement stmt2 = cnx.createStatement();
		String cmd2="delete from ingredient where reftype="+tt.getreftype()+"";
		Statement stmt = cnx.createStatement();
		String cmd="delete from typeingredient where reftype="+tt.getreftype()+"";
		int res2=stmt2.executeUpdate(cmd2);
	}catch(Exception e) {
		System.out.print(e.getLocalizedMessage());
	}*/

}
}
