package demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.ProductInfo;
import demo.repository.ProductInfoRepository;

@Service
public class ProductInfoService {

	@Autowired
	ProductInfoRepository productInfoRepositroy;

	@Autowired
	public ProductInfoService(ProductInfoRepository productInfoRepository) {
		this.productInfoRepositroy = productInfoRepository;
	}

	/**
	 * 商品情報を更新する
	 * @param productInfo
	 * @return productInfo
	 */
	public ProductInfo saveProductInfo(ProductInfo productInfo) {
		return productInfoRepositroy.save(productInfo);
	}

	/**
	 * 商品情報を全件取得する
	 * @return productInfoリスト
	 */
	public List<ProductInfo> findAllProductInfo() {
		return productInfoRepositroy.findAll();
	}

	/**
	 * 指定したidの商品情報を取得する
	 * @param id
	 * @return productInfo
	 */
	public Optional<ProductInfo> findProductInfoById(Integer productId) {
		return productInfoRepositroy.findById(productId);
	}

	/**
	 * 商品情報を削除する
	 * @param productInfo
	 * @return productInfo
	 */
	public void deleteProductInfo(Integer productId) {
		productInfoRepositroy.deleteById(productId);
	}

}