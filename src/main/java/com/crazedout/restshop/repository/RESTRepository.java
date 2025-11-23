package com.crazedout.restshop.repository;


import com.crazedout.restshop.model.ShopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RESTRepository extends JpaRepository<ShopModel, Long> {

}
