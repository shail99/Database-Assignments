package edu.neu.cs5200.msn.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.neu.cs5200.msn.orm.models.Site;

@Path("/site")
public class SiteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_JWS_Assignment");
	EntityManager em = factory.createEntityManager();
	
	//findSiteById
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") Integer siteId)
	{
		return em.find(Site.class, siteId);
	}
	
	//findAllSites
	@SuppressWarnings("unchecked")
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites()
	{
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	
	//updateSite
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") Integer siteId, Site site)
	{
		em.getTransaction().begin();
		site.setId(siteId);
		em.merge(site);
		em.getTransaction().commit();
		return findAllSites();
		
	}
	
	//removeSite
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") Integer siteId)
	{
		em.getTransaction().begin();
		Site site = em.find(Site.class, siteId);
		em.remove(site);
		
		em.getTransaction().commit();
		
		return findAllSites();
	}
	
	
	//createSite
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public List<Site> createSite(Site site) {	
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SiteDao dao = new SiteDao();
		
		// create a new site
		//Site site_c = new Site(null,"Site3",13.21,24.22);
		//site_c = dao.createSite(site_c);
		
		// finding a site by Id
		//Site site_r = dao.findSite(4);
		//System.out.println(site_r.getName());
		
		//Updating a particular site
		//site_r.setName("Site 5");
		//dao.updateSite(4,site_r);
		
		// finding all the sites
		//List<Site> sites = dao.findAllSites();
		/*for(Site site : sites)
		{
			System.out.println(site.getName());
		}*/
		
		// removing a particular site
		//dao.removeSite(3);
	}


}
