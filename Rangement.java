package packet.one;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class Rangement{
	private int refrangement;
	private String nomrangement;
	public Rangement(int ref,String nom) {
		refrangement=ref;
		nomrangement=nom;
	}
	public int getrefrangement() {
		return this.refrangement;
	}
	public String getnomrangement() {
		return nomrangement;
	}
}
class RangementDAO extends DAO1<Rangement>{
	
	public RangementDAO(Connection cnx) {
		super(cnx);
	}

	public Rangement find(int id) {
		Rangement elem=null;
	try {
		Statement stmt = cnx.createStatement();
		  ResultSet rs = stmt.executeQuery("select *from rangement where refrangement='"+id+"'");
		
		   while (rs.next()) {
			      
		       String name = rs.getString("nomrangement");
		      int ref= rs.getInt("refrangement");
		 elem=new Rangement(ref,name);
		  
		    }
		    return elem;
		 
	}
	catch(Exception e) {
		System.out.print("cant find element with the id "+id+"in the table rangement");
		return null;
	}
	}
	public boolean delete(Rangement t) {
		
		try {
			Statement stmt = cnx.createStatement();
			String cmd="delete from rangement where refrangement="+t.getrefrangement()+"";
			  int res=stmt.executeUpdate(cmd);
	
			return true;
		
			
		}
	
		catch(Exception e) {
			System.out.print("cant find element with the id "+t.getrefrangement()+"in the table rangement");
			return false;
		}
		
		
	}
	public boolean update(Rangement t) {
		try {
	Statement stm=cnx.createStatement();
String cmd="update Rangement set nomrangement='"+t.getnomrangement()+"' where refrangement="+t.getrefrangement()+"";
			int rs=stm.executeUpdate(cmd);
		return true;
		}
		catch(Exception e) {
			System.out.print(e.getLocalizedMessage());
			return false;
		}
	}
	
	//creation
	public boolean create (Rangement t) {
	
		try {
			Statement stmt = cnx.createStatement();
			String cmd="insert into rangement values("+t.getrefrangement()+",'"+t.getnomrangement()+"')";
 int rs = stmt.executeUpdate(cmd);
			

		return true;
	
			    
			   
			 
		}
		catch(Exception e) {
			System.out.print("cant create element with the id "+t.getnomrangement()+"in the table rangement");
			return true;
		}
	}
	

}