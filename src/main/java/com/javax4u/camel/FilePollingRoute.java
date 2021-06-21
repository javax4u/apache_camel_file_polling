package com.javax4u.camel;

import org.apache.camel.builder.RouteBuilder;

public class FilePollingRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("file:E:\\Customer-large-file-size\\apache_camel_file_polling\\release\\pickUpFolder?noop=true").to("file:E:\\Customer-large-file-size\\apache_camel_file_polling\\release\\processedFolder");

    }
}
