import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawCCU extends JFrame{
	public DrawCCU(){
		super("Draw CCU");
		setSize(1000,663);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		Image img = null;
		
		super.paint(g);
		try {
		    img = ImageIO.read(new File("1-1.jpg"));
		} catch (IOException e) {
			
		}
		
		g.drawImage(img, 0, 0, this);
		
		
		
		//pool-line part start
		g.drawLine(0, 580, 458, 663);
		g.drawLine(0, 570, 518, 663);
		g.drawLine(0, 552, 758, 663);
		g.drawLine(0, 496, 617, 449);
		g.drawLine(617, 449, 1000, 449);
		g.drawLine(0, 607, 265, 663);
		g.drawLine(758, 663, 1000, 663);
		g.drawLine(1000, 663, 1000, 449);
		g.setColor(new Color(170, 233, 255));
		g.drawLine(758, 663, 1000, 449);
		g.setColor(Color.BLACK);
		//end of pool-line part
		
		//main building(pillar) part
		g.setColor(Color.WHITE);
		
		g.drawLine(195, 175, 187, 400);
		g.drawLine(215, 175, 208, 400);
		g.drawLine(195, 175, 215, 175);
		g.drawLine(187, 400, 208, 400);
		
		g.drawLine(310, 180, 307, 400);
		g.drawLine(330, 180, 328, 400);
		g.drawLine(310, 180, 330, 180);
		g.drawLine(328, 400, 307, 400);
		
		g.drawLine(420, 185, 420, 400);
		g.drawLine(440, 185, 440, 400);
		g.drawLine(420, 185, 440, 185);
		g.drawLine(420, 400, 440, 400);
		
		g.drawLine(525, 190, 530, 400);
		g.drawLine(545, 190, 550, 400);
		g.drawLine(525, 190, 545, 190);
		g.drawLine(530, 400, 550, 400);
		
		g.drawLine(621, 195, 630, 400);
		g.drawLine(641, 195, 650, 400);
		g.drawLine(621, 195, 641, 195);
		g.drawLine(630, 400, 650, 400);
		
		g.drawLine(713, 205, 721, 400);
		g.drawLine(731, 205, 740, 400);
		g.drawLine(713, 205, 731, 205);
		g.drawLine(721, 400, 740, 400);
		
		g.drawLine(797, 205, 811, 400);
		g.drawLine(815, 205, 830, 400);
		g.drawLine(797, 205, 815, 205);
		g.drawLine(811, 400, 830, 400);
		
		//end of main building(pillar) part
		
		//main building(roof) part
		g2.setStroke(new BasicStroke(3.0f));
		g.setColor(new Color(204, 51, 0));
		g.setColor(Color.WHITE);
		g.drawLine(202, 90, 200, 120);
		g.drawLine(202, 90, 233, 185);
		g.drawLine(200, 120, 218, 180);
		g.drawLine(200, 120, 206, 105);
		g.drawLine(206, 105, 206, 130);
		g.drawLine(206, 130, 215, 135);
		g.drawLine(215, 135, 220, 180);
		g.drawLine(220, 180, 228, 170);
		
		g.drawLine(325, 100, 323, 180);
		
		g.drawLine(440, 110, 413, 190);
		g.drawLine(440, 110, 440, 130);
		g.drawLine(440, 130, 435, 180);
		g2.setStroke(new BasicStroke(5.0f));
		g.drawLine(440, 110, 425, 180);
		g2.setStroke(new BasicStroke(3.0f));
		
		g.drawLine(552, 100, 550, 150);
		g.drawLine(550, 150, 545, 170);
		g.drawLine(545, 170, 535, 190);
		g.drawLine(555, 100, 500, 190);
		g.drawLine(552, 100, 538, 180);
		g.drawLine(538, 180, 525, 155);
		g.drawLine(525, 155, 525, 185);
		g.drawLine(525, 155, 525, 195);
		g.drawLine(525, 195, 515, 170);
		g.drawLine(515, 170, 510, 200);
		
		g.setColor(Color.RED);
		g.drawLine(653, 125, 653, 150);
		g.drawLine(653, 125, 583, 195);
		g.drawLine(653, 150, 647, 180);
		g.drawLine(647, 180, 607, 210);
		g.drawLine(653, 145, 642, 135);
		g.drawLine(642, 135, 632, 188);
		g.drawLine(632, 188, 622, 160);
		g.drawLine(622, 160, 617, 200);
		g.drawLine(617, 200, 607, 170);
		g.drawLine(607, 170, 598, 205);
		
		g.drawLine(748, 135, 653, 205);
		g.drawLine(748, 135, 748, 155);
		g.drawLine(748, 155, 738, 190);
		g.drawLine(738, 190, 698, 210);
		g.drawLine(738, 145, 743, 160);
		g.drawLine(735, 145, 725, 193);
		g.drawLine(725, 193, 710, 168);
		g.drawLine(710, 168, 702, 208);
		g.drawLine(702, 208, 687, 183);
		g.drawLine(687, 183, 677, 213);
		g.drawLine(677, 213, 667, 193);
		
		g.drawLine(842, 138, 735, 200);
		g.drawLine(842, 138, 842, 158);
		/*******************************************************/
		g2.setStroke(new BasicStroke(1.0f));
		
		g.setColor(new Color(204, 51, 0));
		g.drawLine(200, 130, 780, 170);
		g.drawLine(200, 165, 750, 195);
		
		g.drawLine(210, 130, 318, 170);
		g.drawLine(318, 170, 435, 145);
		g.drawLine(435, 145, 530, 185);
		g.drawLine(530, 185, 625, 160);
		g.drawLine(625, 160, 720, 200);
		
		//end of main building(roof) part
		
		//audior-stand(up) part
		g.drawLine(0, 230, 426, 310);
		g.drawLine(0, 240, 426, 320);
		g.drawLine(426, 310, 426, 320);
		g.drawLine(426, 320, 380, 335);
		g.drawLine(380, 335, 0, 280);
		//end of auditor-stand(up) part
		
		//audior-stand(down1-pillar) part
		g.setColor(Color.WHITE);
		g.drawLine(27, 285, 25, 390);
		
		g.drawLine(72, 290, 70, 390);
		g.drawLine(112, 295, 110, 390);
		g.drawLine(70, 390, 110, 392);
		g.drawLine(112, 295, 72, 290);
		
		g.drawLine(222, 312, 220, 395);
		g.drawLine(252, 315, 250, 395);
		g.drawLine(252, 315, 222, 312);
		g.drawLine(220, 397, 250, 397);
		
		g.drawLine(286, 325, 284, 395);
		g.drawLine(311, 328, 309, 400);
		g.drawLine(286, 320, 311, 323);
		g.drawLine(284, 400, 309, 400);
		
		g.drawLine(351, 330, 351, 400);
		g.drawLine(376, 335, 376, 400);
		g.drawLine(351, 330, 376, 335);
		g.drawLine(376, 400, 351, 400);
		//end of audior-stand(down1-pillar) part
		
		g.setColor(Color.BLACK);
		
		//audior-stand(down2) part
		g.drawLine(0, 420, 475, 425);
		g.drawLine(0, 390, 475, 405);
		g.drawLine(0, 415, 475, 420);
		
		g.drawLine(475, 425, 475, 405);
		g.drawLine(475, 420, 1000, 410);
		g.drawLine(475, 415, 1000, 405);
		g.drawLine(475, 395, 1000, 385);
		g.drawLine(475, 395, 475, 415);
		//end of audior-stand(down2) part
		
		//the pool part
		int[] poolx = {617, 1000, 758, 0, 0};
		int[] pooly = {449, 449, 663, 552, 496};
		g.setColor(new Color(51, 204, 204));//water blue
		g.fillPolygon(poolx, pooly, 5);
		int[] poolx1 = {1000, 1000, 758};
		int[] pooly1 = {663, 449, 663};
		g.setColor(new Color(51, 204, 204));
		g.fillPolygon(poolx1, pooly1, 3);
		//end of pool coloring
		
		
	}
	public static void main(String arg[]){
		DrawCCU draw = new DrawCCU();
		draw.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
