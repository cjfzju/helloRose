package com.xiaonei.rose.tt.controllers.second;

import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Path;

import org.springframework.beans.factory.annotation.Autowired;

@Path("")
public class ThirdController {
	@Autowired private InvocationLocal inv ;
	
	public String world() {
   //     inv.addModel("now", 12345678);
        return "sworld1";
    }
	public String cjf() {
	    inv.addModel("now", 12345678);
        return "scjf1";
    }
} 

