package monopoly;

public class Square {
    String name;
    Player owner;
    int sellPrice;
    
    public Square(String name,int value) {
        this.name = name;
        sellPrice = value;
    }
    
    public void setOwner(Player play) {
        this.owner = play;
        
    }
    
    public void buy(Player buyer) {
    	if (buyer.getBalance() >= this.sellPrice) {
            if (owner == null) {
                buyer.pay(this.sellPrice);
                this.setOwner(buyer);
            }
    		
        }
    	
    }
    
    public Player getOwner() {
        return this.owner;
    }
}
