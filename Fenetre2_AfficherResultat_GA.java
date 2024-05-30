import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/* Nombre total des sac a dos est stocké dans : 
 * 			
 * 					public int Nombre_SacsADos ;
  			-----------------------------------------------
 * poids des sac a dos sont stockés dans : 	
 * 
 * 				public int[] poidsDesSacs = new int[10] ;
*/


public class Fenetre2_AfficherResultat_GA extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	//les bouttons sont des varibales GLOBALES ! (action listener!)
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	
	/*public int Nombre_SacsADos = 0;
	public int[] poidsDesSacs = new int[10] ;
	*/
	
	Fenetre2_AfficherResultat_GA()
	{
		
		super();
		
		// JFrame = une interface graphique pour y ajouter des composants
		
		//JFrame frame = new JFrame(); //creation de l'interface (depuis le main seuelement)
		
		//ajoueter une label :
		
		//-------------------- Label 1 -------------------------
		
		JLabel label1 = new JLabel();
		
		label1.setText("Vous avez choisi l'algorithme : GA !");
		label1.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
		label1.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
		label1.setForeground(new Color(0x800080));
		label1.setFont(new Font("MV BOLI",Font.BOLD ,20));
		
		// Définir la position et la taille de label1
        label1.setBounds(100, 10, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
		
        
        
        //-------------------- Label 2 -------------------------
		
      	JLabel label2 = new JLabel();
      		
      	label2.setText("Valeur maximale totale : " + LancerTraitementGA.VALEURMAXIMALEGA);
      	label2.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label2.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label2.setForeground(new Color(0xffffff));
      	label2.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label2.setBounds(50, 100, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              
        //-------------------- Label 3 -------------------------
		
      	JLabel label3 = new JLabel();
      		
      	label3.setText("Nombre de noeuds exploité : "+ LancerTraitementGA.NOEUDSGA);
      	label3.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label3.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label3.setForeground(new Color(0xffffff));
      	label3.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label31
        label3.setBounds(50, 150, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              
//-------------------- Label 4 -------------------------
		
      	JLabel label4 = new JLabel();
      		
      	label4.setText("Temps d'executions : "+LancerTraitementGA.executionTimeInSeconds_GA);
      	label4.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label4.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label4.setForeground(new Color(0xffffff));
      	label4.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label4.setBounds(50, 180, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              

              
        
        // -------------------- Boutton de Validation 1 -------------------------
        
        //implementer as une variable globale
        //JButton button1 = new JButton(); 
        
        button1.setBounds(500,400,100,40);
        //button1.addActionListener(this); //on va remplacer this par lambda expression
        
        // LAMBDA EXPRESISON de Boutton 1:
        button1.addActionListener
        ( 
        	e -> 
        	{
    			//System.out.println("Algo bien choisi !"); 
    			
    			button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus
    			//labelX.setVisible(true); //si on veut faire apparaitre du texte apres le click
    			
    			
    			// REDIRECTION VERS LA Page suivante :
    			
    			Fenetre1_ChoisirAlgorithme page3 = new Fenetre1_ChoisirAlgorithme();
    			
    			
    		}
        );
        
        button1.setText("OK");
        button1.setFocusable(rootPaneCheckingEnabled);
        button1.setFont(new Font("Comic Sans",Font.BOLD ,16));
        button1.setForeground(new Color (0xffffff)); //clr du texte
        button1.setBackground(new Color(0x803A93));  //clr du boutton
        button1.setBorder(BorderFactory.createEtchedBorder()); //effet 3D du boutton
        // le boutton est grisé jusqu'à ce que choix de l'algorithme soit fait !
        //button1.setEnabled(false);
        

        
// -------------------- Boutton d'Annulation 2 -------------------------
        
        
        
        button2.setBounds(500,350,100,40);
        //button1.addActionListener(this); //on va remplacer this par lambda expression
        
        // LAMBDA EXPRESISON de Boutton 1:
        button2.addActionListener
        ( 
        	e -> 
        	{
        		System.exit(0);
    			
    		}
        );
        
        button2.setText("Quitter");
        button2.setFocusable(rootPaneCheckingEnabled);
        button2.setFont(new Font("Comic Sans",Font.BOLD ,16));
        button2.setForeground(new Color (0xffffff)); //clr du texte
        button2.setBackground(new Color(0xff0000));  //clr du boutton
        button2.setBorder(BorderFactory.createEtchedBorder()); //effet 3D du boutton
        // le boutton est grisé jusqu'à ce que choix de l'algorithme soit fait !
        //button2.setEnabled(false);
        

          	
          
        //-------------------- Frame : -------------------------
        
        this.setLayout(null); //libel fixe !

		this.setTitle("GA"); //1ere interface est pour choisir l'algorithme !
		
		//frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // hide pour cacher, mais le programme ne se termine pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit = sortit et quitter !
		
		
		// Utilisation du BorderLayout pour positionner la Label au centre
		/*this.setLayout(new BorderLayout());
        this.add(label1, BorderLayout.CENTER);*/
        
		//frame.setResizable(false); 	//l'interface est non redimmensionnable !
		
		this.setSize(800,600); 	// REDIMENSIONNER l'interface ! 
		this.setVisible(true);   	// redre l'interface visible !
		
		//ajouter une icone à l'interface :
		ImageIcon img = new ImageIcon("logo.jpg"); 	// creer une image
		this.setIconImage(img.getImage());			// et l'xappliquer !
		
		//changer les couleurs de l'interface :
		this.getContentPane().setBackground(new Color(0,0,0)); //(background)

		
		
		
		//-------------------- **** -------------------------

		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		
		int l = 0;
		if (l<=Fenetre0_LesSacsADos.Nombre_SacsADos)
		{
		    
			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }

			//-------------------- Label 50 -------------------------
			
	      	JLabel label50 = new JLabel();
	      	
	      	
	      	
	      	label50.setText("Sac 1 : poids = "+LancerTraitementGA.poid_actualeGA[0] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[0]+" | objets : "+AfficherListeGA);
	      	label50.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
	      	label50.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
	      	label50.setForeground(new Color(0xffffff));
	      	label50.setFont(new Font("Inter",Font.BOLD ,16));
	      		
	      	// Définir la position et la taille de label1
	        label50.setBounds(50, 210, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
	      		
	              
	             
			this.add(label50);
			l++;
		}
		if (l<=Fenetre0_LesSacsADos.Nombre_SacsADos)
		{
			
			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			
			//-------------------- label51 -------------------------
			
	      	JLabel label51 = new JLabel();
	      		
	      	label51.setText("Sac 2 : poids = "+LancerTraitementGA.poid_actualeGA[1] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[1]+" | objets : "+AfficherListeGA);	      	
	      	label51.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
	      	label51.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
	      	label51.setForeground(new Color(0xffffff));
	      	label51.setFont(new Font("Inter",Font.BOLD ,16));
	      		
	      	// Définir la position et la taille de label1
	        label51.setBounds(50, 240, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
	      		
	              
	            
			
			this.add(label51);
			l++;
		}
		
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{
			
			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			//-------------------- label52 -------------------------
			
	      	JLabel label52 = new JLabel();
	      		
	      	label52.setText("Sac 3 : poids = "+LancerTraitementGA.poid_actualeGA[2] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[2]+" | objets : "+AfficherListeGA);
	      	label52.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
	      	label52.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
	      	label52.setForeground(new Color(0xffffff));
	      	label52.setFont(new Font("Inter",Font.BOLD ,16));
	      		
	      	// Définir la position et la taille de label1
	        label52.setBounds(50, 270, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
	      		
	              
	           
	        
			this.add(label52);
			l++;
		}
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{
			

			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			
            
            
			//-------------------- label53 -------------------------
					
			      	JLabel label53 = new JLabel();
			      		
			      	label53.setText("Sac 4 : poids = "+LancerTraitementGA.poid_actualeGA[3] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[3]+" | objets : "+AfficherListeGA);			    
			      	label53.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label53.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
			      	label53.setForeground(new Color(0xffffff));
			      	label53.setFont(new Font("Inter",Font.BOLD ,16));
			      		
			      	// Définir la position et la taille de label1
			        label53.setBounds(50, 300, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
			      		
			              
			              
			this.add(label53);
			l++;
		}
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{

			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			

            
            
			//-------------------- label54 -------------------------
					
			      	JLabel label54 = new JLabel();
			      		
			      	label54.setText("Sac 5 : poids = "+LancerTraitementGA.poid_actualeGA[4] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[4]+" | objets : "+AfficherListeGA);			    
			      	label54.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label54.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
			      	label54.setForeground(new Color(0xffffff));
			      	label54.setFont(new Font("Inter",Font.BOLD ,16));
			      		
			      	// Définir la position et la taille de label1
			        label54.setBounds(50, 330, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
			      		
			              
			              
			
			this.add(label54);
			l++;
		}
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{
			


			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			
			//-------------------- label55 -------------------------
					
			      	JLabel label55 = new JLabel();
			      		
			      	label55.setText("Sac 5 : poids = "+LancerTraitementGA.poid_actualeGA[5] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[5]+" | objets : "+AfficherListeGA);			     
			      	label55.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label55.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label55.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
			      	label55.setForeground(new Color(0xffffff));
			      	label55.setFont(new Font("Inter",Font.BOLD ,16));
			      		
			      	// Définir la position et la taille de label1
			        label55.setBounds(50, 360, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
			      		
			              
			             
			
			this.add(label55);
			l++;
		}
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{
			

			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			
			//-------------------- label56 -------------------------
					
			      	JLabel label56 = new JLabel();
			      		
			      	label56.setText("Sac 7 : poids = "+LancerTraitementGA.poid_actualeGA[6] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[6]+" | objets : "+AfficherListeGA);
			      	label56.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label56.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
			      	label56.setForeground(new Color(0xffffff));
			      	label56.setFont(new Font("Inter",Font.BOLD ,16));
			      		
			      	// Définir la position et la taille de label1
			        label56.setBounds(50, 390, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
			      		
			              
			    
			
			this.add(label56);
			l++;
		}
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{

			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			
	          
			//-------------------- label57 -------------------------
					
			      	JLabel label57 = new JLabel();
			      		
			      	label57.setText("Sac 8 : poids = "+LancerTraitementGA.poid_actualeGA[7] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[7]+" | objets : "+AfficherListeGA);
			      	label57.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label57.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
			      	label57.setForeground(new Color(0xffffff));
			      	label57.setFont(new Font("Inter",Font.BOLD ,16));
			      		
			      	// Définir la position et la taille de label1
			        label57.setBounds(50, 420, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
			      		
			              
			    
			
			this.add(label57);
			l++;
		}
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{

			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			
	          
			//-------------------- label58 -------------------------
					
			      	JLabel label58 = new JLabel();
			      		
			      	label58.setText("Sac 9 : poids = "+LancerTraitementGA.poid_actualeGA[8] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[8]+" | objets : "+AfficherListeGA);
			      	label58.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label58.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
			      	label58.setForeground(new Color(0xffffff));
			      	label58.setFont(new Font("Inter",Font.BOLD ,16));
			      		
			      	// Définir la position et la taille de label1
			        label58.setBounds(50, 450, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
			      		
			    
			
			this.add(label58);
			l++;
		}
		if (l<Fenetre0_LesSacsADos.Nombre_SacsADos)
		{
			

			List<Integer> AfficherListeGA = new ArrayList<>();
			
			for (int j = 0; j < LancerTraitementGA.matriceGA[l].length; j++) 
            {
         	
     		   if(LancerTraitementGA.matriceGA[l][j]==1) 
         	   {
         		  
         		   //System.out.printf(" objet%d ",(j+1));
         		   AfficherListeGA.add(j+1);
         		  
         		   
         	   }
            }
			
            
			//-------------------- label59 -------------------------
					
			      	JLabel label59 = new JLabel();
			      		
			      	label59.setText("Sac 10 : poids = "+LancerTraitementGA.poid_actualeGA[9] + " | capacite = "+Fenetre0_LesSacsADos.poidsDesSacs[9]+" | objets : "+AfficherListeGA);
			      	label59.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
			      	label59.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
			      	label59.setForeground(new Color(0xffffff));
			      	label59.setFont(new Font("Inter",Font.BOLD ,16));
			      		
			      	// Définir la position et la taille de label1
			        label59.setBounds(50, 480, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
			      		
			    
			
			this.add(label59);
			l++;
		}
		
        
            
		
		
		
		this.add(button1);
		this.add(button2);
	
		
		
	}

	
	/* remplacer par la "LAMBDA EXPRESSION" dans la partie boutton1 :
	// Action Listener du boutton1 :
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource()==button1)
		{
			System.out.println("Algo bien choisi !"); 
			
			button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus
			//labelX.setVisible(true); //si on veut faire apparaitre du texte apres le click
		}
		
	}*/
	
	
	
	
	
	
}
