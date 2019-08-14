package com.jk.dao;

import model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreeDao {

    User den(User u);

    List<Tree> shu(Integer id);

    Integer zong();

    List<User> yong(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer jzong();

    List<Jiao> jyong(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer qzong();

    List<Jq> qyong(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer xzong();

    List<Tree> xyong(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer hzong();

    List<Uj> hyong(@Param("start") Integer start, @Param("rows") Integer rows);
}
