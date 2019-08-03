/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarClass;

import java.awt.CardLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.*;
public class WarFrame extends JFrame{
    private Container c;
    private CardLayout cardLay;
    private Menu pMenu;
    private Rules pRules;
    private Credits pCredits;
    private MatchSetup pMatchSetup;
    private TheWar pWar;
    
    
    public WarFrame() {//throws IOException{
        this.init();
    }
    
    private void init(){// throws IOException{
        this.c=getContentPane();
        this.cardLay = new CardLayout();
        c.setLayout(cardLay);
        c.setSize(800,600);
        this.initPanels();
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void initPanels(){
        this.pMenu=new Menu(this);
        this.pRules=new Rules(this);
        this.pCredits = new Credits(this);
        this.pMatchSetup = new MatchSetup(this);
        
        
        c.add(pMenu,"menu");
        c.add(pRules,"rules");
        c.add(pCredits, "credits");
        c.add(pMatchSetup,"setup");
        
    }
    
    public void goToMenu(){
        cardLay.show(c, "menu");
    }
    public void goToRules(){
        cardLay.show(c, "rules");
    }
    public void goToCredits(){
        cardLay.show(c, "credits");
    }
    public void goToSetup(GameManager manager){
        this.pMatchSetup.setManager(manager);
        cardLay.show(c, "setup");
    }
    
    public void goToWar(GameManager manager){
        this.pWar = new TheWar(this,manager);
        c.add(pWar,"war");
        cardLay.show(c, "war");
    }
    
    /*
    JFrame tablero = new JFrame();
                Deck baraja = new Deck(); 
                /*
                Not able to submit breakpoint MethodBreakpoint [proyectofinalestructuradedatos.Deck].Deck 
                '(Ljava/lang/String;)V', reason: Method '<init>' with signature '(Ljava/lang/String;)V' 
                does not exist in class proyectofinalestructuradedatos.Deck.
                                           */
        /*JPanel centro = new JPanel(),
               player1 = new JPanel(),
               player2 = new JPanel();
        tablero.setBounds(0, 0, 800, 600);

        //tablero.pack();
  
        centro.setBounds(0, 0, 150, 100);
        player1.setBounds(0, 0, 150, 100);
        player2.setBounds(0, 0, 150, 100);
        
        player1.add(new JLabel(new ImageIcon(baraja.getCard().getFace())));
        player2.add(new JLabel(new ImageIcon(baraja.getCard().getFace())));
        
        
        
        tablero.add(centro);
        tablero.add(player1);
        tablero.add(player2);
        
        
        tablero.setLocationRelativeTo(null); // Center the tablero
        tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablero.setVisible(true);
    */
}
