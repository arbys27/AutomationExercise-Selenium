package pageElements;

public interface CartPageElements {

	String lblShoppingCart = "//li[normalize-space()='Shopping Cart']";
	String cartRows = "//tr[contains(@id,'product-')]";
	String lblProductNameInCart = "//tbody//tr//h4//a";
	String txtQuantityInCart = "//td[@class='cart_quantity']//button";
	String btnRemoveProduct = "//a[@class='cart_quantity_delete']";
	String txtCartEmpty = "//b[normalize-space()='Cart is empty!']";
	String btnContinueShopping = "//button[@class='btn btn-success close-modal btn-block']";

}
