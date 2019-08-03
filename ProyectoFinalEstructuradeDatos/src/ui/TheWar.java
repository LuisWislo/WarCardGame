/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import WarClass.Card;
import WarClass.GameManager;
import WarClass.Player;
import WarClass.WarFrame;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;


class BoardNode{
    private Card card;
    private Player player;
    
    public BoardNode(Card card, Player player){
        this.card = card;
        this.player = player;
    }
    
    public Card getCard(){
        return this.card;
    }
    
    public Player getPlayer(){
        return this.player;
    }
    
}

public class TheWar extends javax.swing.JPanel {
    private WarFrame gui;
    private GameManager manager;
    private Stack<Card> deck;
    private Stack <BoardNode> miniStackA, miniStackB;
    private Player player1;
    private Player player2;
    private ArrayList<BoardNode> BOARD; 
    private int turn;
    private boolean warMode;
    /**
     * Creates new form TheWar
     */
    public TheWar(WarFrame gui, GameManager manager) {
        initComponents();
        this.gui = gui;
        this.manager = manager;
        this.deck = this.manager.getDeck().getDeck();
        this.player1 = this.manager.getPlayer1();
        this.player2 = this.manager.getPlayer2();
        this.BOARD = new ArrayList<>();
        miniStackA = new Stack<>();
        miniStackB = new Stack<>();
        this.btnDraw1.setVisible(false);
        this.btnDraw2.setVisible(false);
        this.turn=-1;
        this.warMode = false;
        this.lblWAR.setVisible(false);
    }
    
    private void deal(){
        while(!this.deck.isEmpty()){
            this.player1.addToDrawStack(this.deck.pop()); //fix semantics
            this.player2.addToDrawStack((this.deck.pop()));
        }
        //CPU
        System.out.println("Done dealing");
        this.btnDeal.setVisible(false);
        this.btnDraw1.setText(player1.getName());
        this.btnDraw2.setText(player2.getName());
        this.btnDraw1.setVisible(true);
        this.btnDraw2.setVisible(true);
        player1.setCanPlay(true);
        player2.setCanPlay(true);
        turn = 1;
    }
    
    private void winCards(Player winner){
        for (int i = 0; i < BOARD.size(); i++) {
            winner.addToDiscardStack(BOARD.get(i).getCard());
        }
        System.out.println(winner.getName() + " won the exchange!");
        this.BOARD=new ArrayList<>();
        System.out.println("----------------------------------");
    }
    
    private boolean hasLost(Player player){
        if(player.getDrawStack().isEmpty()){
            if(!player.getDiscardStack().isEmpty()){
                player.replenishDrawStack();
                return false;
            }
            return true;
        }
        return false;
    }
    
    private Player pickLoser(Player winner){
        if(winner==player1){
            return player2;
        }
        return player1;
    }
    
    private void endTurn(Player winner){
        if(hasLost(pickLoser(winner))){
            turn=-1;
            victory(winner);
        }     
    }
    
    private void play(Player player){
        turn = -1;
        if(warMode){
            if(player==player1)turnWarA();
            else turnWarB();
        }
        else{
            player.setCanPlay(false);
            BOARD.add(new BoardNode(player.draw(),player));
            Player winner = null;
            if(BOARD.size()==2){
                if(BOARD.get(0).getCard().getRank()>BOARD.get(1).getCard().getRank()){
                    winner = BOARD.get(0).getPlayer();
                }
                else if(BOARD.get(0).getCard().getRank()<BOARD.get(1).getCard().getRank()){
                    winner = BOARD.get(1).getPlayer();
                }
                else{
                    initWar();
                }

                if(winner!=null){
                    winCards(winner);
                    endTurn(winner);
                    player1.setCanPlay(true);
                    player2.setCanPlay(true);
                }
            } 
        }
        turn=1;
    }
    
    private void initWar(){
        warMode = true;
        player1.setCanPlay(true);
        player2.setCanPlay(true);
        System.out.println("WAR!!");
        this.lblWAR.setVisible(true);
        if(this.BOARD.size()>0){
            miniStackA.push(new BoardNode(BOARD.get(0).getCard(),BOARD.get(0).getPlayer()));
            miniStackB.push(new BoardNode(BOARD.get(1).getCard(),BOARD.get(1).getPlayer()));
        }
    }
    
