package packet.one;
import java.sql.*;
public class Ingredient {
int refingredient,reftype;
String nomingredient;
public Ingredient(String nom,int ref,int reff) {
	refingredient=ref;
	reftype=reff;
	nomingredient=nom;
}
public String getnomingredient() {
	return nomingredient;
}
public int getrefingredient() {
	return refingredient;
}
public int getreftype() {
	return reftype;
}
}
class IngredientDAO extends DAO1<Ingredient>{
	public IngredientDAO(Connection cnx) {
		super(cnx);
	}
	public boolean create (Ingredient t) {
		
		try {
			Statement stmt = cnx.createStatement();
			String cmd="insert into ingredient values("+t.getrefingredient()+",'"+t.getnomingredient()+"','"+t.getreftype()+"')";
 int rs = stmt.executeUpdate(cmd);
			System.out.print(rs);

		return true;
	
			    
			   
			 
		}
		catch(Exception e) {
			System.out.print("cant create element with the id "+t.getnomingredient()+"in the table rangement");
			return true;
		}
	}
	public boolean update(Ingredient t) {
		try {
	Statement stm=cnx.createStatement();
String cmd="update ingredient set nomingredient='"+t.getnomingredient()+"',reftype='"+t.getreftype()+"' where refingredient='"+t.getrefingredient()+"'";
			int rs=stm.executeUpdate(cmd);
		return true;
		}
		catch(Exception e) {
			System.out.print(e.getLocalizedMessage());
			return false;
		}
	}
public boolean delete(Ingredient t) {
		
		try {
			Statement stmt = cnx.createStatement();
			String cmd="delete from ingredient where refingredient='"+t.getrefingredient()+"'";
			  int res=stmt.executeUpdate(cmd);
	
			return true;
		
			
		}
	
		catch(Exception e) {
			System.out.print("cant find element with the id "+t.getrefingredient()+"in the table ingred");
			return false;
		}
		
		
	}
	public Ingredient find(int id) {
		Ingredient elem=null;
	try {
		Statement stmt = cnx.createStatement();
		  ResultSet rs = stmt.executeQuery("select *from ingredient where refingredient='"+id+"'");
		
		   while (rs.next()) {
			      
		       String name = rs.getString("nomingredient");
		      int ref= rs.getInt("refingredient");
		      int reff= rs.getInt("reftype");
		 elem=new Ingredient(name,ref,reff);
		  
		    }
		    return elem;
		 
	}
	catch(Exception e) {
		System.out.print("cant find element with the id "+id+"in the table rangement");
		return null;
	}
	}
}
