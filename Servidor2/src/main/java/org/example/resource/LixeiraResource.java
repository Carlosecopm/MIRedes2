package org.example.resource;

import org.example.model.Lixeira;
import org.example.repository.LixeiraRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/lixeira")
public class LixeiraResource {

    private LixeiraRepository _repositorio = new LixeiraRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lixeira> get() {
        return _repositorio.GetAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lixeira getById(@PathParam("id") int id) {
        return _repositorio.Get(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Lixeira lixeira)
    {
        try{
            _repositorio.Add(lixeira);
            return Response.status(Response.Status.CREATED).entity(lixeira).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, Lixeira lixeira)
    {
        Lixeira p = _repositorio.Get(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            lixeira.setId(id);
            _repositorio.Edit(lixeira);
            return Response.status(Response.Status.OK).entity(lixeira).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id)
    {
        Lixeira p = _repositorio.Get(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            _repositorio.Delete(id);
            return Response.status(Response.Status.OK).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }
    }
}
