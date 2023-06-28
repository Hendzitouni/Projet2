package packet.one;
import java.sql.*;
public class plz {

	public static void main(String[]args) {
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String pass="root";
	Connection cnx;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cnx=DriverManager.getConnection(url,user,pass);
		
		
		Statement stmt = cnx.createStatement();
		  ResultSet rs = stmt.executeQuery("select *from rangement");
		
		   while (rs.next()) {
			      
		       String name = rs.getString("nomrangement");
		 
		        System.out.println(name);
		    }
		    cnx.close();
		  
	}catch(Exception e) {System.out.print(e.getLocalizedMessage());}
		
		
		
		
		
	}
}
/*String sql = "SELECT name, email, age FROM customers";
try (Connection connection = DriverManager.getConnection(url, username, password);
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(sql)) {

ResultSetMetaData metaData = resultSet.getMetaData();
int columnCount = metaData.getColumnCount();
System.out.println("Column Count: " + columnCount);

for (int i = 1; i <= columnCount; i++) {
   String columnName = metaData.getColumnName(i);
   String columnType = metaData.getColumnTypeName(i);
   int columnSize = metaData.getColumnDisplaySize(i);
   System.out.println(columnName + " - " + columnType + "(" + columnSize + ")");
}
}
*/