package packet.one;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class Recette {
	public Recette(String n,int nn) {
		refrecette=nn;
		nomrecette=n;
	}
int refrecette,calorierecette,tempspreparation,tempscuisson,nbpersonne;
String nomrecette,descriptionrecette,difficulte;


}
class RecetteDAO extends DAO1<Recette>{
	public RecetteDAO(Connection cnx) {
		super(cnx);
	}
	public Recette find(int id) {
		Recette elem=null;
	try {
		Statement stmt = cnx.createStatement();
		  ResultSet rs = stmt.executeQuery("select *from recette where refrecette='"+id+"'");
		
		   while (rs.next()) {
			      
		       String name = rs.getString("nomrecette");
		      int ref= rs.getInt("refrecette");
		 elem=new Recette(name,ref);
		  
		    }
		    return elem;
		 
	}
	catch(Exception e) {
		System.out.print("cant find element with the id "+id+"in the table rangement");
		return null;
	}
	}
	public boolean delete(Recette t) {
		
		try {
			Statement stmt = cnx.createStatement();
			String cmd="delete from recette where refrecette='"+t.refrecette+"'";
			  int res=stmt.executeUpdate(cmd);
	
			return true;
		
			
		}
	
		catch(Exception e) {
			System.out.print("cant find element with the id "+t.refrecette+"in the table rtypeingred");
			return false;
		}
		
		
	}
	public boolean update(Recette t) {
		try {
	Statement stm=cnx.createStatement();
String cmd="update recette set nomrecette='"+t.nomrecette+"' where refrecette='"+t.refrecette+"'";
			int rs=stm.executeUpdate(cmd);
		return true;
		}
		catch(Exception e) {
			System.out.print(e.getLocalizedMessage());
			return false;
		}
	}
	
	//creation
	public boolean create (Recette t) {
	
		try {
			Statement stmt = cnx.createStatement();
			String cmd="insert into Recette(refrecette,nomrecette) values("+t.refrecette+",'"+t.nomrecette+"')";
 int rs = stmt.executeUpdate(cmd);
			

		return true;
	
			    
			   
			 
		}
		catch(Exception e) {
			System.out.print("cant create element with the id "+t.nomrecette+"in the table rangement");
			return true;
		}
	}
}
