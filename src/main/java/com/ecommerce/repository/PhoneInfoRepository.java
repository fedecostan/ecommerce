package com.ecommerce.repository;

import com.ecommerce.model.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneInfoRepository extends JpaRepository<PhoneInfo, Long> {

}
