package com.newsweaver.demo.colorservice.resources;

import com.newsweaver.demo.colorservice.model.Color;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
public class ColorResource {

    private final Color color;

    public ColorResource(Color color) {
        this.color = color;
    }

    @GET
    @Path("color")
    public Color color() {
        return color;
    }

}
