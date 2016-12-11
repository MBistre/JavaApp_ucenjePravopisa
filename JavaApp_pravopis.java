import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Igra extends java.applet.Applet implements ActionListener{
	
private static final long serialVersionUID = 1L;
	
	Button b1cc, b2cc, b1ijeje, b2ijeje, cc, ijeje;
	
	ArrayList tocnoCC, netocnoCC, tocnoIJEJE, netocnoIJEJE;
	
	Random randomGenerator = new Random();
	Random random;
	
	int brojRijeciTCC, brojRijeciNCC, brojRijeciTIJEJE, brojRijeciNIJEJE;
	int trenutnaRijecCC, trenutnaRijecIJEJE;
	int brT, brN;
	int odabirIgre;
	
	Object ispisTCC, ispisNCC, ispisTIJEJE, ispisNIJEJE;
	
	boolean izbor, istoCC1, istoCC2, istoIJEJE1, istoIJEJE2, ponovi;
	
	static String linija;
	
	Font naslov = new Font("Arial", Font.BOLD, 24);
	Font tekst = new Font("Arial", Font.PLAIN, 18);
	
	public void init()
	{
		
		b1cc = new Button();
		b2cc = new Button();
		b1ijeje =new Button();
		b2ijeje = new Button();
		cc = new Button();
		ijeje = new Button();
	    
	    add(cc);
		add(ijeje);	
		
		b1cc.addActionListener(this);
		b2cc.addActionListener(this);
		b1ijeje.addActionListener(this);
		b2ijeje.addActionListener(this);
		cc.addActionListener(this);
		ijeje.addActionListener(this);
		
		tocnoCC=new ArrayList();
		netocnoCC=new ArrayList();
		tocnoIJEJE=new ArrayList();
		netocnoIJEJE=new ArrayList();
		
		
		
		
		//CITANJE IZ DATOTEKE
		//È i Æ
		try {
			FileInputStream myfile = new FileInputStream("TocnoCC.txt");
			BufferedReader p = new BufferedReader(new InputStreamReader(myfile));
			
			if(p.ready()==true)
			{
				while((linija=p.readLine())!=null)
				{
					tocnoCC.add(linija);
				}
			}
			
			p.close();
			myfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream myfile = new FileInputStream("NetocnoCC.txt");
			BufferedReader p = new BufferedReader(new InputStreamReader(myfile));
			
			if(p.ready()==true)
			{
				while((linija=p.readLine())!=null)
				{
					netocnoCC.add(linija);
				}
			}
			
			p.close();
			myfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//IJE i JE
		try {
			FileInputStream myfile = new FileInputStream("TocnoIJEJE.txt");
			BufferedReader p = new BufferedReader(new InputStreamReader(myfile));
			
			if(p.ready()==true)
			{
				while((linija=p.readLine())!=null)
				{
					tocnoIJEJE.add(linija);
				}
			}
			
			p.close();
			myfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream myfile = new FileInputStream("NetocnoIJEJE.txt");
			BufferedReader p = new BufferedReader(new InputStreamReader(myfile));
			
			if(p.ready()==true)
			{
				while((linija=p.readLine())!=null)
				{
					netocnoIJEJE.add(linija);
				}
			}
			
			p.close();
			myfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		brojRijeciTCC=tocnoCC.size();
		brojRijeciTIJEJE=tocnoIJEJE.size();
		brojRijeciNCC=netocnoCC.size();
		brojRijeciNIJEJE=netocnoIJEJE.size();
		
		trenutnaRijecCC = randomGenerator.nextInt(brojRijeciTCC);
		trenutnaRijecIJEJE = randomGenerator.nextInt(brojRijeciTIJEJE);
		
		brT=0;
		brN=0;
		
		random = new Random();
	}
	
	public void paint(Graphics g)
	{
		//Poèetni ekran
		
		g.setFont(naslov);
		g.setColor(Color.black);
		g.drawString("GRAMATIKA", 100, 50);
		
		ijeje.setLabel("IJE / JE");
		cc.setLabel("È / Æ");
		
		cc.setSize(100,100);
		ijeje.setSize(100,100);
		
		cc.setLocation(50,100);
		ijeje.setLocation(200,100);
		
		
		// ODABRANA IGRA È I Æ
		if(odabirIgre==1)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setFont(naslov);
			g.setColor(Color.black);
			g.drawString("È / Æ", 150, 50);
			boolean izbor = random.nextBoolean();
			
			ispisTCC=tocnoCC.get(trenutnaRijecCC);
			ispisNCC=netocnoCC.get(trenutnaRijecCC);
			
			
			if(izbor)
			{
				b1cc.setLabel(""+ispisTCC);
				b2cc.setLabel(""+ispisNCC);
			}
			else
			{
				b1cc.setLabel(""+ispisNCC);
				b2cc.setLabel(""+ispisTCC);
			}
			
			g.setFont(tekst);
			g.setColor(Color.gray);
			g.drawString("Tocno: " + brT, 400,50);
			g.drawString("Netocno: " + brN, 400, 70);
		}
		
		//ODABRANA IGRA IJE I JE
		else if(odabirIgre==2)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setFont(naslov);
			g.setColor(Color.black);
			g.drawString("IJE / JE", 150, 50);
			boolean izbor = random.nextBoolean();
			
			ispisTIJEJE=tocnoIJEJE.get(trenutnaRijecIJEJE);
			ispisNIJEJE=netocnoIJEJE.get(trenutnaRijecIJEJE);
			
			if(izbor)
			{
				b1ijeje.setLabel(""+ispisTIJEJE);
				b2ijeje.setLabel(""+ispisNIJEJE);
			}
			else
			{
				b1ijeje.setLabel(""+ispisNIJEJE);
				b2ijeje.setLabel(""+ispisTIJEJE);
			}
			
			g.setFont(tekst);
			g.setColor(Color.gray);
			g.drawString("Tocno: " + brT, 400,50);
			g.drawString("Netocno: " + brN, 400, 70);
		}
	}


	public void actionPerformed(ActionEvent e) 
	{
		Graphics g = getGraphics();
		
		// ODABIR IGRE
		if(e.getSource() == cc)
		{
			odabirIgre = 1;
			
			remove(cc);
			remove(ijeje);
			add(b1cc);
			add(b2cc);
			
			b1cc.setSize(100,30);
			b2cc.setSize(100,30);
			
			b1cc.setLocation(50,100);
			b2cc.setLocation(200,100);
		}
		
		else if(e.getSource() == ijeje)
		{
			odabirIgre = 2;
			
			remove(cc);
			remove(ijeje);
			add(b1ijeje);
			add(b2ijeje);
			
			b1ijeje.setSize(100,30);
			b2ijeje.setSize(100,30);
			
			b1ijeje.setLocation(50,100);
			b2ijeje.setLocation(200,100);
		}
		
		
		// È / Æ
		
		if(e.getSource() == b1cc)
		{
			istoCC1=b1cc.getLabel().equals(tocnoCC.get(trenutnaRijecCC));
			
			if(istoCC1)
			{
				brT++;
			}
			else
			{
				brN++;
			}

			if(brojRijeciTCC<=1 && brojRijeciNCC<=1)
			{
				g.setColor(Color.white);
				g.fillRect(0,0,getWidth(),getHeight());
				remove(b1cc);
				remove(b2cc);
				g.setFont(naslov);
				g.setColor(Color.black);
				g.drawString("Igra je gotova.", 50, 50);
				g.drawString("Vaš reuzltat je: " + brT + "/10", 50, 100);
			}
			else
			{			
				tocnoCC.remove(trenutnaRijecCC);
				netocnoCC.remove(trenutnaRijecCC);
				brojRijeciTCC--;
				brojRijeciNCC--;
				trenutnaRijecCC = randomGenerator.nextInt(brojRijeciTCC);
				
				repaint();
			}
			
		}
		else if(e.getSource() == b2cc)
		{
			istoCC2=b2cc.getLabel().equals(tocnoCC.get(trenutnaRijecCC));
			
			if(istoCC2)
			{
				brT++;
			}
			else
			{
				brN++;
			}

			if(brojRijeciTCC<=1 && brojRijeciNCC<=1)
			{
				g.setColor(Color.white);
				g.fillRect(0,0,getWidth(),getHeight());
				remove(b1cc);
				remove(b2cc);
				g.setFont(naslov);
				g.setColor(Color.black);
				g.drawString("Igra je gotova.", 50, 50);
				g.drawString("Vaš reuzltat je: " + brT + "/10", 50, 100);
			}
			else
			{			
				tocnoCC.remove(trenutnaRijecCC);
				netocnoCC.remove(trenutnaRijecCC);
				brojRijeciTCC--;
				brojRijeciNCC--;
				trenutnaRijecCC = randomGenerator.nextInt(brojRijeciTCC);
				
				repaint();
			}
		}
		
		//IJE / JE
		
		if(e.getSource() == b1ijeje)
		{
			istoIJEJE1=b1ijeje.getLabel().equals(tocnoIJEJE.get(trenutnaRijecIJEJE));
			
			if(istoIJEJE1)
			{
				brT++;
			}
			else
			{
				brN++;
			}

			if(brojRijeciTIJEJE<=1 && brojRijeciNIJEJE<=1)
			{
				g.setColor(Color.white);
				g.fillRect(0,0,getWidth(),getHeight());
				remove(b1ijeje);
				remove(b2ijeje);
				g.setFont(naslov);
				g.drawString("Igra je gotova.", 50, 50);
				g.drawString("Vaš reuzltat je: " + brT + "/10", 50, 100);
			}
			else
			{			
				tocnoIJEJE.remove(trenutnaRijecIJEJE);
				netocnoIJEJE.remove(trenutnaRijecIJEJE);
				brojRijeciTIJEJE--;
				brojRijeciNIJEJE--;
				trenutnaRijecIJEJE = randomGenerator.nextInt(brojRijeciTIJEJE);
				
				repaint();
			}
			
		}
		else if(e.getSource() == b2ijeje)
		{
			istoIJEJE2=b2ijeje.getLabel().equals(tocnoIJEJE.get(trenutnaRijecIJEJE));
			
			if(istoIJEJE2)
			{
				brT++;
			}
			else
			{
				brN++;
			}

			if(brojRijeciTIJEJE<=1 && brojRijeciNIJEJE<=1)
			{
				g.setColor(Color.white);
				g.fillRect(0,0,getWidth(),getHeight());
				remove(b1ijeje);
				remove(b2ijeje);
				g.setFont(naslov);
				g.setColor(Color.black);
				g.drawString("Igra je gotova.", 50, 50);
				g.drawString("Vaš reuzltat je: " + brT + "/10", 50, 100);
			}
			else
			{			
				tocnoIJEJE.remove(trenutnaRijecIJEJE);
				netocnoIJEJE.remove(trenutnaRijecIJEJE);
				brojRijeciTIJEJE--;
				brojRijeciNIJEJE--;
				trenutnaRijecIJEJE = randomGenerator.nextInt(brojRijeciTIJEJE);
				
				repaint();
			}
		}
	}

}
