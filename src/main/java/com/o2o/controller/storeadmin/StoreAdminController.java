package com.o2o.controller.storeadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "storeadmin", method = RequestMethod.GET)
public class StoreAdminController {

    @RequestMapping(value = "/storeoperation")
    public String storeOperation() {
        return "/store/storeoperation";
    }
}
