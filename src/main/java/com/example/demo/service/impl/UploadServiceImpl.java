package com.example.demo.service.impl;

import com.example.demo.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    ServletContext app;
    @Override
    public File save(MultipartFile file, String folder) {
        File fo = new File(app.getRealPath("/assets/"+ folder) );
        if(!fo.exists()){
            fo.mkdirs();
        }
        String s = System.currentTimeMillis() + file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
        try {
            File save = new File(fo,name);
            file.transferTo(save);

            return save;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
