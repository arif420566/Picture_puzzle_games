

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainClass {
	public static void main(String[]q){

		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		catch (UnsupportedLookAndFeelException e) {
		   // handle exception
			}
		catch (ClassNotFoundException e) {
		   // handle exception
			}
		catch (InstantiationException e) {
		   // handle exception
			}
		catch (IllegalAccessException e) {
		   // handle exception
			}

		JFrame jf= new JFrame("Puzzle");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new MainWindow());
		jf.setBounds(260, 160, 600, 400);
		jf.setVisible(true);
		}
	}