
class ProductType {
	
	int customerPrice;
	String name;
	int storePrice;
	final String EMTPY_STRING = "", OPEN_BRACKETS = "[", CLOSE_BRACKETS = "]", 
				COMMA = ",";
	
	ProductType(String productName, int productStorePrice,
			int	productCustomerPrice){
		//Constructs a new type of product with the given parameters.
		if (productName == null){ // check if there is no product
			name = EMTPY_STRING;
		}else{
			name = productName;
			
		}
		customerPrice = productCustomerPrice;
		storePrice = productStorePrice;

		
		
	}
	int profitPerUnit(){
		//The profit per unit for this product type, calculated with the 
		//formula: profit = (customer price) - (store price)
		int profit = (customerPrice) - (storePrice);
		return profit;			
			
	}
	String stringRepresentation(){
		//Returns a string representation of the product type, which is a 
		//sequence of the product name, store price and customer price. 		
		return OPEN_BRACKETS + name + COMMA + storePrice + COMMA + 
				customerPrice + CLOSE_BRACKETS;
	}
	

}
