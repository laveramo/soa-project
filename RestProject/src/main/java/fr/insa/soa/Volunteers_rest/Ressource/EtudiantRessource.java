package fr.insa.soa.Volunteers_rest.Ressource;

import fr.insa.soa.Volunteers_rest.Etudiant;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;


@Path("etudiant")
public class EtudiantRessource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@Context UriInfo uriInfo) {   // UriInfo est utilisée pour accéder aux informations des requétes
		Etudiant etudiant=new Etudiant();
		etudiant.setNom("Noussama");
		etudiant.setPrenom("Geljid");
		etudiant.setId(01);
		etudiant.addLink(getUriforSelf(uriInfo,etudiant), "self", "GET");
		etudiant.addLink(getUriforStage(uriInfo), "Stage", "GET");
		return etudiant;
	}
	
	private String getUriforStage(UriInfo uriInfo) {
		String url=uriInfo.getBaseUriBuilder() // http://localhost:8080/RestProject/webapi
				.path(StageRessource.class)    //stage
				.build()
				.toString();
		return url;
	}
	
	private String getUriforSelf(UriInfo uriInfo , Etudiant etudiant) {
		String url=uriInfo.getBaseUriBuilder() // http://localhost:8080/RestProject/webapi
				.path(EtudiantRessource.class)    //etudiant
				.path(Long.toString(etudiant.getId()))  // /01
				.build()
				.toString();
		return url;
	}
	
	
	@GET
	@Path("/{idEtudiant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@PathParam("idEtudiant") int id) {
		Etudiant etudiant=new Etudiant();
		etudiant.setNom("A");
		etudiant.setPrenom("B");
		return etudiant;
	}
	
	@POST
	@Path("/{idEtudiant}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addEtudiant(Etudiant etudNouv) {
		System.out.println("Ajout de l'étudiant " +etudNouv.getNom()+""+etudNouv.getPrenom()+" réussie!");
		System.out.println("Son binome est  " +etudNouv.getBinome().getPrenom()+""+etudNouv.getBinome().getNom());
		
	}
}
