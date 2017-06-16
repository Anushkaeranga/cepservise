/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anushka
 */
public class CEPListener6 implements UpdateListener {

    String output = "";
    public EventBean[] newdata;
    public EventBean[] olddata;
    
    @Override
    public void update(EventBean[] newData, EventBean[] oldData) {
        
        
        Gson gson = new Gson();
        String json = gson.toJson(newData[0].getUnderlying());
        System.out.println(": "+json);
        output = json;
        try {
            Files.write(Paths.get("C:\\Users\\anushka\\Pictures\\jersey-service\\outputdata.txt"), output.getBytes());
        } catch (IOException ex) {
            System.out.println("could not write the file" + ex.toString());;
        }
    }
    
    public String answer(String val){
        val=output;
        return val;
    }
}
