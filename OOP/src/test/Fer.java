package test;
import java.awt.*;

import javax.swing.*;

public class Fer extends JFrame {
    public Fer (String titlu) {

        super(titlu);

        setSize(200,100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container x=getContentPane();

        x.setLayout(new FlowLayout() );

        JButton A=new JButton("Buton 1"); x.add(A);

        JButton B=new JButton("Button 2"); x.add(B);

        setVisible(true);

    }

}

class pv{

    public static void main(String args[]){

        Fer fp=new Fer("Doua butoane");

    }
}
