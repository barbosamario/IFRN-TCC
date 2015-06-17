package oitbpm.nc.bd_8ºbpm.backgroundDP;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class JBackground extends JDesktopPane {
	
	public void paintComponent(Graphics g) {
		
		Image img = new ImageIcon(this.getClass().getResource("/Batalhao.jpg")).getImage();
		
		try{
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
