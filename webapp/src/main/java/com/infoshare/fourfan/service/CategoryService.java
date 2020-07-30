package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ProductCategoryDao;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.dto.ProductCategoryDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class CategoryService {

    @EJB
    private ProductCategoryDao productCategoryDao;

    public List<ProductCategoryDto> getCategory(){
        return productCategoryDao.findAllDto();
    };

    public void saveNewCategory(String name)
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategory(name);
        productCategoryDao.save(productCategory);
    }

    @Transactional
    public void editCategory(Integer id, String name)
    {
        productCategoryDao.findById(id).ifPresent(productCategory -> {
            productCategory.setCategory(name);
        productCategoryDao.update(productCategory);
        });
    }

    @Transactional
    public void deleteCategory(Integer id)
    {
        productCategoryDao.findById(id).ifPresent(db_productCategory -> productCategoryDao.delete(db_productCategory));
    }

}
