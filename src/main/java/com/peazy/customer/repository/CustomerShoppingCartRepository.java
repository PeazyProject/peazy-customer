package com.peazy.customer.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peazy.customer.model.entity.CustomerShoppingCartEntity;

@Repository
public interface CustomerShoppingCartRepository extends JpaRepository<CustomerShoppingCartEntity, Long> {

    public List<CustomerShoppingCartEntity> findByProductSeqNoAndColorSeqNoAndSizeSeqNoAndUserUUID(
        long productSeqNo, 
        long colorSeqNo,
        long sizeSeqNo,
        String userUUID);

}