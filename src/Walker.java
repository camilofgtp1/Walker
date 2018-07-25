import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Walker extends JPanel implements ActionListener {

    Timer t = new Timer(200, this);
    Random random= new Random();

    //with random starting point
    int x=random.nextInt(600);
    int velX=1;
    int y=random.nextInt(600);
    int velY=1;

    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        g.setColor(Color.black);
        g.drawOval(x,y, 2, 2);

        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent event){

        int prob= random.nextInt(100);

        if (prob<20){
            y--;
        }
         else if (prob<30 && prob >10){
            x--;
        }
         else if(prob>30 && prob <35){
            y++;
        }
        else{
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
