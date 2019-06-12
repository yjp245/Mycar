package cn.mycar.service.impl;

import cn.mycar.mapper.CategoryMapper;
import cn.mycar.pojo.Category;
import cn.mycar.service.CategoryService;
import cn.mycar.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public void add(Category category) {
        categoryMapper.add(category);
    }


    public void delete(int id) {
        categoryMapper.delete(id);
    }


    public void update(Category category) {
        categoryMapper.update(category);
    }


    public Category get(int id) {
        return categoryMapper.get(id);
    }


    public List<Category> list() {
        return categoryMapper.list();
    }


  /*  public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }*/


    public int count() {
        return categoryMapper.count();
    }
}
