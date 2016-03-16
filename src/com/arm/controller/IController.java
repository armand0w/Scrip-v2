package com.arm.controller;

/**
 * Created by ACsatillo on 15/02/2016.
 */
public interface IController {

    boolean exist();

    String save();

    String delete();

    String getAll();

    String getById(String id);

    String update();

    void close();

}
