package monopoly;

public class Square {
    int squareNum;
    String name;
    Player owner;
    int sellPrice;
    
    public Square(String name,double value) {
        this.name = name;
    }
    
    public void setOwner(Player play) {
        this.owner = play;
    }
    
    public void buy(Player buyer) {
    	if (buyer.getBalance() > this.sellPrice) {
            this.setOwner(buyer);
            buyer.pay(sellPrice);
    	}
    }
    
    public Player getOwner() {
        return owner;
    }
}