    private void victory(Player player){
        System.out.println(player.getName() + " WINS!");
    }
    
    private void finishWar(char notifier){
        boolean proceed = false;
        if(notifier=='A') proceed = miniStackB.size()==5;
        if(notifier=='B') proceed = miniStackA.size()==5;
        
        if(proceed) {
            if(miniStackA.peek().getCard().getRank()==miniStackB.peek().getCard().getRank()){
                initWar();
            }
            else{
                this.lblWAR.setVisible(false);
                BoardNode winner = miniStackA.peek().getCard().getRank()>miniStackB.peek().getCard().getRank()? miniStackA.peek() : miniStackB.peek();
                miniStackA.addAll(miniStackB);
                this.BOARD = new ArrayList<>(miniStackA);
                this.miniStackA = new Stack<>();
                this.miniStackB = new Stack<>();
                winCards(winner.getPlayer());
                this.warMode = false;
                player1.setCanPlay(true);
                player2.setCanPlay(true);
                endTurn(winner.getPlayer());
                
            }
        }
    }
    
    private void turnWarA() throws EmptyStackException{ //trabaja con el stackA
        try{
            if(miniStackA.size()<5){
            miniStackA.push(new BoardNode(player1.draw(),player1));
            
                if(miniStackA.size()==5){
                    player1.setCanPlay(false);
                    finishWar('A');
                }
        }   
        } catch(EmptyStackException e){
            victory(player2);
        }
        
    }
    
    private void turnWarB(){ 
        try{
            if(miniStackB.size()<5){
            miniStackB.push(new BoardNode(player2.draw(),player2));
            
                if(miniStackB.size()==5){
                    player2.setCanPlay(false);
                    finishWar('B');
                }
            }
            
        } catch(EmptyStackException e){
            victory(player1);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnDeal = new javax.swing.JButton();
        btnDraw1 = new javax.swing.JButton();
        btnDraw2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblWAR = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setText("saddle");

        btnDeal.setText("DEAL");
        btnDeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDealActionPerformed(evt);
            }
        });

        btnDraw1.setText("Player1");
        btnDraw1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDraw1ActionPerformed(evt);
            }
        });

        btnDraw2.setText("Player2");
        btnDraw2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDraw2ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblWAR.setText("WAR!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(btnDeal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnDraw1)
                        .addGap(261, 261, 261)
                        .addComponent(btnDraw2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(lblWAR)))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblWAR)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton1)))
                .addGap(69, 69, 69)
                .addComponent(btnDeal)
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDraw1)
                    .addComponent(btnDraw2))
                .addContainerGap(219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDealActionPerformed
        deal();
    }//GEN-LAST:event_btnDealActionPerformed

    private void btnDraw1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDraw1ActionPerformed
        if(turn==1 && player1.canPlay()) play(player1);
    }//GEN-LAST:event_btnDraw1ActionPerformed

    private void btnDraw2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDraw2ActionPerformed
        if(turn==1 &&  player2.canPlay()) play(player2);
    }//GEN-LAST:event_btnDraw2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        System.out.print("Player 1: Draw : [");
        for (int i = 0; i < player1.getDrawStack().size(); i++) {
            System.out.print(player1.getDrawStack().get(i).getRank()+" , ");
        }
        System.out.print("] // Discard: [");
        for (int i = 0; i < player1.getDiscardStack().size(); i++) {
            System.out.print(player1.getDiscardStack().get(i).getRank()+" , ");
        }
        System.out.print("]");
        
        System.out.println("");
        
        System.out.print("Player 2: Draw : [");
        for (int i = 0; i < player2.getDrawStack().size(); i++) {
            System.out.print(player2.getDrawStack().get(i).getRank()+" , ");
        }
        System.out.print("] // Discard: [");
        for (int i = 0; i < player2.getDiscardStack().size(); i++) {
            System.out.print(player2.getDiscardStack().get(i).getRank()+" , ");
        }
        System.out.print("]");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeal;
    private javax.swing.JButton btnDraw1;
    private javax.swing.JButton btnDraw2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblWAR;
    // End of variables declaration//GEN-END:variables
}
