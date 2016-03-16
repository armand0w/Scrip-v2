package com.arm.controller;

import com.arm.model.Location;
import com.arm.util.HSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.DataException;

/**
 * Created by ACsatillo on 15/02/2016.
 */
public class DirecControl implements IController {
    private Location direccion = null;
    private Session session = null;
    private Transaction transaction = null;

    public Location getDireccion() { return direccion; }
    public void setDireccion(Location direccion) { this.direccion = direccion; }

    public DirecControl(){
        session = HSession.getSession();
        transaction = session.beginTransaction();
    }

    public  DirecControl(Location d){
        this.direccion = d;
        session = HSession.getSession();
        transaction = session.beginTransaction();
    }

    @Override
    public boolean exist() {
        boolean exist = false;
        Query q = session.createQuery("FROM Location WHERE ubnMusPlaceId = :ubn_mus_id");
        q.setParameter("ubn_mus_id", this.direccion.getUbnMusPlaceId());
        if( q.list().size() > 0 ) exist = true;
        return exist;
    }

    @Override
    public String save() {
        String ret = "";
        if( !exist() ) {
            try {
                session.save(this.direccion);
                if (!transaction.wasCommitted()) transaction.commit();
                ret = "{ \"mensaje\" : \"" + this.direccion.getUbnMusPlaceId() + " guardado con exito\"}";
            } catch (DataException de){
                System.err.println("HSQL : " + de.getLocalizedMessage());
                System.err.println("Direccion : " + this.direccion.toString());
            }
        } else ret = "{ \"mensaje\" : \""+this.direccion.getUbnMusPlaceId() +" ya existe\"}";
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
