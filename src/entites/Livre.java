package entites;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Livre {

	
private String isbn;
private String titre;
private String auteur;
private String editeur;




public Livre(String isbn, String titre, String auteur, String editeur) {
	this.isbn = isbn;
	this.titre = titre;
	this.auteur = auteur;
	this.editeur = editeur;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
}
public String getEditeur() {
	return editeur;
}
public void setEditeur(String editeur) {
	this.editeur = editeur;
}





	
}
