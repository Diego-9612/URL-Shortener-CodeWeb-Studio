package com.codeweb_studio.urlshortener;

import org.springframework.stereotype.Controller;

@Controller
public class RootController {

    public String index(){
        return "index";
    }
}
