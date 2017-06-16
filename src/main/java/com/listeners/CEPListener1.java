/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 *
 * @author anushka
 */
        public  class CEPListener1 implements UpdateListener {

        @Override
        public void update(EventBean[] newData, EventBean[] oldData) {
            System.out.println("Event filtered by ESPER engine statement1 " + newData[0].getUnderlying());
        }

    }
