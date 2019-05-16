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


@Path(value="LivreRest")
public class LivreREST {
	
	private LivreDAO livreDAO = new LivreDAO();
	
	public void LivreRest() {}
	
	@GET
	@Path(value = "recuperation")
	public Object recuperation(@QueryParam("isbn") String isbn) {
		return livreDAO.getBook(isbn);
	}
	
	
	
	@POST
	@Path(value = "insert")
	public Object insertbook(@QueryParam("isbn") String sbn,@QueryParam("titre") String titre,@QueryParam("Auther") String auteur, @QueryParam("editeur")String editeur) {
		Livre livre = new Livre(sbn,titre,auteur,editeur);
		if (livreDAO.insert(livre)!= 0 ) {
			return "done";
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
