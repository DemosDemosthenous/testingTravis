package monopoly;

public class Square {
    int squareNum;
    String name;
    Player owner;
    double sellPrice;
    
    public Square(String name) {
        this.name = name;
    }
    
    public void setOwner(Player play) {
        this.owner = play;
    }
    
    public void buy(Player buyer) {
        this.setOwner(buyer);
        buyer.pay(sellPrice);
    }
    
    public Player getOwner() {
        return owner;
    }
}
