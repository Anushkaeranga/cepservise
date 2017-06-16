package com.cep.services;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPException;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esperio.AdapterInputSource;
import com.espertech.esperio.csv.CSVInputAdapter;
import com.events.*;
import com.listeners.*;
import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import com.main.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.json.JSONObject;

/*
 * @author anushka
 */
//gives max,min,avg values, total count of values
@Path("/CEPServices")
public class cepServices {

    // @Produces(MediaType.APPLICATION_JSON)
    // public String dataCount( MyEventClass mc[]) {
    // for(MyEventClass m:mc){
    // m.get
    @POST
    @Path("/getData")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void getData(MyEventClass mc[]) {
        for (MyEventClass m : mc) {
            m.getDate();
            m.getInformation();
            m.getPrice();
            m.getTime();
        }
    }

    @POST
    @Path("/minPrice")
    @Consumes(MediaType.APPLICATION_JSON)
    public String minPrice() {
        String userQuery = "select min(price) from MyEventClass";
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

    @POST
    @Path("/maxPrice")
    @Consumes(MediaType.APPLICATION_JSON)
    public String maxPrice() {
        String userQuery = "select max(price) from MyEventClass";
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

    @POST
    @Path("/avgPrice")
    @Consumes(MediaType.APPLICATION_JSON)
    public String avgPrice() {
        String userQuery = "select avg(price) from MyEventClass";
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

    @POST
    @Path("/count")
    @Consumes(MediaType.APPLICATION_JSON)
    public String count() throws URISyntaxException {
        String userQuery = "select count(price) from MyEventClass";
        String resource = "MyInputFile.csv";
        String outdata = "";

//        final Log log = LogFactory.getLog(MyMainClass.class);
//        //initializing the log4j
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
        AdapterInputSource source = new AdapterInputSource(resource);

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
        try {
            CSVInputAdapter inputAdapter = new CSVInputAdapter(epService, source, "MyEventClass");

//        //starting the adapter
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

//    @GET
//    @Path("/filteredData1")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void filteredData1() {
//
//        String result = "Track saved : " + "hfjfjfhjfhj";
//
//    }
    //    public static String userQuery = "select date from MyEventClass";
//    public static String userFileName = "MyInputFIle.csv";
    //MyMainClass MMC = new MyMainClass();
//    @GET
//    @Path("/getQuery/{query}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String getQuery(@PathParam("query") String query) {
//       String userQuery = query;
//        System.out.println("fgfgfg"+userQuery);
//        return userQuery;
//    }
//    @GET
//    @Path("/value")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String value() {
//        // MMC.assign(userQuery, userFileName);
//        return "";
//    }
//    @GET
//    @Path("/engine")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void getFile() {
//    }
}
