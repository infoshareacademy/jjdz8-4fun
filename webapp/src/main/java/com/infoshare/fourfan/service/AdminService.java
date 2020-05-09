package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.repository.AdminRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;

@RequestScoped
public class AdminService {

    @EJB
    private AdminRepository adminRepository;

    public void save(Product product) throws IOException { adminRepository.save(product);}

}
