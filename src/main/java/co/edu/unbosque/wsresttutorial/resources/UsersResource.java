package co.edu.unbosque.wsresttutorial.resources;

import co.edu.unbosque.wsresttutorial.dtos.ExceptionMessage;
import co.edu.unbosque.wsresttutorial.dtos.User;
import co.edu.unbosque.wsresttutorial.services.UsersService;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context ;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Path("/users")
public class UsersResource {
    @Context
    ServletContext context;

    //Credenciales BD
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/TiendaVale";
    static final String USER = "postgres";
    static final String PASS = "0987";

    @GET
    @Produces("application/json")
    public Response listUsers() {
        Connection conn = null;
        List<User> users = null;

        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            UsersService usersService = new UsersService(conn);

            users = usersService.listUsers();


            conn.close();
        } catch (SQLException se) {
            se.printStackTrace(); //
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return Response.ok().entity(users).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response get(@PathParam("password") String password) {
        Connection conn = null;
        User user = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            new UsersService(conn);
            List<User> users = User;
            user = users.stream().filter(u -> u.getPassword().equals(password)).findFirst().orElse(null);

            conn.close();
        } catch (IOException e) {
            return Response.serverError().build();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return Response.ok().entity(user).build();
    }
}