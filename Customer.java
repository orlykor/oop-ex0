
class Customer {
	
	String name;
	String address;
	int balance;
	String log;
	final int NO_MONEY = 0, NO_AMOUNT = 0;
	final String EMTPY_STRING = "", OPEN_BRACKETS = "[", CLOSE_BRACKETS = "]", 
			COMMA = ",", NEW_LINE = "\n", SPACE = " ";

	Customer(String customerName, String customerAddress, int customerBalance){
		//Construct a new customer with the given parameters.
		//also checks if there are no empty strings
		if (customerName == null){
			name = EMTPY_STRING;
		}else{
			name = customerName;			
		}
		if (customerAddress == null){
			address = EMTPY_STRING;
		}else{
			address = customerAddress;			
		}
		balance = customerBalance;
		log = "Shopping log for customer: " + name;								
		}
		
	
	int maximumAffordableQuantity(ProductType productType){
		//Calculates the maximal number of units of the given product type 
		//that this customer can afford to buy.
		if (balance > NO_MONEY){			
			return balance / productType.customerPrice;
		}return NO_MONEY;
	}	
	
	String stringRepresentation(){
		//Return a string representation of this Customer, which is a sequence 
		//of the customer name, address and his balance.
		return OPEN_BRACKETS + name + COMMA + address + COMMA + balance + 
				CLOSE_BRACKETS;
	}
	
	
	boolean canAfford(int quantity,ProductType productType){
		//Checks whether this customer can afford to buy the given quantity of 
		//units of products of the given product type.
		 if (balance >= (productType.customerPrice * quantity) ){
			 return true; 
		 }return false;		 
	}
	
	
	String getPurchaseLog(){
		//return the items the customer had purchased
		return log;
	
	}
	
	void makePurchase(int quantity,ProductType productType){
		//Makes a purchase for this customer of the given amount of product of 
		//the given type, if he can afford it; this includes taking the price 
		//of the purchase out of his balance and adding the purchase to the 
		//purchase log of the customer. Non-positive quantities are ignored.
		
		if (canAfford(quantity,productType) && (quantity > NO_AMOUNT) ){			
			balance = (balance - (quantity * productType.customerPrice));
			log += NEW_LINE + quantity + SPACE + productType.name;
			
		}
	}
}
