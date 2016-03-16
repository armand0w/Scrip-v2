package com.arm.webservice;

import com.arm.model.Location;
import com.arm.model.Museo;
import com.arm.model.Museum;
import com.arm.util.HSession;
import com.google.gson.Gson;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

/**
 * Lista todos los museos en BD
 */
@Path("/museos")
public class MuseosInfo {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {

        LinkedList<Museo> listMuseos = new LinkedList<>();
        Session session = null;
        String ret = "";
        try {
            session = HSession.getSession();
            SQLQuery q = session.createSQLQuery("SELECT {m.*}, {l.*} FROM museum m JOIN location l ON m.Mus_Place_Id = l.Ubn_Mus_Place_Id")
                    .addEntity("m", Museum.class)
                    .addJoin("l", "m.location");
            List<Object[]> rows = q.list();
            for (Object[] row : rows) {
                listMuseos.add(new Museo((Museum) row[0], (Location) row[1]));
            }

            ret = new Gson().toJson(listMuseos);
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if (session!=null) session.close();
        }

        return ret;
    }

}
