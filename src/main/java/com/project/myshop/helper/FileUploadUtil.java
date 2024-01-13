package com.project.myshop.helper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileUploadUtil {
    
    public static boolean uploadImage(Part part,ServletContext context){
        
        boolean isImageUploaded = false;
        try{
            
            String releativePath = File.separator + "images" + File.separator + "products";
            String absolutePath = context.getRealPath(releativePath);

            File directory = new File(absolutePath);

            if (!directory.exists()) {
                directory.mkdir();
            }

            String imagePath = absolutePath + File.separator + part.getSubmittedFileName();
            FileOutputStream oStream = new FileOutputStream(imagePath);
            InputStream iStream = part.getInputStream();
            byte[] buffer = new byte[(int)part.getSize()];
            iStream.read(buffer);
            oStream.write(buffer);
            oStream.flush();
            oStream.close();
            isImageUploaded = true;
            
        }
        catch(FileNotFoundException exp){
            System.err.println(exp.getMessage());
        }
        catch(IOException exp){
            System.err.println(exp.getClass() + " " + exp.getMessage());
        }
        
        return  isImageUploaded;
    }
}
