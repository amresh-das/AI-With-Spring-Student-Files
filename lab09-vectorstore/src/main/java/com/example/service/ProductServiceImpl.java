package com.example.service;

//  TDODO-08: Use a stereotype annotation to mark this service as a Spring bean.
//  Alter this class to implement the ProductService interface.

import com.example.dao.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    //  TDODO-09: Autowire a ProductDao instance.
    private final ProductDao productDao;

    public ProductServiceImpl(final ProductDao productDao) {
        this.productDao = productDao;
    }

    //  TDODO-10: Define a public void save() method.
    //  Define a single parameter of type List<String> containing product descriptions.
    //  Call the dao's add() method with the List<String> to save the product descriptions.
    @Override
    public void save(final List<String> products) {
        productDao.add(products);
    }

    //  TDODO-11: Define a public List<String> findClosestMatches() method.
    //  Define a single parameter of type String containing a query.
    //  Call the dao's findClosestMatches() method with the query and 5 as the number of matches.
    //  Return the resulting List<String>.
    @Override
    public List<String> findClosestMatches(final String query) {
        return productDao.findClosestMatches(query, 10);
    }


    //  TDODO-12: Define a public String findClosestMatch() method.
    //  Define a single parameter of type String containing a query.
    //  Call the dao's findClosestMatch() method with the query.
    //  Return the resulting String.
    @Override
    public String findClosestMatch(final String query) {
        return productDao.findClosestMatch(query);
    }


}
