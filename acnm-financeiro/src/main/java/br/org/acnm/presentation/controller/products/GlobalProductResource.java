package br.org.acnm.presentation.controller.products;

import java.util.List;

import br.org.acnm.aplication.dto.products.CategoryResponseDTO;
import br.org.acnm.aplication.dto.products.GlobalProductRequestDTO;
import br.org.acnm.aplication.dto.products.GlobalProductResponseDTO;
import br.org.acnm.aplication.service.products.GlobalProductService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/global-products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GlobalProductResource {

    @Inject
    GlobalProductService globalProductService;

    @POST
    public Response create(@Valid GlobalProductRequestDTO request) {
        var responseDTO = globalProductService.create(request);
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }

    @GET
    public Response listAll() {
        List<GlobalProductResponseDTO> products = globalProductService.listAll();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        GlobalProductResponseDTO product = globalProductService.findById(id);
        return Response.ok(product).build();
    }

    @GET
    @Path("/category/{categoryId}/hierarchy")
    public Response findByCategoryHierarchy(@PathParam("categoryId") Integer categoryId) {
        List<GlobalProductResponseDTO> products = globalProductService.findByCategoryHierarchy(categoryId);
        return Response.ok(products).build();
    }
}