package packet.one;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


public class iamnah extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String user="system";
	private static String password="root";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
    public iamnah() {
        super("Database Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Create the JTable component and the model to hold the data
        table = new JTable();
        model = new DefaultTableModel();
        table.setModel(model);

        // Connect to the database and retrieve the data
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from emp");

            // Loop through the result set and add each row to the model
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>();
                for (int i = 1; i <= numColumns; i++) {
                    row.add(rs.getObject(i));
                }
                model.addRow(row);
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add the JTable component to the JFrame and make it visible
        add(new JScrollPane(table));
        setVisible(true);
    }

    public static void main(String[] args) {
        new iamnah();
    }
}
