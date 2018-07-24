import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Walker extends JPanel implements ActionListener {

    Timer t = new Timer(5, this);
    int x=300;
    int velX=1;
    int y=300;
    int velY=1;
    Random random= new Random();

    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.setColor(Color.black);
        g.drawOval(x,y, 1, 1);

        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent event){

        int prob= random.nextInt(4);

        //if(x<600 || x< 0 || y<600  || y>0){

        if (prob==0){
            y--;
        }
        if (prob==1){
            x--;
        }
        if(prob==2){
            y++;
        }
        if(prob==3){
            x++;
        }


        System.out.println(prob);
        repaint();
       // }
    }

    public static void main(String[] args){

        JFrame j = new JFrame("walker");
        Walker w = new Walker();

        j.setSize(600,600);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(w);



    }



}
