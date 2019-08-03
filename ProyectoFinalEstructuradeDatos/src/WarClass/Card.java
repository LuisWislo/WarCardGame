
package WarClass;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Card {
    private String suit;
    private int rank;
    private ImageIcon face;
    
    public Card(String suit, int rank, ImageIcon face){
       this.suit = suit;
       this.rank = rank;
       this.face = face;
    }
    
    public String toString(){
        return this.rank + " of " + this.suit;
    }
    
    
    /*
    public Image getFace() {
        return this.card.getImage();
    }

    public void setFace(Image image) {
        this.card.setImage(image);
    }
    
/*
    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    public String toString(){
        return this.face+", "+this.suit;
    }
*/

    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @return the face
     */
    public ImageIcon getFace() {
        return face;
    }

}
