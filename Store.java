
class Store {
	
	final int MAX_NUM_OF_PRODUCT_TYPES = 5, ANITIALIZE_NUM = 0;
	int balance;
	final String EMTPY_STRING = "", NEW_LINE = "\n";
	ProductType[] productTypeArray;
	
	
	Store() {
		//Constructs a new Store object.
		balance = ANITIALIZE_NUM;
		productTypeArray = new ProductType[MAX_NUM_OF_PRODUCT_TYPES];
	}
	
	
	String stringRepresentation(){
		//Return a string representation of the store, which includes a 
		//sentence detailing the store's balance, and an additional line for 
		//each product in the store, matching the string representation of the 
		//corresponding product.
		String store_balance = "Store has a balance of " + balance + 
				", and the " + "following products:";
		String store_product= EMTPY_STRING;	
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++){
			if (productTypeArray[i] != null){
			store_product = store_product + NEW_LINE +
		    productTypeArray[i].stringRepresentation();
			}
		}return store_balance + store_product;		

	}			

	
	boolean addProductType(ProductType productType){
		//Attempts to add a type of product to the store.
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++){
			if (productTypeArray[i] == null){ 
				productTypeArray[i] = productType;
					return true;
				}
		}return false;						
	}
			
		
	boolean sellsProductsOfType(String productTypeName){
		//Checks whether this store sells products of the given name.
		if (productTypeName != null){
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++){
			if (productTypeArray[i] != null){
				if (productTypeArray[i].name.equals(productTypeName)){
					return true;
				}
			}
			}
		}return false;		
	}
	
	
	boolean removeProductTypeFromStore(String productTypeName){
		//Removes a product type with the given name from the store.
		for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++){
			if (productTypeArray[i] != null){
				if (productTypeArray[i].name.equals(productTypeName)){
					productTypeArray[i] = null;
					return true; 							
			     }
			}
		}return false;			
	}
	
	
	int makePurchase(Customer customer, String productTypeName, int quantity){
		//Make a purchase for the given customer of the given amount of 
		//products of the given type, if he can afford it, and if the 
		//store sells product of this type; this includes updating the 
		//balance of the store with the profit it made from this purchase.
		ProductType productType = null;
		int amnt = 0;
		if (sellsProductsOfType(productTypeName)){
			for (int i = 0; i < MAX_NUM_OF_PRODUCT_TYPES; i++){
				if (productTypeArray[i] != null){
					if (productTypeArray[i].name.equals(productTypeName)){
						productType = productTypeArray[i];
						if (!customer.canAfford(quantity, productType)){
							amnt = customer.maximumAffordableQuantity
								(productType);
					    }else {
					    	amnt = quantity;
					    }
					}
				}
			}
					balance += (productType.profitPerUnit() * amnt);
					customer.makePurchase(amnt, productType);
					return amnt;	
		}return 0;
	}		
}
