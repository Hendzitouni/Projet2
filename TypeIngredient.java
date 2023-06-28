package packet.one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TypeIngredient {
	
private int reftype;
private String nomtype;
public TypeIngredient(String n,int i) {
	reftype=i;
	nomtype=n;
}
public String getnomtype() {return nomtype;}
public int getreftype() {return reftype;}

}
class typeingredientDAO extends DAO1<TypeIngredient>{
	
	public typeingredientDAO(Connection cnx) {
		super(cnx);
	}
	
	
	public TypeIngredient find(int id) {
		TypeIngredient elem=null;
	try {
		Statement stmt = cnx.createStatement();
		  ResultSet rs = stmt.executeQuery("select *from typeingredient where reftype='"+id+"'");
		
		   while (rs.next()) {
			      
		       String name = rs.getString("nomtype");
		      int ref= rs.getInt("reftype");
		 elem=new TypeIngredient(name,ref);
		  
		    }
		    return elem;
		 
	}
	catch(Exception e) {
		System.out.print("cant find element with the id "+id+"in the table type ingredient");
		return null;
	}
	}
	public boolean delete(TypeIngredient t) {
		
		try {
			Statement stmt2 = cnx.createStatement();
			String cmd2="delete from ingredient where reftype="+t.getreftype()+"";
			Statement stmt = cnx.createStatement();
			String cmd="delete from typeingredient where reftype="+t.getreftype()+"";
			int res2=stmt2.executeUpdate(cmd2);
			//  int res=stmt.executeUpdate(cmd);
		
			  
			
					
			return true;
		
			
		}
	
		catch(Exception e) {
			System.out.print("cant delete element with the id "+t.getreftype()+"in the table rtypeingred");
			return false;
		}
		
		
	}
	public boolean update(TypeIngredient t) {
		try {
	Statement stm=cnx.createStatement();
String cmd="update typeingredient set nomtype='"+t.getnomtype()+"' where reftype="+t.getreftype()+"";
			int rs=stm.executeUpdate(cmd);
		return true;
		}
		catch(Exception e) {
			System.out.print(e.getLocalizedMessage());
			return false;
		}
	}
	
	//creation
	public boolean create (TypeIngredient t) {
	
		try {
			Statement stmt = cnx.createStatement();
			String cmd="insert into typeingredient values("+t.getreftype()+",'"+t.getnomtype()+"')";
 int rs = stmt.executeUpdate(cmd);
			

		return true;
	
			    
			   
			 
		}
		catch(Exception e) {
			System.out.print("cant create element with the id "+t.getnomtype()+"in the table rangement");
			return true;
		}
	}
	
}
