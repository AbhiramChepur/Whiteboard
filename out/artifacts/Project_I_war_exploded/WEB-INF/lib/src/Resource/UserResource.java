package Resource;

import Dao.UserDao;
import Rest.UserRO;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

@Path("Users")
public class UserResource  {

    @Autowired
    private UserService userService;


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserRO userRO, @Context HttpServletRequest request){

        //@Huh - Shouldn't do in this way [Change in the next tag] - BUG
        HttpSession session = request.getSession();
        session.setAttribute("username",userRO.getUsername());
        return Response.ok(userService.evaluateUser(userRO)).build();
    }


    @POST
    @Path("/Signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(UserRO userRO){
        return Response.ok(userService.syncUser(userRO)).build();
    }

}
