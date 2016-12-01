package com.example.services;

import com.example.dao.BookDao;
import com.example.daoImpl.BookDaoImpl;
import com.example.modle.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * Created by Malitha on 6/22/2016.
 */

@Path("/bookServices")
public class bookServices {

    @GET
    @Path("/getBook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("id") String id) {
        BookDao dao = new BookDaoImpl();
        return (dao.getBookS(id));
    }

    @GET
    @Path("/getallBook")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllBook() {
        BookDao dao = new BookDaoImpl();

        if (dao.getAllBookS()==null) {
            return Response.ok("null").status(404).build();

        } else {
            return Response.ok(dao.getAllBookS()).status(200).build();
        }


    }

}
