package com.peazy.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.peazy.customer.model.entity.ErrorCodeEntity;

public interface ErrorCodeRepository extends JpaRepository<ErrorCodeEntity, Long> {

	@Query(value = "  select SeqNo "
			+ "      ,Category "
			+ "      ,ErrorCode "
			+ "      ,ErrorMsg "
			+ "      ,Lang　from Common.ErrorCode "
			+ "	  where Category = :category and ErrorCode = :errorCode and lang='en-us' ",nativeQuery = true)
	public Optional<ErrorCodeEntity> findByCategoryAndErrorCode(@Param("category") String category,@Param("errorCode")  String code);


}