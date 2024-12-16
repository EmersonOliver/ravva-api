package br.ravva.resources;

import br.ravva.core.service.StatusService;
import br.ravva.resources.dto.RequestDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("ravva")
public class RavvaRequestResource {


    @Inject
    StatusService statusService;

    @POST
    @Path("salvar/checkpoint")
    public Response gravar(RequestDTO requestDTO) {
        this.statusService.salvar(requestDTO);
        return Response.ok().build();
    }

    @GET
    @Path("list/checkpoint")
    public Response checkpoint(@QueryParam("userId") String userId) {
        return Response.ok(this.statusService.carregarCheckpoint(userId)).build();
    }

    @GET
    @Path("find/checkpoint")
    public Response checkpointFind(@QueryParam("userId") String userId) {
        return Response.ok(this.statusService.carregarCheckpointAtual(userId)).build();
    }

}
