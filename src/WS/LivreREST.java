package WS;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import DAO.LivreDAO;
import entites.Livre;
import javax.ws.rs.core.MediaType;
@Path(value="LivreRest")
public class LivreREST {
	
	private LivreDAO livreDAO = new LivreDAO();
	
	public void LivreRest() {}
	
	@GET
	@Path(value = "recuperation")
	public Object recuperation(@QueryParam("isbn") String isbn) {
		return livreDAO.getBook(isbn);
	}
	
	
	
	// insertJSON 
	
	@POST
	@Path(value = "insertJSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Object insertJSON(Livre livre ) {
		if (livreDAO.insert(livre)!= 0 ) {
			return "done";
		}else {
			return "error";
		}
		
	}
	
	
	// insertXML
	
	    @POST
		@Path(value = "insert")
		@Consumes(MediaType.APPLICATION_ATOM_XML)
		public Object insertXML(Livre livre) {
			if (livreDAO.insert(livre)!= 0 ) {
				return "done";
			}else {
				return "error";
			}
			
		}
		
	    
	    
	   // searchJSON 
		
    @GET
    @Path(value ="searchJSON")
	@Produces(MediaType.APPLICATION_JSON)
    public Object searchJSON(@QueryParam("isbn") String isbn) {
    	// return null if not found 
		return livreDAO.getBook(isbn);
    }
		
		
    // searchAll 
    @GET
    @Path(value ="searchAll")
	@Produces(MediaType.APPLICATION_JSON)

    public Object searchAll() {
    	// return null if not found 
    			return livreDAO.getALLBooks();
    }
		
		
    
    
   
    
// editJSON
	@POST
	@Path(value = "editJSON")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object editJSON(Livre livre) {
		//vérifier l’existence du livre à modifier
		if (livreDAO.getBook(livre.getIsbn())!= null ) {
		
			// update
			livreDAO.update(livre);
			
			
			return livreDAO.getBook(livre.getIsbn());
		}else {
			return "error";
		}
		
	}
    
    
    
	
	
	
	
	
	@POST
	@Path(value = "update")
	public Object Update(@QueryParam("isbn") String sbn,@QueryParam("titre") String titre,@QueryParam("Auther") String auteur, @QueryParam("editeur")String editeur) {
		Livre livre = new Livre(sbn,titre,auteur,editeur);
		if (livreDAO.update(livre)!= 0 ) {
			return "done";
		}else {
			return "error";
		}
		
	}
	
	@DELETE
	@Path(value = "supprimer")
	public Object supprimer(@QueryParam("isbn") String isbn) {
		if (livreDAO.delete(isbn)!= 0 ) {
			return "done";
		}else {
			return "error";
		}
	}
	
	
}
