/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javax4u.camel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author vdoxx
 */
class FilePollingProcessor implements Processor {

    private String fileName;
    private String filePath;
    private int fileRowCount = 0;
    private List<String> lineList = null;
    private int numberOfLinesWritten = 0;

    @Override
    public void process(Exchange exchange) throws Exception {
  
   //Examinor: 1.Get a filepath and filename from the exchange.  
        //Rupesh: It's completed in below lines
                Map<String, Object> headers = exchange.getIn().getHeaders();
                Iterator iterator = headers.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry pair = (Map.Entry)iterator.next();
                    System.out.println(pair.getKey() + " == " + pair.getValue());
                }
                //below lines are output of above while loop
                //CamelFileAbsolute == true
                //CamelFileAbsolutePath == E:\Customer-large-file-size\apache_camel_file_polling\release\pickUpFolder\file-20210622t.csv
                //CamelFileLastModified == 1624325582498
                //CamelFileLength == 48
                //CamelFileName == file-20210622t.csv
                //CamelFileNameConsumed == file-20210622t.csv
                //CamelFileNameOnly == file-20210622t.csv
                //CamelFileParent == E:\Customer-large-file-size\apache_camel_file_polling\release\pickUpFolder
                //CamelFilePath == E:\Customer-large-file-size\apache_camel_file_polling\release\pickUpFolder\file-20210622t.csv
                //CamelFileRelativePath == file-20210622t.csv
      
    //Examinor: 2.Check to see if a file exists at the filepath/filename
             //Rupesh: There is no need to check file existance, because this method will be called only when file is there.
        //a.	If it exists, “process” the file using the steps from item 3 onwards
                  //Rupesh: below lines will give you content of file. You can put business validation here or do whatever you want.
                  // Get file body
                byte[] bytes = exchange.getIn().getBody(byte[].class);    
                int numberOfLines=0;
                for(int i = 0; i < bytes.length; i++) {
                    if (bytes[i] == '\n'){
                        numberOfLines++;
                    }
                    
                    System.out.print((char) bytes[i]);
                }
                 numberOfLines++;
        //b.	If it does not exist, throw an exception and log the error message
                 //Rupesh: There is no need to throw exception because camel will not call process method if file is not there
                 
    //Examinor: 3. If file exists, retrieve the number of lines and store in a variable
            //a.	If the number of lines is less than 5, write each line into a List<string>.  
            //b.	If the number of lines is greater than 5, write the first 5 lines into a List<string>.
            //Rupesh: numberOfLines will give you number of lines. 
    //Examinor: 4.Write the number of lines in the file and the number of lines written to the List<string> (from item 3 above) into the log:  examples “5 of 33 lines written to the list” or “3 of 3 lines written to the list”
            //Rupesh:
            System.out.println("\nNumber of lines in file : "+numberOfLines);
               
    }
    
}
