/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.google.gson.Gson;

/**
 *
 * @author anushka
 */
        public  class CEPListener5 implements UpdateListener {
            
            String output ="";
        @Override
        public void update(EventBean[] newData, EventBean[] oldData) {
     
            Gson gson = new Gson();
            String json = gson.toJson(newData[0].getUnderlying()); 
            if(!"".equals(json)){
            System.out.println("filtered by statement 2!!"+json);
            output=json;
            }
            else{
                System.out.println("no data");
            }
           
            //System.out.println("Event filtered by ESPER engine statement2 " + newData[0].getUnderlying());
        }

        public String returnJsonOut(){
                return output;
            
        }
    }