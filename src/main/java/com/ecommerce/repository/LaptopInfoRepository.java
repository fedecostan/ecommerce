package com.ecommerce.repository;

import com.ecommerce.model.LaptopInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopInfoRepository extends JpaRepository<LaptopInfo, Long> {

}
