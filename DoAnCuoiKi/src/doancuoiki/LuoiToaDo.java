/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mylov
 */
class LuoiToaDo extends JPanel implements ActionListener{ // tao ra jpane để vẽ
     private List <Pixel> pixel= new LinkedList<Pixel>(); // test mouse Click
     Line line= new Line(new Pixel(0,0 ), new Pixel(20,0 )); // test draw line
     Pixel p1= new Pixel(10,20); // test Pixel
     Circle c= new Circle(new Pixel(20, 20), 20);
     Rect sq= new Rect( new Pixel(10, 10), new Pixel(30, 30)); // test Hinh Chu Nhat;
     Eclip eclip= new Eclip(new Pixel(0, 0), 20, 10);
     int x=3;
     int y=5;
     Timer tm= new Timer(100, this); // Timer(a,b); a la thoi gian delay;
     public void addPixel(Pixel p){
         pixel.add(p);
         this.repaint();
     }
     public void paintComponent(Graphics g){
         super.getComponents();
         super.paintComponent(g);
         doDraw((Graphics2D)g);
         for(Pixel p:pixel){
//             p.draw(g);
         }
        demo(g);
        tm.start();
     }
     public  void demo(Graphics g){
//           p1.draw(g, Color.GREEN);
//           new Pixel(0, 10).draw(g, Color.yellow);
//           p1.DoiXungQuaDiem(new Pixel(0,10)).draw(g, Color.BLACK);
//           p1.QuayQuanhDiem(new Pixel(0, 10), 90).draw(g, Color.red);
           sq.draw(g, Color.gray);
           sq.Scaling(3,3).draw(g, Color.yellow);
           sq.Quay(45).Scaling(2,2).draw(g, Color.gray);
           sq.Quay(45).Scaling(2,2).DoiXungQuaDuongThang(new Pixel(0,0), new Pixel(20, 20)).draw(g, Color.gray);
           new Line(new Pixel(0,0), new Pixel(20, 20)).Bresenham(g, Color.red);
//         c.bresenhamCircle(g, Color.GREEN);
//         c.Scaling(2, 2).bresenhamCircle(g, Color.yellow);

//             eclip.ellipseMidPoint(g, Color.BLACK, false);
//         p1.draw(g);
//         p1.DoiXungQuaDuongThang(new Pixel(0, 0), new Pixel(20, 20)).draw(g);
//         new Line(new Pixel(0, 0), new Pixel(20, 20)).Bresenham(g);
//         p1.TinhTien(-p1.getX(), -p1.getY()).Quay(-Math.toDegrees(Math.atan((p2.getY()-p1.getY())/(p2.getX()-p1.getX())))).DoiXungOx().Quay(Math.toDegrees(Math.atan((p2.getY()-p1.getY())/(p2.getX()-p1.getX())))).TinhTien(p1.getX(), p1.getY());
//         System.out.println();
//        line.Bresenham(g,Color.BLACK);
//        line.TinhTien(0, -2).Scaling(2, 0).Bresenham(g, Color.red);
//         System.out.println(line.goc1.getX() +" : "+ line.goc1.getY());
//        line.DoiXungO().Bresenham(g);
//        line.Rotate(45).Bresenham(g);
//        line.Rotate(90).Bresenham(g);
//        line.Rotate(180).Bresenham(g);
//        line.Rotate(135).Bresenham(g);
//        line.Rotate(225).Bresenham(g);
//        line.Rotate(270).Bresenham(g);
//        line.Rotate(315).Bresenham(g);
//        p1.Quay(-90);
//        p1.Scaling(5,5);
//        p1.draw(g);
//        tm.stop();
//        p1.Quay(135).draw(g);
//        p1.draw(g);
        
//        sq.draw(g);
     }
      public void doDraw(Graphics2D g){
        this.keLine(g);
        this.veTrucToaToa(g);
        JPanel jpan= new JPanel(new FlowLayout());
        jpan.setLayout(new FlowLayout(100, 50, 200));
        jpan.setVisible(true);
        
    }
     private  void putpixel(int x, int y, Graphics2D g){
        for(int i=-2;i<=2;i++){
            Graphics2D g2d=(Graphics2D) g;
            g2d.drawLine(x-2, y+i, x+2, y+i);
        }
//        g.drawLine(x, y, x, y);
    }
    private void keLine(Graphics2D g){
        Graphics2D g2d=(Graphics2D) g;
        //line doc
        g2d.setPaint(Color.BLACK);
        int maxWight=1228;
        int maxHight=800;
        int begin=5;
        while(begin<1200){
            g2d.drawLine(begin, 5, begin, 795);
            begin=begin+5;
        }
        //line ngang
        //reset begin;
        begin=5;
        while(begin<800){
            g2d.drawLine(5, begin, 1195, begin);
            begin=begin+5;
        }
    }
    private void veTrucToaToa(Graphics2D g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setPaint(Color.RED);
        g2d.drawString("Ox", 1180, 415); //ki hieu ox
        g2d.drawLine(0, 400, 1200, 400); // khung la 1200x800 // ve truc ox
        g2d.drawLine(0, 401, 1200, 401); // do lai truc ox
        g2d.drawLine(601, 2, 601, 800); // ve truc oy
        g2d.drawString(">", 1195, 405);
        g2d.drawString("^", 598, 12);
        g2d.drawString("Oy", 580, 20);
        g2d.drawString("O", 590, 412);
        g2d.setPaint(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
         if(p1.getX()!=0){
             p1.TinhTien(1, 1);
         }
         else
           line.TinhTien(1, 0);
//        if(sq.goc1.getX()<20){
//            sq.TinhTien(-1, -1);
//        }
//        repaint();//To change body of generated methods, choose Tools | Templates.
    }
}
