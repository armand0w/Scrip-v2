package com.arm.controller;

import com.arm.model.Museum;
import com.arm.util.HSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.DataException;

public class MuseumControl implements IController {
    private Museum museo = null;
    private Session session = null;
    private Transaction transaction = null;

    public Museum getMuseo() { return museo; }
    public void setMuseo(Museum museo) { this.museo = museo; }

    public MuseumControl(){
        session = HSession.getSession();
        transaction = session.beginTransaction();
    }

    public MuseumControl(Museum m){
        this.museo = m;
        session = HSession.getSession();
        transaction = session.beginTransaction();
    }

    @Override
    public boolean exist() {
        boolean exist = false;
        Query q = session.createQuery("FROM Museum WHERE musPlaceId = :mus_id");
        q.setParameter("mus_id", this.museo.getMusPlaceId());
        if( q.list().size() > 0 ) exist = true;
        return exist;
    }

    @Override
    public String save() {
        String ret = "";
        if( !exist() ) {
            try {
                session.save(this.museo);
                if (!transaction.wasCommitted()) transaction.commit();
                ret = "{ \"mensaje\" : \""+this.museo.getMusName()+" guardado con exito\"}";
            } catch (DataException de){
                System.err.println("HSQL : " + de.getLocalizedMessage());
                System.err.println("Museo : " + this.museo.toString());
            }
        } else ret = "{ \"mensaje\" : \""+this.museo.getMusName()+" ya existe\"}";
        return ret;
    }

    @Override
    public String delete() {
        return null;
    }

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public String getById(String id) {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public void close() {
        session.close();
    }
}
