package com.ecommerce.repository;

import com.ecommerce.model.TvInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvInfoRepository extends JpaRepository<TvInfo, Long> {

}
