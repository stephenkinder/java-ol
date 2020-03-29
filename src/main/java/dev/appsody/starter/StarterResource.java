package dev.appsody.starter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.lang.System;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Path("/")
public class StarterResource {

    @Path("version")
    @GET
    public Response getVersion() {
         
    String libertyVersion="";
    try (InputStream input = new FileInputStream(System.getProperty("wlp.install.dir") + "/lib/versions/openliberty.properties")) {

        Properties prop = new Properties();

        // load a properties file
        prop.load(input);

        // get the property value and print it out
        libertyVersion=prop.getProperty("com.ibm.websphere.productVersion");

    } catch (IOException ex) {
        ex.printStackTrace();
    }

        return Response.ok("Hello, Sick World! Hosted by Open Liberty v("+libertyVersion+")")
                .build();
    }
}
