package com.example.supbarter.webservice;

import com.example.supbarter.dao.daoInterface.IObjectDao;
import com.example.supbarter.entity.Object;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/objects")
public class ObjectService {
	@EJB
	IObjectDao objectDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> getAll() {
		return objectDao.getAll();
	}
}
