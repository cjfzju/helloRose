package com.xiaonei.rose.cc.gettingStarted.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.InvocationLocal;
import net.paoding.rose.web.annotation.Ignored;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.portal.Portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

class TrackInterceptor extends ControllerInterceptorAdapter {
	@Override
	public Object before(Invocation inv) throws Exception
	{
		return true;
	}
}

//@Path("")
public class FirstController {
	@Autowired private InvocationLocal inv ;
	
	public String world() {
   //     inv.addModel("now", 12345678);
        return "world2";
    }
	public String cjf() {
        inv.addModel("p1", "this is p1");
        inv.addModel("p2", "this is p2");
        return "cjf2";
    }
	@Ignored
	public String getName() {
		return "hello-world";
	}

	///////////////////portal ////////////////////
	@Get("/pp")
	public String portal(Portal portal)throws Exception{
	    portal.addWindow("p1", "/world");
	    portal.addWindow("p2", "/wp2");
	    return "portal";
	}
	
	@Get("/wp1")
	public String portal1(){
	    return "@this is p1";
	}
	
	@Get("/wp2")
	public String portal2(){
        return "@this is p2";
    }
	////////////////////////////////////////
	
	@Post("upload")
	public String upload(@Param("file") MultipartFile file){
		return "@upload ok! file is -"+file.getOriginalFilename();
	}
	
    @Post("uploadMore")
    public String upload(MultipartFile[] files){
        return "@upload ok! files are-"+Arrays.toString(files);
    }
	
	
	@Get("list-by-group0-{groupId}")
    public String listByGroup0(@Param("groupId") int groupId) {
        return "@string8-${groupId}"+groupId;
    }
	
	@Get("a/list-by-group1-{name}")
    public String listByGroup1(Invocation inv, @Param("name") String name) {
		return "@method.name=" + name + "; request.param.name=" + inv.getRequest().getParameter("name");
    }
	
	public String listByGroup2(Invocation inv, @Param("name") String name) {
		return "@method.name=" + name + "; request.param.name=" + inv.getRequest().getParameter("name");
    }
	
	public String keyOfMap(@Param("map") Map<Integer, String> map) {
        return "@" + Arrays.toString(map.keySet().toArray(new Integer[0]));
    }
	
    public String testpost(){
        return "postform";
    }
    /*
	@Post
    public String post(Invocation inv) {
	    
         return "@" + inv.getRequest().getParameter("id") + "=" + inv.getRequest().getParameter("name");
    }*/
    
    @Post("user")
    public String post(User user) {
        
         return "@" + user.getId();
    }
} 

class User{
	private int id;
	private String name;
	
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	

}