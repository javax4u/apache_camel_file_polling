package com.javax4u.camel;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.jndi.JndiContext;

public class StartFilePollingServer {

    public static void main(String... args) {

        try {
            JndiContext jndiRegistry = new JndiContext();
            CamelContext camelContext = new DefaultCamelContext(jndiRegistry);
            camelContext.addRoutes(new FilePollingRoute());
            camelContext.start();
            while(true)
            {
                
            }
        } catch (Exception ex) {
            Logger.getLogger(StartFilePollingServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


  class FilePollingRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("file:E:\\Customer-large-file-size\\apache_camel_file_polling\\release\\pickUpFolder?noop=true&delete=true")
                .process(new FilePollingProcessor())
                .to("file:E:\\Customer-large-file-size\\apache_camel_file_polling\\release\\processedFolder");

    }
}
