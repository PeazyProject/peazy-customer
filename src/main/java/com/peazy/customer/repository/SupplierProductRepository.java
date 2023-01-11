package com.peazy.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.peazy.customer.model.dto.GetProductByFilterDto;
import com.peazy.customer.model.dto.GetProductBySeqNoDto;
import com.peazy.customer.model.entity.SupplierProductEntity;

@Repository
public interface SupplierProductRepository extends JpaRepository<SupplierProductEntity, Long> {

    @Query(value = "SELECT DISTINCT "
            + "     supplier_product_view.ProductSeqNo, "
            + "     supplier_product_view.ProductName,  "
            + "     supplier_product_view.SnCode, "
            + "     supplier_product_view.Price, "
            + "     supplier_product_view.Category, "
            + "     supplier_product_view.Sku, "
            + "     supplier_product_view.CreateDt, "
            + "     supplier_product_view.ProductStatus, "
            + "     SUM(supplier_product_view.OrderedCnt) as ProductOrderedCnt "
            + " FROM supplier_product_view "
            + " WHERE 1 = 1 "
            + " AND (supplier_product_view.ProductName LIKE CONCAT('%' ,:productName ,'%') or NULLIF(:productName, '') is null) "
            + " AND (COALESCE(:skuList, NULL) IS NULL OR (supplier_product_view.Sku IN (:skuList))) "
            + " AND (supplier_product_view.ProductStatus = :isAvailable or NULLIF(:isAvailable, '') is null or :isAvailable = 'ALL') "
            + " GROUP BY "
            + " supplier_product_view.ProductSeqNo, "
            + " supplier_product_view.ProductName, "
            + " supplier_product_view.SnCode, "
            + " supplier_product_view.Price, "
            + " supplier_product_view.Category, "
            + " supplier_product_view.Sku, "
            + " supplier_product_view.CreateDt, "
            + " supplier_product_view.ProductStatus "
            + " ORDER BY supplier_product_view.CreateDt ", nativeQuery = true)
    public List<GetProductByFilterDto> queryProduct(
            @Param("productName") String productName,
            @Param("skuList") List<String> skuList,
            @Param("isAvailable") String isAvailable);

        @Query(value = "SELECT DISTINCT "
            + "     supplier_product_view.ProductSeqNo, "
            + "     supplier_product_view.ProductName,  "
            + "     supplier_product_view.SnCode, "
            + "     supplier_product_view.Price, "
            + "     supplier_product_view.Cost, "
            + "     supplier_product_view.CategorySeqNo, "
            + "     supplier_product_view.Mpn, "
            + "     supplier_product_view.Sku, "
            + "     supplier_product_view.ProductDesc, "
            + "     supplier_product_view.CreateDt, "
            + "     supplier_product_view.ProductStatus, "
            + "     supplier_product_view.VendorSeqNo, "
            + "     supplier_product_view.ColorSeqNo, "
            + "     supplier_product_view.Color, "
            + "     supplier_product_view.SizeSeqNo, "
            + "     supplier_product_view.Size "
            + " FROM supplier_product_view "
            + " WHERE 1 = 1 "
            + " AND supplier_product_view.ProductSeqNo = :productSeqNo"
            + " ORDER BY supplier_product_view.CreateDt ", nativeQuery = true)
    public List<GetProductBySeqNoDto> queryProductBySeqNo(@Param("productSeqNo") String productSeqNo);

}