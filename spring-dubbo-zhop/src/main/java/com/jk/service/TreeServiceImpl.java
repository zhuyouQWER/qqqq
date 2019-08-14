package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.TreeDao;
import model.*;

import org.springframework.beans.factory.annotation.Autowired;
import service.TreeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreeServiceImpl implements TreeService {
  @Autowired
    private TreeDao da;

    @Override
    public User den(User u) {
        return da.den(u);
    }

  @Override
  public List<Tree> shu(Integer id) {
    return da.shu(id);
  }

  @Override
  public Map yong(Integer page,Integer rows) {
      Integer count=da.zong();
      Integer start=(page-1)*rows;
      List<User> list=da.yong(start,rows);
      Map ma=new HashMap();
      ma.put("rows",list);
      ma.put("total",rows);
     return ma;
  }

  @Override
  public Map jiao(Integer page, Integer rows) {
    Integer count=da.jzong();
    Integer start=(page-1)*rows;
    List<Jiao> list=da.jyong(start,rows);
    Map ma=new HashMap();
    ma.put("rows",list);
    ma.put("total",rows);
    return ma;
  }

  @Override
  public Map quan(Integer page, Integer rows) {
    Integer count=da.qzong();
    Integer start=(page-1)*rows;
    List<Jq> list=da.qyong(start,rows);
    Map ma=new HashMap();
    ma.put("rows",list);
    ma.put("total",rows);
    return ma;

  }

  @Override
  public Map xian(Integer page, Integer rows) {
    Integer count=da.xzong();
    Integer start=(page-1)*rows;
    List<Tree> list=da.xyong(start,rows);
    Map ma=new HashMap();
    ma.put("rows",list);
    ma.put("total",rows);
    return ma;

  }

  @Override
  public Map hu(Integer page, Integer rows) {
    Integer count=da.hzong();
    Integer start=(page-1)*rows;
    List<Uj> list=da.hyong(start,rows);
    Map ma=new HashMap();
    ma.put("rows",list);
    ma.put("total",rows);
    return ma;

  }
}
