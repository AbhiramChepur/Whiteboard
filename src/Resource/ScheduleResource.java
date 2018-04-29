package Resource;

import Dao.ScheduleDao;
import Rest.ClassesRO;
import Rest.ScheduleRO;
import Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Path("/Schedule")
public class ScheduleResource {

    @Autowired
    private ScheduleService scheduleService;

    @POST
    @Path("/AddSchedule")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response AddSchedule(ScheduleRO scheduleRO){
        return Response.ok(scheduleService.syncSchedule(scheduleRO)).build();
    }

    @PUT
    @Path("/UpdateSchedule")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response UpdateSchedule(ScheduleRO scheduleRO){
        return Response.ok(scheduleService.modifySchedule(scheduleRO)).build();
    }


    @DELETE
    @Path("/DeleteSchedule/{Scheduleid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteSchedule(@PathParam("Scheduleid") String Scheduleid){
        return Response.ok(scheduleService.removeSchedule(Scheduleid)).build();
    }



}
