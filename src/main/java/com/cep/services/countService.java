/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cep.services;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPException;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esperio.AdapterInputSource;
import com.espertech.esperio.csv.CSVInputAdapter;
import com.events.MyEventClass;
import com.listeners.CEPListener6;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**
 *
 * @author anushka
 */
//count>>>> send the product name
@Path("/dataCount")
public class countService {

    @GET
    @Path("{dataCount}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String dataCount(@PathParam("dataCount") String dataCount) {
        String val = "'" + dataCount + "'";
        String userQuery = "select count(information) from MyEventClass where product=" + val;
        String userFileName = "MyInputFile.csv";
        String outdata = "";
//        final Log log = LogFactory.getLog(MyMainClass.class);
        //initializing the log4j
        SimpleLayout layout = new SimpleLayout();
        ConsoleAppender appender = new ConsoleAppender(new SimpleLayout());
        Logger.getRootLogger().addAppender(appender);
        Logger.getRootLogger().setLevel((Level) Level.WARN);

        MyEventClass MEC = new MyEventClass();

        //configuration
        Configuration configuration = new Configuration();
        configuration.addEventType(MEC.getClass());
        EPServiceProvider epService;
        epService = EPServiceProviderManager.getDefaultProvider(configuration);
        epService.initialize();

        //including the data stream to the eventclass
        AdapterInputSource source = new AdapterInputSource(userFileName);

        try {
            //registering the query with the CEP
            EPAdministrator cepAdm = epService.getEPAdministrator();
            EPStatement cepStatement2 = cepAdm.createEPL(userQuery);

            CEPListener6 listener = new CEPListener6();
            //connecting the listener
            cepStatement2.addListener(listener);

        } catch (Exception e) {
            System.out.println("Incorrect syntax in the statement " + e);
        }
        System.out.println("ehefjfhkjfhskfhsfksf");
        try {
            CSVInputAdapter inputAdapter = new CSVInputAdapter(epService, source, "MyEventClass");

            //starting the adapter
            inputAdapter.start();
        } catch (EPException e) {
            System.out.println("this is the pb" + e);
        }
        try {
            String content = new String(Files.readAllBytes(Paths.get("outputdata.txt")));
            outdata = content;
            System.out.println("" + outdata);
        } catch (Exception e) {
            System.out.println("could not read the file :" + e);
        }
        return outdata;
    }
}
