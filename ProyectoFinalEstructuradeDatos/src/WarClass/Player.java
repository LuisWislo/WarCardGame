/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarClass;

import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Player{
    private Stack<Card> discardStack , drawStack;
    private ImageIcon playerIcon;
    private String name;
    private boolean canPlay;
    
    
    public Player(String name){
        this.name = name;
        this.discardStack = new Stack<>();
        this.drawStack = new Stack<>();
        this.canPlay = false;
    }
    
    public void setCanPlay(boolean canPlay){
        this.canPlay = canPlay;
    }
    
    public boolean canPlay(){
        return this.canPlay;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setPlayerIcon(ImageIcon playerIcon){
        this.playerIcon = playerIcon;
    }
    
    public Stack<Card> getDrawStack(){
        return this.drawStack;
    }
    
    public Stack <Card> getDiscardStack(){
        return this.discardStack;
    }
    
    public Card draw(){
        if(!this.drawStack.isEmpty()){
            System.out.println(this.name+": "+this.drawStack.peek().toString()+" added to the board.");
            return this.drawStack.pop();
        }
        replenishDrawStack();
        if(!this.drawStack.isEmpty()){
            System.out.println(this.drawStack.peek().toString()+" added to the board.");
            return this.drawStack.pop();
        }
        return null;
        
    }
    
    public void discard(Card c){
        
    }
    
    public void addToDrawStack(Card card){
        this.drawStack.push(card);
    }
    
    public void addToDiscardStack(Card card){
        
        this.discardStack.push(card);
    }
    
    
    public boolean hasCards(){ //FIX
        return !this.drawStack.isEmpty();
    }
    
    
    public String toString(){
        return "";
    }
    
    public void replenishDrawStack(){
        this.drawStack = this.discardStack;
        this.discardStack = new Stack<>();
    }
    
    
    
    
}
