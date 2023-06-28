package packet.one;
import java.sql.*;
public class produit {
	public produit(int u1,String u2,String u3,int u4,int u5,int u6,int u7) {
		refproduit=u1;
		descriptionproduit=u2;dateproduit=u3;qtproduit=u4;prixproduit=u5;refrangement=u6;refingredient=u7;
	}
	public produit(int i) {
		refproduit=i;
	}
int refproduit,qtproduit,prixproduit,refrangement,refingredient;
String descriptionproduit,dateproduit;
}
class produitDAO extends DAO1<produit>{
	public produitDAO(Connection cnx) {
		super(cnx);
	}
	public produit find(int id) {
		produit elem=null;
	try {
		Statement stmt = cnx.createStatement();
		  ResultSet rs = stmt.executeQuery("select *from produit where refproduit='"+id+"'");
		
		   while (rs.next()) {
			      
		     
		      int ref= rs.getInt("refproduit");
		 elem=new produit(ref);
		  
		    }
		    return elem;
		 
	}
	catch(Exception e) {
		System.out.print("cant find element with the id "+id+"in the table rangement");
		return null;
	}
	}
	public boolean delete(produit t) {
		
		try {
			Statement stmt = cnx.createStatement();
			String cmd="delete from produit where refrecette='"+t.refproduit+"'";
			  int res=stmt.executeUpdate(cmd);
	
			return true;
		
			
		}
	
		catch(Exception e) {
			System.out.print("cant find element with the id "+t.refproduit+"in the table rtypeingred");
			return false;
		}
		
		
	}
	public boolean update(produit t) {
		try {
	Statement stm=cnx.createStatement();
String cmd="update recette set nomrecette='"+t.refingredient+"' where refrecette='"+t.refproduit+"'";
			int rs=stm.executeUpdate(cmd);
		return true;
		}
		catch(Exception e) {
			System.out.print(e.getLocalizedMessage());
			return false;
		}
	}
	
	//creation
	public boolean create (produit t) {
	
		try {
			Statement stmt = cnx.createStatement();
			String cmd="insert into produit values("+t.refproduit+",'"+ t.descriptionproduit+"','"+t.dateproduit+"',"+t.qtproduit+","+t.prixproduit+","+t.refrangement+","+t.refingredient+")";                                                                  
 int rs = stmt.executeUpdate(cmd);
			

		return true;
	
			    
			   
			 
		}
		catch(Exception e) {
			System.out.print("cant create element with the id "+t.refproduit+"in the table rangement");
			return true;
		}
	}
}
