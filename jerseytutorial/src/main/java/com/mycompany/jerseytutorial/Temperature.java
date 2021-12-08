/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 * 
 */
                                                                        
                                                                             // bledy , projekt sciagniety z klasy   
@Path("/Conventer")
public class Temperature {
    
      /*  Using PathParam like http://localhost:49000/api/Conventer/Celsius/77 */
     @GET
     @Path("/Celsius/{param}") 
     public Response sayTemperatureCtoF(@PathParam("param") int grades) {
                String output = grades + "C to F  =" + String.valueOf(grades*9/5+32) + "!";
                return Response.status(200).entity(output).build();
  }

     /* Using PathParam like http://localhost:49000/api/Converter/Fahrenheit/105 */
      @GET
      @Path("/Fahrenheit/{param}")
      public Response sayTemperatureFtoC(@PathParam("param") int grades) {
                 String output = grades + "F to C =" + String.valueOf((grades-32) *5/9) + "!";
                 return Response.status(200).entity(output).build();
      }
       
      /* Using QueryParam like http://localhost:49000/api/Converter?Celsius=67 */
      /* Using QueryParam like http://localhost:49000/api/Converter?Fahrenheit=4 */
    @GET
    public Response sayTemperature(@QueryParam("Celsius") int cgrades,
                                                            @QueryParam("Fahrenheit") int fgrades){
                 String output = "";
                 if (cgrades <0 || cgrades >0){
                     output = output+"  "+cgrades + "C to F =" + String.valueOf(cgrades*9/5+32) + "!";
                 }
                 else if ( fgrades <0 || fgrades >0){
                     output = output+"  "+fgrades + "F to C" + String.valueOf((fgrades-32)*5/9) + "!";
                 }
                 else
                     output = "Undefined conversion";
                 return Response.status(200).entity(output).build();
    }
        
}

