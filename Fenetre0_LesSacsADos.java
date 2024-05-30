import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;


public class Fenetre0_LesSacsADos extends JFrame implements ActionListener
{
	public static int nobj1 = 10; // -- nombre d'objoets dans csv1
	public static int nobj2 = 20; // -- nombre d'objoets dans csv2
	public static int nobj3 = 50; // -- nombre d'objoets dans csv3
	
	public static int nobj = 0; 	// la variable qu'on va utiliser dans les algo,
									//	une fois choisie c bon !
	
	
	public static int[][] objet;
	
	public static int CSV;			// determiner le fichier a choisir 
	
	
	public static int Nombre_SacsADos= 0;
	
	public static int[] poidsDesSacs = new int[10] ;
	
	public static int CondValeur;
	
	
	private static final long serialVersionUID = 1L;
	
	//les bouttons sont des varibales GLOBALES ! (using 'em in action listener!)
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	
	JRadioButton CSV1_button = new JRadioButton();
    JRadioButton CSV2_button = new JRadioButton();
    JRadioButton CSV3_button = new JRadioButton();
    
	
	
	
	Fenetre0_LesSacsADos()
	{
		
		super();
		
		// JFrame = une interface graphique pour y ajouter des composants
		
		//JFrame frame = new JFrame(); //creation de l'interface (depuis le main seuelement)
		
		//ajoueter une label :
		
		//-------------------- Label 1 -------------------------
		
		JLabel label1 = new JLabel();
		
		label1.setText("RECHERCHE BASEE ESPACE DES SOLUTIONS");
		label1.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
		label1.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
		label1.setForeground(new Color(0x800080));
		label1.setFont(new Font("MV BOLI",Font.BOLD ,20));
		
		// Définir la position et la taille de label1
        label1.setBounds(180, 10, 650 , 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
		
        

		//-------------------- Label 12 -------------------------
		
        JLabel label12 = new JLabel();
  		
      	label12.setText("(Nombre de sacs a dos une fois choisi, devient fix durant tous les traitements)");
      	label12.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label12.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label12.setForeground(new Color(0xffffff));
      	label12.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label12.setBounds(50, 80, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		

        //-------------------- Label 2 -------------------------
		
      	JLabel label2 = new JLabel();
      		
      	label2.setText("(La valeur maximale et le poids minimal sont aussi fixes)");
      	label2.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label2.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label2.setForeground(new Color(0xffffff));
      	label2.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label2.setBounds(50, 110, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              

        
        //-------------------- Label 2 - 3 intermediaire -------------------------
		
      	JLabel label23 = new JLabel();
      		
      	label23.setText("Selectionner un fichier CSV : ");
      	label23.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label23.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label23.setForeground(new Color(0xffffff));
      	label23.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label23.setBounds(50, 160, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              

        
        
        //-------------------- Label 3 -------------------------
		
      	JLabel label3 = new JLabel();
      		
      	label3.setText("- Nombre d'objets dans le fichier CSV1 = 10");
      	label3.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label3.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label3.setForeground(new Color(0xffffff));
      	label3.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label3.setBounds(50, 200, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              

        
        
        //-------------------- Label 4 -------------------------
		
      	JLabel label4 = new JLabel();
      		
      	label4.setText("- Nombre d'objets dans le fichier CSV2 = 20");
      	label4.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label4.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label4.setForeground(new Color(0xffffff));
      	label4.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label4.setBounds(50, 230, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              
        //-------------------- Label 5 -------------------------
		
      	JLabel label5 = new JLabel();
      		
      	label5.setText("- Nombre d'objets dans le fichier CSV3 = 50");
      	label5.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label5.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label5.setForeground(new Color(0xffffff));
      	label5.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label5.setBounds(50, 270, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              

        
        
        
        
        // -------------------- Boutton de Validation 1 -------------------------
        
        //implementer as une variable globale
        //JButton button1 = new JButton(); 
        
        button1.setBounds(300,450,100,40);
        //button1.addActionListener(this); //on va remplacer this par lambda expression
		button1.setEnabled(false); // desactiver le boutton jusqu'a choisir une option

        // LAMBDA EXPRESISON de Boutton 1:
        button1.addActionListener
        ( 
        	e -> 
        	{ 
    			
    			button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus
    			//labelX.setVisible(true); //si on veut faire apparaitre du texte apres le click
    			
    			//-------------------- boite de dialogue  1: NOMBRE DE SACS A DOS -------------------------
    	        
    	        // ** NOMBRE DE SACS A DOS :
    			do 
    			{
    			    String answer = JOptionPane.showInputDialog("Combien de sacs à dos disposez-vous ? (MAX 10)");
    			    
    			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
    			    if (answer == null) 
    			    {
    			        System.exit(0);
    			    }
    			    
    			    
    			    // verif si l'utilisateur a fait introduire une valeur valide !
    			    try 
    			    {
    			        Nombre_SacsADos = Integer.parseInt(answer);
    			    
    			    }
    			    catch (NumberFormatException ee) 
    			    {
    			        Nombre_SacsADos = -1; // Valeur invalide
    			    }
    			    
    			    // Vérifier si la valeur est dans la plage valide (1 à 10)
    			    if (Nombre_SacsADos <= 0 || Nombre_SacsADos > 10) 
    			    {
    			    	
    			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 10 !");
    			    }
    			    
    			    
    			} while (Nombre_SacsADos <= 0 || Nombre_SacsADos > 10);
    	        
    	        
    	        // ** POIDS DE CHAQUE SACS A DOS :
    	        System.out.println("Vous avez choisi : "+Nombre_SacsADos+" sac(s) !");
    	        
    	        for (int i=1; i<=Nombre_SacsADos; i++) 
    	        {
    	        	String poids = JOptionPane.showInputDialog("Veuillez introduire la capacite du sac Numero "+i+" :");
    	            
    	        	//int Poids_Un_Sac = 0;
    	        	poidsDesSacs[i-1] = Integer.parseInt(poids);
    	            //System.out.println("Poids du sac "+i+" est : "+ poidsDesSacs[i-1]+" Kg.");
    	            
    	        }
    	        
    	        
    			// Verifier si le tableau Nombre_SacADos est bien rempli :
    	        for (int i=1; i<=Nombre_SacsADos; i++) 
    	        {
    	            System.out.println("Capacite du sac "+i+" est : "+ poidsDesSacs[i-1]+" Kg.");
    	        }
    	        
    	        
    	        
    			//REDIRECTION VERS LA 2EME PAGE (correspondante a l'algorithme choisi):
    			Fenetre1_ChoisirAlgorithme page1 = new Fenetre1_ChoisirAlgorithme();
    			
    		}
        );
        
        
        
        
        
        button1.setText("Suivant !");
        button1.setFocusable(rootPaneCheckingEnabled);
        button1.setFont(new Font("Comic Sans",Font.BOLD ,16));
        button1.setForeground(new Color (0xffffff)); //clr du texte
        button1.setBackground(new Color(0x803A93));  //clr du boutton
        button1.setBorder(BorderFactory.createEtchedBorder()); //effet 3D du boutton
        // le boutton est grisé jusqu'à ce que choix de l'algorithme soit fait !
        //button1.setEnabled(false);
        
        
        
        // -------------------- Boutton d'Annulation 2 -------------------------
        
        
        
        button2.setBounds(500,450,100,40);
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
        

        
        //-------------------- Frame -------------------------
        
        this.setLayout(null); //libel fixe !

		this.setTitle("choix CSV"); 
		
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

		
		
		
		
		// -------------------- Boutton RADIO 1 -------------------------

        
		
		CSV1_button.setBounds(180, 380, 100, 40);
        CSV1_button.setText("CSV1");
        CSV1_button.addActionListener(this);
        CSV1_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        CSV1_button.setForeground(new Color (0xffffff)); //clr du texte
        CSV1_button.setBackground(new Color(0,0,0)); //(background)
		
        
        CSV2_button.setBounds(330, 380, 100, 40);
        CSV2_button.setText("CSV2");
        CSV2_button.addActionListener(this);
        CSV2_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        CSV2_button.setForeground(new Color (0xffffff)); //clr du texte
        CSV2_button.setBackground(new Color(0,0,0)); //(background)
		
        
        CSV3_button.setBounds(480, 380, 100, 40);
        CSV3_button.setText("CSV3");
        CSV3_button.addActionListener(this);
        CSV3_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        CSV3_button.setForeground(new Color (0xffffff)); //clr du texte
        CSV3_button.setBackground(new Color(0,0,0)); //(background)
		
        
        
		// pour choisir une seul element a la fois :
        ButtonGroup group = new ButtonGroup();
        
        group.add(CSV1_button);
        group.add(CSV2_button);
        group.add(CSV3_button);
		
		
		
		
		//-------------------- **** -------------------------
		
		
		this.add(label1);
		this.add(label12);
		this.add(label2);
		this.add(label23);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		
		this.add(CSV1_button);
		this.add(CSV2_button);
		this.add(CSV3_button);
				
		this.add(button1);
		this.add(button2);

		
	
		
		
	}

	
	
	
	// -------------------  RADIO button 1 ActionListener--------------------------------------------------
	
	@Override
	public void actionPerformed (ActionEvent e)
	{
		 if (e.getSource() == CSV1_button) 
		 {
			 
			 CSV = 1;
			 
			 /*    EXTRAIRE LES DONNEES CSV	1  */
				nobj = nobj1;
				objet = new int[nobj][2];
				
				objet = File.ExtractData1(nobj, "src\\Objets.csv");

		        
				// -- verifier si la matrice des objets est bien remplie : 
				System.out.println("\nla liste des objets contient (Main) :");
		        
				for (int i = 0; i < nobj; i++) 
		        {
		     	    System.out.println(objet[i][0] + " " + objet [i][1]);
		     	}
				
				
			 button1.setEnabled(true);
			 
			 
	     }
		 else
		 {
			 if (e.getSource() == CSV2_button)
			 {
				 CSV = 2 ;
				 
				 /*    EXTRAIRE LES DONNEES CSV 2  */
				 nobj = nobj2;
				 objet = new int[nobj][2];
				
				 objet = File.ExtractData1(nobj, "src\\Objets2.csv");

			        
					// -- verifier si la matrice des objets est bien remplie : 
				 System.out.println("\nla liste des objets contient (Main) :");
		        
				 for (int i = 0; i < nobj; i++) 
				 {
					 System.out.println(objet[i][0] + " " + objet [i][1]);
				 }
					
					
				 button1.setEnabled(true);
				 
			 }
			 else 
			 {
				 if (e.getSource() == CSV3_button)
				 {
					CSV = 3;
					
					/*    EXTRAIRE LES DONNEES CSV	*/
					nobj = nobj3;
					objet = new int[nobj][2];
					
					objet = File.ExtractData1(nobj, "src\\Objets3.csv");

			        
					// -- verifier si la matrice des objets est bien remplie : 
					System.out.println("\nla liste des objets contient (Main) :");
			        
					for (int i = 0; i < nobj; i++) 
			        {
			     	    System.out.println(objet[i][0] + " " + objet [i][1]);
			     	}
					
					button1.setEnabled(true);
					
				}
			 }
		 }
	}
	
	
	
	
}
