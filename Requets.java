package packet.one;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.util.Vector;
public class Requets extends JFrame {
	JButton b1,b2,b3,b4,b5,b6,b7;
	private JTable table;
    private DefaultTableModel model;
    Connection cnx;
	public Requets(Connection cnxn) {
		super("les requets");
		setVisible(true);
		this.cnx=cnxn;
		setSize(500,500);
		JPanel p1=new JPanel(new GridLayout(7,1));
		b1=new JButton("Requete1");
		b2=new JButton("Requete2");
		b3=new JButton("Requete3");
		b4=new JButton("Requete4");
		b5=new JButton("Requete5");
		b6=new JButton("Requete6");
		b7=new JButton("Requete7");
		p1.add(b1);p1.add(b2);p1.add(b3);p1.add(b4);p1.add(b5);
		p1.add(b6);p1.add(b7);
	JPanel p=new JPanel(new GridLayout(1,1));
	setContentPane(p);
	p.add(p1);
	JPanel p2=new JPanel();
    table = new JTable();
    model = new DefaultTableModel();
    table.setModel(model);
 add(new JScrollPane(table));
    setVisible(true);
  //  p.add(p2);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {

	            Statement stmt = cnx.createStatement();
	          //  ResultSet rs = stmt.executeQuery("select * from recette where CALORIESRECETTE>300");
	            ResultSet rs = stmt.executeQuery("select * from produit");
	            model.setRowCount(0);
	            model.setColumnCount(0);
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
	           
	        } catch (SQLException ee) {
	            ee.printStackTrace();
	        }

	        // Add the JTable component to the JFrame and make it visible
	      
		}
	});
b2.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
	
		try {

            Statement stmt = cnx.createStatement();
      ResultSet rs = stmt.executeQuery("select DESCRIPTIFPRODUIT  from produit where refrangement in(select refrangement from rangement where nomrangement='refrigateur')");
      model.setRowCount(0);
      model.setColumnCount(0);
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
                    System.out.print(i);
                }
                model.addRow(row);
            }

            // Close the connection
            rs.close();
            stmt.close();
           
        } catch (SQLException ee) {
            ee.printStackTrace();
        }


	}
});
b3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {

            Statement stmt = cnx.createStatement();
           ResultSet rs =
stmt.executeQuery("select nomrecette from recette where refrecette in (select refrecette from composition natural join\r\n"
	+ "ingredient  natural join typeingredient where nomtype='fruit de mer')");
           model.setRowCount(0);
           model.setColumnCount(0);
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
           
        } catch (SQLException ee) {
            ee.printStackTrace();
        }


	}
});

b4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {

            Statement stmt = cnx.createStatement();
            ResultSet rs =
stmt.executeQuery("select nomrangement from rangement natural join produit join composition using(refingredient) where refrecette='r002'");
            model.setRowCount(0);
            model.setColumnCount(0);
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
           
        } catch (SQLException ee) {
            ee.printStackTrace();
        }


	}
});
b5.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {

            Statement stmt = cnx.createStatement();
            ResultSet rs =
stmt.executeQuery("select nomrecette ,refrecette from recette where nomrecette like '%mousse%'");
            model.setRowCount(0);
            model.setColumnCount(0);
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
           
        } catch (SQLException ee) {
            ee.printStackTrace();
        }


	}
});

b6.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {

            Statement stmt = cnx.createStatement();
            ResultSet rs =
stmt.executeQuery("select sum(quantiteproduit )from produit join ingredient using (refingredient)  join typeingredient using (reftype)where nomtype ='farine'");
            model.setRowCount(0);
            model.setColumnCount(0);
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
         
        } catch (SQLException ee) {
            ee.printStackTrace();
        }


	}
});

b7.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {

            Statement stmt = cnx.createStatement();
            ResultSet rs =
stmt.executeQuery("select count (distinct (refrecette)) from composition join ingredient using(refingredient) where nomingredient like 'oeuf'");
            model.setRowCount(0);
            model.setColumnCount(0);
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
           
        } catch (SQLException ee) {
            ee.printStackTrace();
        }


	}
});


	}
	

}
