//
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OriginalImageWindow{
	OriginalImageWindow(){
		JFrame jf= new JFrame("Puzzle");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setLayout(null);
		JLabel label= new JLabel(new ImageIcon("Medium/image2.jpg"));
		label.setBounds(10, 10, 300, 300);
		jf.add(label);
		jf.setBounds(260, 160, 335, 355);
		jf.setVisible(true);
		}
	}