package DAO;
import java.sql.Connection;

import entites.Livre;

import java.sql.*;

public class LivreDAO {
	   private Connection con = null;
	   private Statement stmt = null;
	   private ResultSet rs = null;
	   
	   
	   public int insert(Livre c) {
 
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {

	            con = Connexion.getInstance().getConnection();
	            String query = "insert into Livre (isbn, titre, auteur,editeur) values (?,?,?,?)";
	            pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	            pstmt.setString(1, c.getIsbn());
	            pstmt.setString(2, c.getTitre());
	            pstmt.setString(3, c.getAuteur());
	            pstmt.setString(4, c.getEditeur());
	            pstmt.executeUpdate();
	            rs = pstmt.getGeneratedKeys();
	            if(rs != null && rs.next()){
	                System.out.println("Generated Emp Id: "+rs.getInt(1));
	                return 1;
	            }


	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstmt != null) pstmt.close();
	                if (con != null) con.close();
	            } catch (Exception ex) {
	            }


	        }
	            return 0;
	    }

	    public int delete(String isbn) {
	   
	        try {

	            con = Connexion.getInstance().getConnection();
	            stmt = con.createStatement();

	            String sql = "DELETE FROM livre WHERE isbn = "+ isbn;
	            stmt.executeUpdate(sql);

	            while (rs.next()) {
	                System.out.print("livre deleted");
	                return 1;
	            }



	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }


	        return 0;

	    }
	    
	    
	    
	    
	    

	    public Livre getBook(String isbn) {
	    	 try {

	             con = Connexion.getInstance().getConnection();
	             stmt = con.createStatement();
	             String query=
	                     "SELECT * FROM livre  WHERE isbn = "+ isbn;


	             rs = stmt.executeQuery(query);

	             while (rs.next()) {


	                 String isbnL = rs.getString("isbn");
	                 String auther = rs.getString("auther");
	                 String name = rs.getString("name");
	                 String editeur = rs.getString("editeur");
	                 Livre result = new Livre(isbnL,auther,name,editeur);

	                 return result;
	             }



	         } catch (SQLException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
// if we don't find the book 
	         return null;

	    }
	    
	     
	    
	    
	    public int update(Livre c) {
	    	   PreparedStatement pstmt = null;
		        ResultSet rs = null;
		        try {
		         
		            con = Connexion.getInstance().getConnection();
		            String query = "UPDATE Livre SET description = ?, editeur = ?,titre= ?, WHERE isbn = ?";
		            pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		            pstmt.setString(2, c.getAuteur());
		            pstmt.setString(1, c.getEditeur());
		            pstmt.setString(3, c.getAuteur());
		            pstmt.setString(4, c.getIsbn());
		            pstmt.executeUpdate();
		            rs = pstmt.getGeneratedKeys();
		            if(rs != null && rs.next()){
		                System.out.println("Update Emp Id: "+rs.getInt(3));
		                return 1;
		            }


		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } finally {
		            try {
		                if (rs != null) rs.close();
		                if (pstmt != null) pstmt.close();
		                if (con != null) con.close();
		            } catch (Exception ex) {
		            }


		        }
		            return 0;
	    }
	    
	    
	   
}
