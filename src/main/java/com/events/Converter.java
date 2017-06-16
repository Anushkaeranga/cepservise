package com.events;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anushka
 */
public class Converter {
    
 public void replacer(){
  Path path = Paths.get("C:\\Users\\anushka\\Documents\\NetBeansProjects\\FYPCEP\\src\\MyInputFile.csv");
Charset charset = StandardCharsets.UTF_8;
try{
String content = new String(Files.readAllBytes(path), charset);
content = content.replaceAll("=", " ");
content = content.replaceAll("-->", " ");
content = content.replaceAll("_", " ");
content = content.replaceAll(":", " ");

Files.write(path, content.getBytes(charset)); 
}
   
 
catch(Exception e){
    System.out.println(""+e);
}
}
}