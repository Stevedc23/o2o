package com.o2o.controller.storeadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.StoreExecution;
import com.o2o.entity.Store;
import com.o2o.entity.UserInfo;
import com.o2o.enums.StoreStateEnum;
import com.o2o.exceptions.StoreOperationException;
import com.o2o.service.StoreService;
import com.o2o.util.HttpServletRequestUtil;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/storeadmin")
public class StoreManagementController {

//    private static void inputStreamToFile(InputStream inputStream, File file) {
//        FileOutputStream os = null;
//        try {
//            os = new FileOutputStream(file);
//            int bytesRead = 0;
//            byte[] buffer = new byte[1024];
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                os.write(buffer, 0, bytesRead);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("inputStreamToFile calls exception: " + e.getMessage());
//        } finally {
//            try {
//                if(os != null) {
//                    os.close();
//                }
//                if(inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException("inputStreamToFile close IO calls exception: " + e.getMessage());
//            }
//        }
//    }

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/registerstore", method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerStore(HttpServletRequest request) {

        Map<String, Object> modelMap = new HashMap<String, Object>();

        //Receive and convert store and image info
        String storeStr = HttpServletRequestUtil.getString(request, "storeStr");
        ObjectMapper mapper = new ObjectMapper();
        Store store = null;

        try {
            store = mapper.readValue(storeStr, Store.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }

        CommonsMultipartFile storeImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if(commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            storeImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("storeImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "Upload image file cannot be empty");
            return modelMap;
        }

        // store registration
        if(store != null && storeImg != null) {

            //Session TODO
            UserInfo owner = new UserInfo();
            owner.setUserId(1L);
            store.setOwner(owner);
//            File storeImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
//            try {
//                storeImgFile.createNewFile();
//            } catch (IOException e) {
//                modelMap.put("success", false);
//                modelMap.put("errMsg", e.getMessage());
//                return modelMap;
//            }
//            try {
//                inputStreamToFile(storeImg.getInputStream(), storeImgFile);
//            } catch (IOException e) {
//                modelMap.put("success", false);
//                modelMap.put("errMsg", e.getMessage());
//                return modelMap;
//            }
            StoreExecution se = null;
            try {
                se = storeService.addStore(store, storeImg.getInputStream(), storeImg.getOriginalFilename());
                if(se.getState() == StoreStateEnum.CHECK.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", se.getStateInfo());
                }
            } catch (StoreOperationException e){
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            }
//            if(se.getState() == StoreStateEnum.CHECK.getState()) {
//                modelMap.put("success", true);
//            } else {
//                modelMap.put("success", false);
//                modelMap.put("errMsg", se.getStateInfo());
//            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "Please enter store information");
            return modelMap;
        }

    }
}
