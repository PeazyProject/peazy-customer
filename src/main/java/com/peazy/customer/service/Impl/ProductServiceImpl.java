package com.peazy.customer.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.customer.model.bean.DropDownBean;
import com.peazy.customer.model.bean.QueryProductBean;
import com.peazy.customer.model.dto.GetProductByFilterDto;
import com.peazy.customer.model.dto.GetProductBySeqNoDto;
import com.peazy.customer.model.request.QueryProductRequest;
import com.peazy.customer.model.response.QueryProductResponse;
import com.peazy.customer.repository.SupplierProductRepository;
import com.peazy.customer.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SupplierProductRepository supplierProductRepository;

	@Override
	public QueryProductResponse queryCustomerProduct(QueryProductRequest queryProductRequest) throws JsonProcessingException {
		
		// 主要不能顯示目前的庫存狀況，要增加Size跟顏色的下拉選單
		if (CollectionUtils.isEmpty(queryProductRequest.getSkuList())) {
			queryProductRequest.setSkuList(null);
		}

		List<GetProductByFilterDto> supplierProductEntity = supplierProductRepository.queryProduct(
				queryProductRequest.getProductName(), queryProductRequest.getSkuList(),
				queryProductRequest.getIsAvailable());

		List<QueryProductBean> queryProductList = new ArrayList<>();
		for (GetProductByFilterDto getProductByFilterDto : supplierProductEntity) {
			QueryProductBean queryProductBean = new QueryProductBean();
			queryProductBean.setProductSeqNo(getProductByFilterDto.getProductSeqNo());
			queryProductBean.setProductName(getProductByFilterDto.getProductName());
			queryProductBean.setSnCode(getProductByFilterDto.getSnCode());
			queryProductBean.setPrice(getProductByFilterDto.getPrice());
			queryProductBean.setCategory(getProductByFilterDto.getCategory());
			queryProductBean.setSku(getProductByFilterDto.getSku());
			queryProductBean.setCreateDt(getProductByFilterDto.getCreateDt());
			
			// 先不要讓客戶看到商品是現貨還是需要預購
			// queryProductBean.setProductStatus(getProductByFilterDto.getProductStatus());
			queryProductBean.setColorList(getProductColorList(getProductByFilterDto.getProductSeqNo()));
			queryProductBean.setSizeList(getProductSizeList(getProductByFilterDto.getProductSeqNo()));

			queryProductList.add(queryProductBean);
		}

		QueryProductResponse queryProductResponse = new QueryProductResponse();
		queryProductResponse.setQueryProductList(queryProductList);
		return queryProductResponse;

	}

	private List<DropDownBean> getProductColorList(String productSeqNo) {
		List<GetProductBySeqNoDto> getProductBySeqNoDtoList = supplierProductRepository.queryProductBySeqNo(productSeqNo);
		List<DropDownBean> colorList = new ArrayList<>();
		for (GetProductBySeqNoDto getProductBySeqNoDto : getProductBySeqNoDtoList) {
			DropDownBean dropDownBean = new DropDownBean();
			dropDownBean.setLabel(getProductBySeqNoDto.getColor());
			dropDownBean.setValue(getProductBySeqNoDto.getColorSeqNo());
			colorList.add(dropDownBean);
		}
		colorList = colorList.stream().distinct().collect(Collectors.toList());
		return colorList;
	}

	private List<DropDownBean> getProductSizeList(String productSeqNo) {
		List<GetProductBySeqNoDto> getProductBySeqNoDtoList = supplierProductRepository.queryProductBySeqNo(productSeqNo);
		List<DropDownBean> sizeList = new ArrayList<>();
		for (GetProductBySeqNoDto getProductBySeqNoDto : getProductBySeqNoDtoList) {
			DropDownBean dropDownBean = new DropDownBean();
			dropDownBean.setLabel(getProductBySeqNoDto.getSize());
			dropDownBean.setValue(getProductBySeqNoDto.getSizeSeqNO());
			sizeList.add(dropDownBean);
		}
		sizeList = sizeList.stream().distinct().collect(Collectors.toList());
		return sizeList;
	}

	private boolean isProductInStock(List<String> inStockList, int productQty, String productStatus) {

		if (CollectionUtils.isEmpty(inStockList)) {
			return true;
		}

		if (inStockList.contains("Y")) {
			if (productQty > 0 && !StringUtils.equals(productStatus, "OUT_OF_STOCK")) {
				return true;
			}
		}

		if (inStockList.contains("N")) {
			if (productQty == 0) {
				return true;
			}
		}

		return false;
	}

}
