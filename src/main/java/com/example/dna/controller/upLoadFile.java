package com.example.dna.controller;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

/**
 * @program: dna
 * @description:
 * @author: XL
 * @create: 2019-03-22 14:29
 **/

@Controller
public class upLoadFile {
    @RequestMapping("/index.html")
    public String f1(){
        return "index";
    }

    @RequestMapping("/form_fileupload.html")
    public String f2(){
        return "form_fileupload";
    }

    @RequestMapping("/upload")
    public String f3(HttpServletRequest request){
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if(isMultipart){

            ServletFileUpload upload = new ServletFileUpload();

            upload.setHeaderEncoding("UTF-8");

            int i = 0;


            try {

                FileItemIterator iter = upload.getItemIterator(request);


                while(iter.hasNext()){

                    i++;

                    FileItemStream fi = iter.next();

                    InputStream in = null;

                    OutputStream fileout = null;

                    try {

                        String fileName = fi.getName();

                        File file = new File("/data/"+ fileName);

                        in = fi.openStream();

                        ByteArrayOutputStream bstream = new ByteArrayOutputStream();

                        Streams.copy(in, bstream, true);

                        fileout = new FileOutputStream(file);

                        bstream.writeTo(fileout);

                    } catch (IOException e) {
                        e.printStackTrace();

                    }finally{

                        if(in != null){

                            try {

                                in.close();

                            } catch (IOException e) {

                                e.printStackTrace();

                            }

                        }

                        if(fileout != null){

                            try {

                                fileout.close();

                            } catch (IOException e) {

                                e.printStackTrace();

                            }

                        }

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return "form_fileupload.html";
    }

}
