package pageElements;

public interface ProductPageElements {

	String btnProducts = "//a[@href='/products']";
	String hdrAllProducts = "//h2[normalize-space()='All Products']";
	String productCards = "//div[@class='features_items']//div[contains(@class,'product-image-wrapper')]";
	String btnViewProduct = "(//a[contains(@href, '/product_details/')])[1]";
	String txtSearch = "//input[@id='search_product']";
	String btnSearch = "//button[@id='submit_search']";
	String hdrSearchedProducts = "//h2[normalize-space()='Searched Products']";
	String lblProductName = "//div[@class='product-information']//h2";
	String lblCategoryText = "//div[@class='product-information']//p[1]";
	String lblAvailability = "//div[@class='product-information']//p[contains(normalize-space(),'Availability')]";
	String lblCondition = "//div[@class='product-information']//p[contains(normalize-space(),'Condition')]";
	String lblBrand = "//div[@class='product-information']//p[contains(normalize-space(),'Brand')]";
	String txtQuantity = "//input[@id='quantity']";
	String btnAddToCartDetail = "//button[normalize-space()='Add to cart']";
	String btnAddToCart = "//a[contains(@class,'add-to-cart')]";
	String btnViewCart = "//a[contains(@href,'/view_cart')]";
	String btnContinueShopping = "//button[contains(@class,'close-modal') and normalize-space()='Continue Shopping']";
	String recommendedSection = "//div[@id='recommended-item-carousel']";
	String btnRecommendedAddToCart = "//div[@id='recommended-item-carousel']//a[contains(@class,'add-to-cart')]";

}
