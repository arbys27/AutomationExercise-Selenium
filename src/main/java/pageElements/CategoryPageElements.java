package pageElements;

public interface CategoryPageElements {

	String lnkWomenCategory = "//a[@href='#Women']";
	String lnkMenCategory = "//a[@href='#Men']";
	String lnkWomenDress = "//div[@id='Women']//a[contains(@href,'/category_products/')]";
	String lnkMenJeans = "//div[@id='Men']//a[contains(@href,'/category_products/')]";
	String hdrCategoryProducts = "//h2[contains(normalize-space(),'Products')]";
	String lnkBrands = "//div[@class='brands-name']//ul//li//a";
	String hdrBrandProducts = "//h2[contains(normalize-space(),'Brand Products')]";

}
