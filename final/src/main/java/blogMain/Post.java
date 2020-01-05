package blogMain;

import java.util.*;

import java.sql.Date;

@SuppressWarnings("unused")
public class Post {

	private int id;
	private String titre;
	private String auteur;
	private String description;
	private String texte;
	private Date date;
	
	public Post(int id,String auteur,String titre,String description,String texte,Date date) {
	        this.id = id;
	        this.auteur = auteur;
	        this.titre = titre;
	        this.description = description;
	        this.texte = texte;
	        this.date = date;
	    }
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre (String titre) {
		this.titre = titre;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public void setAuteur (String auteur) {
		this.auteur = auteur;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription (String description) {
		this.description = description;
	}
	
	public String getTexte() {
		return texte;
	}
	
	public void setTexte (String texte) {
		this.texte = texte;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate (Date Now) {
		this.date = Now;
	}
	
}
