package packet.one;
import java.sql.*;
abstract class   DAO<T>{
	Connection cnx=null;
	public DAO(Connection cxn){cnx=cxn;
		
	}
	public abstract boolean create(T tt);
	public abstract boolean update(T t);
	public abstract boolean delete(T t);
	public abstract boolean find(T t);
}
class matiere{
	String nom;
	int code;
	public matiere(String n,int c) {this.code=c;this.nom=n;}
	
}
class teacher{
	String nom,prenom;
	int mat;
	public teacher(String n,int m,String p) {prenom=p;mat=m;nom=n;}
}
class teache{
	int code;
	int mat;
	int anne;
	public teache(int c,int m,int a) {
		anne=a;
		code=c;mat=m;
	}
}
class teacherDAO extends DAO<teacher>{
	public teacherDAO(Connection cn) {
		super(cn);
	};
	public  boolean create(teacher tt) {
	try {	Statement stmt = cnx.createStatement();
		
		ResultSet rsr = stmt.executeQuery("select * from teacher");
		 while (rsr.next()) {
		      
		        String name = rsr.getString("namee");
		 
		        System.out.println(name);
		    }
		return true;
		}
	catch(Exception e) {
		System.out.print("prbleme class create teacher");return false;
	}
	};
	public  boolean update(teacher tt)
	{
		try {	Statement stmt = cnx.createStatement();
		String st="update teacher set name='"+tt.nom+"' where mat='"+tt.mat+"';";
		ResultSet rs = stmt.executeQuery(st);
		return true;
		}
	catch(Exception e) {
		System.out.print("prbleme class update  teacher");return false;
	}
	};
	public  boolean delete(teacher tt) {
		try {	Statement stmt = cnx.createStatement();
		String st="delete from teacher where mat='"+tt.mat+"';";
		ResultSet rs = stmt.executeQuery(st);
		return true;
		}
	catch(Exception e) {
		System.out.print("prbleme class delete  teacher");return false;
	}

	}
	public  boolean find(teacher tt) {
		try {	Statement stmt = cnx.createStatement();
		String st="delete from teacher where mat='"+tt.mat+"';";
		ResultSet rs = stmt.executeQuery(st);
		return true;
		}
	catch(Exception e) {
		System.out.print("prbleme class delete  teacher");return false;
	}
	};
}
class JDBC {
	Connection cnx=null;
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String user="system";
	private static String password="root";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	public JDBC () {
		
		try{Class.forName(driver); 
		cnx=DriverManager.getConnection(url,user,password);
		}catch(Exception e) 
		{System.out.print(e.getLocalizedMessage());}
	}
}
public class main {
public static void main(String[]args) {
	JDBC cnx=new JDBC();
	//teacher t=new teacher("k",122,"ll");
	teacherDAO td=new teacherDAO(cnx.cnx);
	
//	td.create(t);
	int id=34;
	
produit t=new produit(122,"llk","3/3/2021",43,4,43,333);
String cmd="insert into produit(refproduit,DESCRIPTIFPRODUIT ,DATEPEREMPTION,QUANTITEPRODUIT ,PRIXPRODUIT,REFRANGEMENT,REFINGREDIENT) values("+t.refproduit+","+ t.descriptionproduit+","+t.dateproduit+","+t.qtproduit+","+t.prixproduit+","+t.refrangement+","+t.refingredient    +         ")";                                                         
new Affichage(cnx.cnx);
//System.out.print(cmd);
	
	
	
	
	
	
}
}
