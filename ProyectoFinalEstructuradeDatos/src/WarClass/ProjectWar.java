
package WarClass;

import java.io.IOException;
//import javax.swing.JFrame;

public class ProjectWar {
    private WarFrame game;
    
    public ProjectWar(){
        this.game = new WarFrame();
    }
    public static void main(String[] args){// throws IOException{
        new ProjectWar();
    }
    
}
