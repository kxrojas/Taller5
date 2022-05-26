package co.edu.unbosque.wsresttutorial.resources;

import co.edu.unbosque.wsresttutorial.dtos.ExceptionMessage;
import co.edu.unbosque.wsresttutorial.dtos.NFT;
import co.edu.unbosque.wsresttutorial.dtos.User;
import co.edu.unbosque.wsresttutorial.services.NFTService;
import co.edu.unbosque.wsresttutorial.services.UserService;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/nfts")
public class NFTResource {

    @Context
    ServletContext context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        try {
            List<NFT> nfts = new NFTService().getNFTS();

            return Response.ok()
                    .entity(nfts)
                    .build();
        } catch (IOException e){
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(NFT nft) {
        String contextPath = context.getRealPath("") + File.separator;

        try {
            nft = new NFTService().createNFT(nft.getTitle(), nft.getFcoins(), nft.getImage_url(), contextPath);

            return Response.created(UriBuilder.fromResource(NFTResource.class).path(nft.getTitle()).build())
                    .entity(nft)
                    .build();
        } catch (IOException e){
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("title") String title) {

        try {
            List<NFT> listaNFT = new NFTService().getNFTS();

            NFT nft = listaNFT.stream()
                    .filter(u -> u.getTitle().equals(title))
                    .findFirst()
                    .orElse(null);

            if (nft != null){
                return Response.ok().entity(nft).build();
            }
            else {
                return Response.status(404)
                        .entity(new ExceptionMessage(404, "NFT not found"))
                        .build();
            }
        } catch (IOException e){
            return Response.serverError().build();
        }
    }







}
