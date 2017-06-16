package com.ahem;

/**
 *
 * @author anushka
 */
import com.listeners.CEPListener3;
import com.listeners.CEPListener5;
import com.listeners.CEPListener4;
import com.listeners.CEPListener6;
import com.events.MyEventClass;
import com.listeners.CEPListener2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
/*
import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.bean.BeanEventBean;

//import MyEventClass;
import com.espertech.esperio.AdapterInputSource;
import com.espertech.esperio.csv.CSVInputAdapter;
import com.events.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyMainClass {

    private static final Log log = LogFactory.getLog(MyMainClass.class);
    public String csvfileName="MyInputFIle.csv";
    public String eplStatement="select date from MyEventClass";
    //public AdapterInputSource source1;

    public void assign(String name1, String name2) {
        csvfileName = name1;
        csvfileName = name2;

    }
    public static void main(String[] args) {
        MyMainClass x= new MyMainClass();
        x.run();
    }
    public String run() {

        //initializing the log4j
        SimpleLayout layout = new SimpleLayout();
        ConsoleAppender appender = new ConsoleAppender(new SimpleLayout());
        Logger.getRootLogger().addAppender(appender);
        Logger.getRootLogger().setLevel((Level) Level.WARN);

        // int loopsize = 0;
        //Scanner sc = new Scanner(System.in);
        //configuration
        Configuration configuration = new Configuration();
        configuration.addEventType(MyEventClass.class);
        EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(configuration);
        epService.initialize();

        //while (loopsize < 100) {
        //System.out.println("Enter the query");
        //eplStatement = sc.nextLine();
/*
            try {
                String content = new String(Files.readAllBytes(Paths.get("query.txt")));
                System.out.println("sssfs" + content);
                eplStatement = content;
            } catch (IOException ex) {
                System.out.println("no such query...");
            }
         */
        //including the data stream to the eventclass



/*
        AdapterInputSource source = new AdapterInputSource(csvfileName);

        try {
            //registering the query with the CEP
            EPAdministrator cepAdm = epService.getEPAdministrator();
            EPStatement cepStatement2 = cepAdm.createEPL(eplStatement);

            //connecting the listener
            cepStatement2.addListener(new CEPListener6());
        } catch (Exception e) {
            System.out.println("Incorrect syntax in the statement " + e);
        }
        //starting the adapter
        (new CSVInputAdapter(epService, source, "MyEventClass")).start();
        return csvfileName +""+eplStatement;
    }
    //}
}
*/