/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarClass;

/**
 *
 * @author Wislo
 */
public class GameManager {
    private WarFrame gui;
    private Player player1 , player2;
    private boolean cpu;
    private Deck deck;
    
    
    public GameManager(WarFrame gui){
        this.gui = gui;
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.cpu=false;
    }
    
    public Player getPlayer1(){
        return this.player1;
    }
    
    public Player getPlayer2(){
        return this.player2;
    }
    
    public void setCPU(boolean cpu){
        this.cpu = cpu;
    }
    
    public Deck getDeck(){
        return this.deck;
    }
    
    
    
    public void run(){
        System.out.println("Game Starts");
        this.deck = new Deck();
        this.gui.goToWar(this);
        
        
        //mandar a llamar a la otra pantalla
        //deal cards
    }
    
    
    
}
