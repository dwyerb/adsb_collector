package net.muroc.adsb_collector.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.muroc.adsb_collector.domain.Product;
import net.muroc.adsb_collector.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService
{
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
