package service;

import model.Tree;
import model.User;

import java.util.List;
import java.util.Map;

public interface TreeService {
    User den(User u);

    List<Tree> shu(Integer id);

    Map yong(Integer page,Integer rows);

    Map jiao(Integer page, Integer rows);

    Map quan(Integer page, Integer rows);

    Map xian(Integer page, Integer rows);

    Map hu(Integer page, Integer rows);
}
