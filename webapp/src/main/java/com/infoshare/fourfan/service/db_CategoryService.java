package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.dto.db_ProductCategoryDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class db_CategoryService {

    @EJB
    private db_ProductCategoryDao db_productCategoryDao;

    public List<db_ProductCategoryDto> getCategory(){
        return db_productCategoryDao.findAllDto();
    };

    public void saveNewCategory(String name)
    {
        db_ProductCategory db_productCategory = new db_ProductCategory();
        db_productCategory.setCategory(name);
        db_productCategoryDao.save(db_productCategory);
    }

    @Transactional
    public void editCategory(Integer id, String name)
    {
        db_productCategoryDao.findById(id).ifPresent(productCategory -> {
            productCategory.setCategory(name);
        db_productCategoryDao.update(productCategory);
        });
    }

    @Transactional
    public void deleteCategory(Integer id)
    {
        db_productCategoryDao.findById(id).ifPresent(db_productCategory -> db_productCategoryDao.delete(db_productCategory));
    }

}
