import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WalkerClock extends JPanel implements ActionListener {

    Timer t = new Timer(1000, this);
    Random random= new Random();

    //with random starting point
    int x=random.nextInt(500);
    int velX=1;
    int y=random.nextInt(500);
    int velY=1;

    int displacement= 10;
    int prob;

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        prob=random.nextInt(100);
        Graphics2D g1 = (Graphics2D) g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g1.setStroke(new BasicStroke(3));
        g1.setColor(Color.black);

        g1.drawOval(x,y, 50, 50);
        g1.drawString(prob+"", x, y);

        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent event){



        if (prob<25){
            y-=displacement;
        }
         else if (prob>25 && prob <50){
            x-=displacement;
        }
         else if(prob>50 && prob <75){
            y+=displacement;
        }
        else{
            x+=displacement;
        }


        System.out.println(prob);
        repaint();
       // }
    }

    public static void main(String[] args){

        JFrame j = new JFrame("walker");
        WalkerClock w = new WalkerClock();

        j.setSize(600,600);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(w);



    }



}
