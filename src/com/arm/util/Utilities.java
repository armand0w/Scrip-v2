package com.arm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ACsatillo on 16/02/2016.
 */

public class Utilities {

    public static final String path = "C:\\workspace\\MuseosCDMX\\web\\docs\\";

    public static void saveDocument(String doc, String id,  String name, String type){
        FileWriter fw = null;
        PrintWriter pw = null;
        name = id + "_-_" + name.toLowerCase().replaceAll(" ", "").replaceAll("\"", "").replaceAll("\\|", "")
                .replaceAll("á", "a").replaceAll("é", "e").replaceAll("í", "i").replaceAll("ó", "o").replaceAll("ú", "u")
                .replaceAll("\\.", "") + type;

        try{
            if( !new File( path+name ).exists() ) {
                fw = new FileWriter(path+name);
                pw = new PrintWriter(fw);
                pw.print(doc);
            }
        } catch ( IOException io){ System.err.println("Error al guardar archivo '" + name + "' = " + io.getLocalizedMessage()); }
        finally {
            try {
                if (pw != null) pw.close();
                if (fw != null) fw.close();
            } catch (IOException e){ System.err.println("Error al cerrar archivo"); }
        }
    }

    public static boolean existFile(String file){
        boolean exist = false;
        File f = null;
        try {
            f = new File(path);
            for (String sf : f.list()) {
                if( sf.split("_-_")[0].equals(file) ) {
                    exist = true;
                }
            }
        } catch(Exception ex){
            System.err.println("Error al buscar archivo = " + path+file );
        }

        return exist;
    }

    public static void main(String[] args){
        System.out.println( existFile("chij2rwv2dx_0yuraglenwie7-8") );
    }

}
