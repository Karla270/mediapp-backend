package com.mitocode.service.impl;

import com.mitocode.model.Menu;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.repository.IMenuRepository;
import com.mitocode.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService {

    @Autowired
    private IMenuRepository repo;

    @Override
    protected IGenericRepository<Menu, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Menu> getMenusByUsername(String username) {
        //String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return repo.getMenusByUsername(username);
    }


}
