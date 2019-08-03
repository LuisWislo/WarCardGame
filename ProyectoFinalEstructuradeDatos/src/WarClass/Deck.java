
package WarClass;

//import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Deck{
    private Stack<Card> deck;
    
    public Deck(){// throws IOException{
        this.deck = new Stack<>();
        this.addCards();
        System.out.println("Done adding cards");
        this.shuffle();
    }
    
    private void addCards(){
        
        this.deck.add(new Card("clubs",2,new ImageIcon("cards\\2C.png")));
        this.deck.add(new Card("diamonds",2,new ImageIcon("cards\\2D.png")));
        this.deck.add(new Card("hearts",2,new ImageIcon("cards\\2H.png")));
        this.deck.add(new Card("spades",2,new ImageIcon("cards\\2S.png")));
        
        this.deck.add(new Card("clubs",3,new ImageIcon("cards\\3C.png")));
        this.deck.add(new Card("diamonds",3,new ImageIcon("cards\\3D.png")));
        this.deck.add(new Card("hearts",3,new ImageIcon("cards\\3H.png")));
        this.deck.add(new Card("spades",3,new ImageIcon("cards\\3S.png")));
        
        this.deck.add(new Card("clubs",4,new ImageIcon("cards\\4C.png")));
        this.deck.add(new Card("diamonds",4,new ImageIcon("cards\\4D.png")));
        this.deck.add(new Card("hearts",4,new ImageIcon("cards\\4H.png")));
        this.deck.add(new Card("spades",4,new ImageIcon("cards\\4S.png")));
        
        this.deck.add(new Card("clubs",5,new ImageIcon("cards\\5C.png")));
        this.deck.add(new Card("diamonds",5,new ImageIcon("cards\\5D.png")));
        this.deck.add(new Card("hearts",5,new ImageIcon("cards\\5H.png")));
        this.deck.add(new Card("spades",5,new ImageIcon("cards\\5S.png")));
        
        this.deck.add(new Card("clubs",6,new ImageIcon("cards\\6C.png")));
        this.deck.add(new Card("diamonds",6,new ImageIcon("cards\\6D.png")));
        this.deck.add(new Card("hearts",6,new ImageIcon("cards\\6H.png")));
        this.deck.add(new Card("spades",6,new ImageIcon("cards\\6S.png")));
        
        this.deck.add(new Card("clubs",7,new ImageIcon("cards\\7C.png")));
        this.deck.add(new Card("diamonds",7,new ImageIcon("cards\\7D.png")));
        this.deck.add(new Card("hearts",7,new ImageIcon("cards\\7H.png")));
        this.deck.add(new Card("spades",7,new ImageIcon("cards\\7S.png")));
        
        this.deck.add(new Card("clubs",8,new ImageIcon("cards\\8C.png")));
        this.deck.add(new Card("diamonds",8,new ImageIcon("cards\\8D.png")));
        this.deck.add(new Card("hearts",8,new ImageIcon("cards\\8H.png")));
        this.deck.add(new Card("spades",8,new ImageIcon("cards\\8S.png")));
        
        this.deck.add(new Card("clubs",9,new ImageIcon("cards\\9C.png")));
        this.deck.add(new Card("diamonds",9,new ImageIcon("cards\\9D.png")));
        this.deck.add(new Card("hearts",9,new ImageIcon("cards\\9H.png")));
        this.deck.add(new Card("spades",9,new ImageIcon("cards\\9S.png")));
        
        this.deck.add(new Card("clubs",10,new ImageIcon("cards\\10C.png")));
        this.deck.add(new Card("diamonds",10,new ImageIcon("cards\\10D.png")));
        this.deck.add(new Card("hearts",10,new ImageIcon("cards\\10H.png")));
        this.deck.add(new Card("spades",10,new ImageIcon("cards\\10S.png")));
        
        this.deck.add(new Card("clubs",11,new ImageIcon("cards\\AC.png")));
        this.deck.add(new Card("diamonds",11,new ImageIcon("cards\\AD.png")));
        this.deck.add(new Card("hearts",11,new ImageIcon("cards\\AH.png")));
        this.deck.add(new Card("spades",11,new ImageIcon("cards\\AS.png")));
        
        this.deck.add(new Card("clubs",12,new ImageIcon("cards\\JC.png")));
        this.deck.add(new Card("diamonds",12,new ImageIcon("cards\\JD.png")));
        this.deck.add(new Card("hearts",12,new ImageIcon("cards\\JH.png")));
        this.deck.add(new Card("spades",12,new ImageIcon("cards\\JS.png")));
        
        this.deck.add(new Card("clubs",13,new ImageIcon("cards\\QC.png")));
        this.deck.add(new Card("diamonds",13,new ImageIcon("cards\\QD.png")));
        this.deck.add(new Card("hearts",13,new ImageIcon("cards\\QH.png")));
        this.deck.add(new Card("spades",13,new ImageIcon("cards\\QS.png")));
        
        this.deck.add(new Card("clubs",14,new ImageIcon("cards\\KC.png")));
        this.deck.add(new Card("diamonds",14,new ImageIcon("cards\\KD.png")));
        this.deck.add(new Card("hearts",14,new ImageIcon("cards\\KH.png")));
        this.deck.add(new Card("spades",14,new ImageIcon("cards\\KS.png")));
        
    }
    
    public void shuffle(){
      Collections.shuffle(this.deck);
    }
    
    public Card draw(){
        return getDeck().pop();
    }
    
    private void swapElements(int a, int b){
        
    }

    public Stack<Card> getDeck() {
        return deck;
    }
    
    public Card getCard(){
        return this.deck.pop();
    }
    
    
    /*public Card getCard(){
        return this.card;
    }*/
}