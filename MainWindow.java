
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainWindow extends JPanel implements MouseListener, ActionListener {
public MainWindow(){
	setLayout(null);

	lTitle= new JLabel("<html><div>Welcome to</div><h1>ASN Game House</h1></html>");
	lTitle.setBounds(20, 30, 300, 200);
	lTitle.setForeground(Color.WHITE);
	add(lTitle);

	String level[]= {"Normal", "Professional", "World Class"};
	boxLevel= new JComboBox(level);
	boxLevel.setBounds(350, 100, 150, 30);
//	add(boxLevel);

	bStartGame= new JButton("Start Game");
	bStartGame.setBounds(350, 150, 150, 30);
	add(bStartGame);

	bImage= new JButton("Original Picture");
	bImage.setBounds(350, 200, 150, 30);
	add(bImage);



	for(int i=0; i<16; i++){
		imgNames[i]= "Medium/2-"+(i+1)+".jpg";
		}


	for(int i=0; i<16; i++){
		images[i]= new ImageIcon(imgNames[i]);
		}

	this.addMouseListener(this);
	
	bImage.addActionListener(this);
	bStartGame.addActionListener(this);
	}
public void paintComponent(Graphics g){
	super.paintComponent(g);
	int extX=1, extY=1;
	for(int i=1; i<=16; i++){
		images[i-1].paintIcon(this, g, extX, extY);
		extX+=76;
		if(i%4==0){
			extX=1;
			extY+=76;
			}
		}
	}

public void startGame(){
	Random ra= new Random();
	for(int i=0; i<difficultyLevel; i++){
		int ranNum= ra.nextInt(14);
		String tmp= imgNames[i];
		imgNames[i]= imgNames[ranNum];
		imgNames[ranNum]= tmp;
		}

	for(int i=0; i<16; i++){
		images[i]= new ImageIcon(imgNames[i]);
		}

	for(int i=0; i<5; i++){
		int wdth=0;
		for(int j=0; j<5; j++){
			X[i][j]=wdth;
			wdth+=76;
			}
		}
	int hght=0;
	for(int i=0; i<5; i++){
		for(int j=0; j<5; j++){
			Y[i][j]=hght;
			}
		hght+=76;
		}
	lTitle.setVisible(false);

	bStartGame.setEnabled(false);
	repaint();
	}

public void reverseImg(int XX, int YY, int img){
	if(Math.abs(varX-XX)<=78 && Math.abs(varY-YY)<=2){
		
		ImageIcon tmp= images[varImg];
		images[varImg]= images[img];
		images[img]= tmp;
		varImg=img;
		int temp= varX;
		varX= XX;
		XX= temp;
		temp= varY;
		varY= YY;
		YY= temp;
		}
	else if(Math.abs(varX-XX)<=2 && Math.abs(varY-YY)<=78){
	
		ImageIcon tmp= images[varImg];
		images[varImg]= images[img];
		images[img]= tmp;
		varImg=img;
		int temp= varX;
		varX= XX;
		XX= temp;
		temp= varY;
		varY= YY;
		YY= temp;
		}
	repaint();
	checkGameOver();
	}

public void checkGameOver(){
	int count=0;
	for(int i=0; i<16;i++){
		if(("Medium/2-"+(i+1)+".jpg").equals(images[i].getDescription())){
			count++;
			}
		else break;
		}
	if(count==16){
		JOptionPane.showMessageDialog(this, "You win!!!!!!!!");

		bStartGame.setEnabled(true);
		}
	}



public void actionPerformed(ActionEvent e){
	if(bImage==e.getSource()){
		new OriginalImageWindow();
		}

	if(bStartGame==e.getSource()){
		startGame();
		}
	}

public void mouseClicked(MouseEvent e){
 
	int x= e.getX();
	int y= e.getY();

	if((x>X[0][0] && y>Y[0][0]) && (x<X[4][4] && y<Y[4][4])){
		if((x>X[0][0] && y>Y[0][0]) && (x<X[1][1] && y<Y[1][1])){
			reverseImg(X[0][0], Y[0][0], 0);
			}
		if((x>X[0][1] && y>Y[0][1]) && (x<X[1][2] && y<Y[1][2])){
			reverseImg(X[0][1], Y[0][1], 1);
			}
		if((x>X[0][2] && y>Y[0][2]) && (x<X[1][3] && y<Y[1][3])){
			reverseImg(X[0][2], Y[0][2], 2);
			}
		if((x>X[0][3] && y>Y[0][3]) && (x<X[1][4] && y<Y[1][4])){
			reverseImg(X[0][3], Y[0][3], 3);
			}
		if((x>X[1][0] && y>Y[1][0]) && (x<X[2][1] && y<Y[2][1])){
			reverseImg(X[1][0], Y[1][0], 4);
			}
		if((x>X[1][1] && y>Y[1][1]) && (x<X[2][2] && y<Y[2][2])){
			reverseImg(X[1][1], Y[1][1], 5);
			}
		if((x>X[1][2] && y>Y[1][2]) && (x<X[2][3] && y<Y[2][3])){
			reverseImg(X[1][2], Y[1][2], 6);
			}
		if((x>X[1][3] && y>Y[1][3]) && (x<X[2][4] && y<Y[2][4])){
			reverseImg(X[1][3], Y[1][3], 7);
			}
		if((x>X[2][0] && y>Y[2][0]) && (x<X[3][1] && y<Y[3][1])){
			reverseImg(X[2][0], Y[2][0], 8);
			}
		if((x>X[2][1] && y>Y[2][1]) && (x<X[3][2] && y<Y[3][2])){
			reverseImg(X[2][1], Y[2][1], 9);
			}
		if((x>X[2][2] && y>Y[2][2]) && (x<X[3][3] && y<Y[3][3])){
			reverseImg(X[2][2], Y[2][2], 10);
			}
		if((x>X[2][3] && y>Y[2][3]) && (x<X[3][4] && y<Y[3][4])){
			reverseImg(X[2][3], Y[2][3], 11);
			}
		if((x>X[3][0] && y>Y[3][0]) && (x<X[4][1] && y<Y[4][1])){
			reverseImg(X[3][0], Y[3][0], 12);
			}
		if((x>X[3][1] && y>Y[3][1]) && (x<X[4][2] && y<Y[4][2])){
			reverseImg(X[3][1], Y[3][1], 13);
			}
		if((x>X[3][2] && y>Y[3][2]) && (x<X[4][3] && y<Y[4][3])){
			reverseImg(X[3][2], Y[3][2], 14);
			}
		if((x>X[3][3] && y>Y[3][3]) && (x<X[4][4] && y<Y[4][4])){
			reverseImg(X[3][3], Y[3][3], 15);
			}
		}
	}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}

//--------------------------------------------------------------------------------------------------
JLabel lTitle;
JButton bImage, bStartGame;
JComboBox boxLevel;

ImageIcon[] images= new ImageIcon[16];
String[] imgNames= new String[16];
int varX=230, varY=230, varImg=15, difficultyLevel=5;
int X[][]= new int[5][5];
int Y[][]= new int[5][5];
}