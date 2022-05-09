package edu.poniperro;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.poniperro.domain.Legume;
import edu.poniperro.services.LegumeService;


@Path("/legume")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LegumeResource {

    @Inject
    LegumeService legumeService;

    @GET
    public List<Legume> list(Legume legume) {
        return Legume.listAll();
    }
}
