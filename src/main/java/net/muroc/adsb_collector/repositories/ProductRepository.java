package net.muroc.adsb_collector.repositories;

import org.springframework.data.repository.CrudRepository;
import net.muroc.adsb_collector.domain.Product;



public interface ProductRepository extends CrudRepository<Product, Integer>{
}
