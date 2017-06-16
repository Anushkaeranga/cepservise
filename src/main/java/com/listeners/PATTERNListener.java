/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.events.MyEventClass;
import com.google.gson.Gson;
/**
 *
 * @author anushka
 */
public class PATTERNListener implements UpdateListener{
    
    
	public void update(EventBean[] newData, EventBean[] oldEvents)
	{
		MyEventClass spike = (MyEventClass) newData[0].get("spike");
		MyEventClass error = (MyEventClass) newData[0].get("error");
		 // either spike or error can be null, depending on which occured
	 // add more logic here
         System.out.println("Event filtered by pattern matching " + newData[0].getUnderlying());
    
	}
                
}
        /*
       public  class CEPListener6 implements UpdateListener {

        @Override
        public void update(EventBean[] newData, EventBean[] oldData) {
            System.out.println("Event filtered by ESPER engine statement3 " + newData[0].getUnderlying());
        }

    }
*/