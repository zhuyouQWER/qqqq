package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.util.TreeNoteUtil;
import model.Tree;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TreeService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("tree")
public class TreeController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Reference
    private TreeService treeService;
    @RequestMapping("den1")
    public String den1(){

        return "den";
    }
    @RequestMapping("den")
    @ResponseBody
    private String den(User u,HttpServletRequest request) {
        User us = treeService.den(u);
        if (us == null) {
           return "cuo";
        }
        request.getSession().setAttribute("user",us);
        return "dui";
    }
    @RequestMapping("shu1")
    public String shu1(){
        return  "shu";

    }
 @RequestMapping("shu")
    @ResponseBody
    public List<Tree> shu(HttpServletRequest request){
     User user = (User) request.getSession().getAttribute("user");
        List<Tree> list=new ArrayList<Tree>();
        String key="d";
        if (redisTemplate.hasKey(key)){
            System.out.println("======走缓存========");
            list= (List<Tree>) redisTemplate.opsForValue().get(key);
        }else{
            System.out.println("======走数据库========");
            list=treeService.shu(user.getId());
            list=TreeNoteUtil.getFatherNode(list);
            redisTemplate.opsForValue().set(key,list);
            redisTemplate.expire(key,30, TimeUnit.MINUTES);
        }

   return list;
 }
 @RequestMapping("yong1")
 public String yong1(){

        return "yong";
 }
 @RequestMapping("yong")
    @ResponseBody
    public Map yong(Integer page,Integer rows){

    return  treeService.yong(page,rows);
 }
  @RequestMapping("jiao")
    @ResponseBody
    public Map jiao(Integer page,Integer rows){
        return treeService.jiao(page,rows);
  }
    @RequestMapping("jiao1")
    public String jiao1(){

        return "jiao";
    }
    @RequestMapping("quan")
    @ResponseBody
    public Map quan(Integer page,Integer rows){
        return treeService.quan(page,rows);
    }
    @RequestMapping("quan1")
    public String quan1(){

        return "quan";
    }
    @RequestMapping("xian")
    @ResponseBody
    public Map xian(Integer page,Integer rows){
        return treeService.xian(page,rows);
    }
    @RequestMapping("xian1")
    public String xian1(){

        return "xian";
    }
    @RequestMapping("hu")
    @ResponseBody
    public Map hu(Integer page,Integer rows){
        return treeService.hu(page,rows);
    }
    @RequestMapping("hu1")
    public String hu1(){

        return "hu";
    }

}
