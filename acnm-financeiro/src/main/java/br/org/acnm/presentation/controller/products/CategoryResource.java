package br.org.acnm.presentation.controller.products;

import java.util.List;

import br.org.acnm.aplication.dto.products.CategoryRequestDTO;
import br.org.acnm.aplication.dto.products.CategoryResponseDTO;
import br.org.acnm.aplication.service.products.CategoryService;
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

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @POST
    public Response create(@Valid CategoryRequestDTO request) {
        var responseDTO = categoryService.create(request);
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }

    @GET
    public Response listAll() {
        List<CategoryResponseDTO> categories = categoryService.listAll();
        return Response.ok(categories).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) { 
        CategoryResponseDTO category = categoryService.findById(id);
        return Response.ok(category).build();
    }
}