package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;

import javax.ejb.Local;
import java.io.IOException;

@Local
public interface AdminRepository {

    void save(Product product) throws IOException;

}
