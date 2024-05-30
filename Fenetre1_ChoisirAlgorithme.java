import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class Fenetre1_ChoisirAlgorithme extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	//les bouttons sont des varibales GLOBALES ! (action listener!)
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	
	JRadioButton GA_button = new JRadioButton();
    JRadioButton BSO_button = new JRadioButton();
    JRadioButton A_button = new JRadioButton();
    
	
    
    
	public static int Numero_Algo = 0;
	
	public static int Nombre_Iteration= 0;
	
	public static int Nombre_Population= 0;
	
	public static int Nombre_Point_Croisement= 0;
	
	public static int Nombre_Flip= 0;
	
	public static int Nombre_Chance= 0;
	
	public static int Nombre_Bee= 0;
	
	public static int Nombre_Iterations_Locales = 0;
	
	
	
	Fenetre1_ChoisirAlgorithme()
	{
		
		super();
		
		
		//-------------------- Label 1 -------------------------
		
		JLabel label1 = new JLabel();
		
		label1.setText("CHOIX DE L'ALGORITHME");
		label1.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
		label1.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
		label1.setForeground(new Color(0x800080));
		label1.setFont(new Font("MV BOLI",Font.BOLD ,20));
		
		// Définir la position et la taille de label1
        label1.setBounds(100, 10, 600, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
		
        
        
        //-------------------- Label 2 -------------------------
		
      	JLabel label2 = new JLabel();
      		
      	label2.setText("Veuillez choisir l'algorithme à utiliser :");
      	label2.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label2.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label2.setForeground(new Color(0xffffff));
      	label2.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label2.setBounds(50, 100, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              
        // -------------------- Label 3 -------------------------
		
      	JLabel label3 = new JLabel();
      		
      	label3.setText("Veuillez patienter lors du traitement...");
      	label3.setHorizontalTextPosition(JLabel.CENTER); 	//LEFT CENTER RIGHT : position du text
      	label3.setVerticalTextPosition(JLabel.TOP);			// CENTER TOP BOTTOM
      	label3.setForeground(new Color(0xffffff));
      	label3.setFont(new Font("Inter",Font.BOLD ,16));
      		
      	// Définir la position et la taille de label1
        label3.setBounds(100, 250, 400, 100); // pos X - pos Y - largeur de la libel - hauteur de la libel 
      		
              
              

        
        
        // -------------------- Boutton de Validation 1 -------------------------
        
        //implementer as une variable globale
        //JButton button1 = new JButton(); 
        
        button1.setBounds(300,400,100,40);
        //button1.addActionListener(this); //on va remplacer this par lambda expression
		button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus

        // LAMBDA EXPRESISON de Boutton 1:
        button1.addActionListener
        ( 
        	e -> 
        	{
    			System.out.println("Algo bien choisi !"); 
    			
    			button1.setEnabled(false); // desactiver le boutton une fois cliquer dessus
    			//labelX.setVisible(true); //si on veut faire apparaitre du texte apres le click
    			
    			
    			int nsac = Fenetre0_LesSacsADos.Nombre_SacsADos;
    			int [] capacite = Fenetre0_LesSacsADos.poidsDesSacs;
    			
    				
    			//LANCEMENT du TRAITEMENT & REDIRECTION VERS LA 2EME PAGE (correspondante a l'algorithme choisi):
    			if (Numero_Algo == 1)
    			{
    				
    				//lancer GA
    				
    				
    				
    				
    				
    				//-------------------- boite de dialogue  1 : NOMBRE D'ITERATIONS -------------------------
        	        
        	        // ** NOMBRE D'ITERATIONS :
        			do 
        			{
        			    String answer = JOptionPane.showInputDialog("Nombre d'iteration :");
        			    
        			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
        			    if (answer == null) 
        			    {
        			        System.exit(0);
        			    }
        			    
        			    
        			    // verif si l'utilisateur a fait introduire une valeur valide !
        			    try 
        			    {
        			        Nombre_Iteration = Integer.parseInt(answer);
        			    
        			    }
        			    catch (NumberFormatException ee) 
        			    {
        			    	Nombre_Iteration = -1; // Valeur invalide
        			    }
        			    
        			    // Vérifier si la valeur est dans la plage valide (1 à 100000)
        			    if (Nombre_Iteration <= 0 || Nombre_Iteration > 100000) 
        			    {
        			    	
        			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100000 !");
        			    }
        			    
        			} while (Nombre_Iteration <= 0 || Nombre_Iteration > 100000);
        	        
        			
        			
        			
        			
        			//	-------------------- boite de dialogue  2 : Nombre_Population  -------------------------
        	        
        	        // ** NOMBRE de la POPULATION :
        			do 
        			{
        			    String answer = JOptionPane.showInputDialog("Nombre de la population :");
        			    
        			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
        			    if (answer == null) 
        			    {
        			        System.exit(0);
        			    }
        			    
        			    
        			    // verif si l'utilisateur a fait introduire une valeur valide !
        			    try 
        			    {
        			    	Nombre_Population = Integer.parseInt(answer);
        			    
        			    }
        			    catch (NumberFormatException ee) 
        			    {
        			    	Nombre_Population = -1; // Valeur invalide
        			    }
        			    
        			    // Vérifier si la valeur est dans la plage valide (1 à 100000)
        			    if (Nombre_Population <= 0 || Nombre_Population > 100000) 
        			    {
        			    	
        			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100000 !");
        			    }
        			    
        			    
        			} while (Nombre_Population <= 0 || Nombre_Population > 100000);
        	        
        	        
        			
        			
        			
        			
        			//	-------------------- boite de dialogue  3 : Nombre_Point_Croisement  -------------------------
        	        
        	        // ** NOMBRE de POINTS DE CROISEMENT :
        			do 
        			{
        			    String answer = JOptionPane.showInputDialog("Nombre de points de croisement :");
        			    
        			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
        			    if (answer == null) 
        			    {
        			        System.exit(0);
        			    }
        			    
        			    
        			    // verif si l'utilisateur a fait introduire une valeur valide !
        			    try 
        			    {
        			    	Nombre_Point_Croisement = Integer.parseInt(answer);
        			    
        			    }
        			    catch (NumberFormatException ee) 
        			    {
        			    	Nombre_Point_Croisement = -1; // Valeur invalide
        			    }
        			    
        			    // Vérifier si la valeur est dans la plage valide (1 à 100)
        			    if (Nombre_Point_Croisement <= 0 || Nombre_Point_Croisement > 100) 
        			    {
        			    	
        			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100 !");
        			    }
        			    
        			    
        			} while (Nombre_Point_Croisement <= 0 || Nombre_Point_Croisement > 100);
        	        
        	        
        			
        			
        			
        			
        	        
        	        //LANCER TRAITEMENT !
        	        LancerTraitementGA.TraitementGA(nsac, Fenetre0_LesSacsADos.nobj, capacite, Fenetre0_LesSacsADos.objet, Nombre_Iteration, Nombre_Population, Nombre_Point_Croisement);
    				
    				//REDIRECTION !
       				Fenetre2_AfficherResultat_GA page21 = new Fenetre2_AfficherResultat_GA();
        	        
        	        
            
      
       				

    			}
    			else
    			{
    				if (Numero_Algo == 2)
    				{
    					//lancer BSO:


    					//-------------------- boite de dialogue  4 : NOMBRE D'ITERATIONS -------------------------
            	        
            	        // ** NOMBRE D'ITERATIONS :
            			do 
            			{
            			    String answer = JOptionPane.showInputDialog("Nombre d'iteration :");
            			    
            			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
            			    if (answer == null) 
            			    {
            			        System.exit(0);
            			    }
            			    
            			    
            			    // verif si l'utilisateur a fait introduire une valeur valide !
            			    try 
            			    {
            			        Nombre_Iteration = Integer.parseInt(answer);
            			    
            			    }
            			    catch (NumberFormatException ee) 
            			    {
            			    	Nombre_Iteration = -1; // Valeur invalide
            			    }
            			    
            			    // Vérifier si la valeur est dans la plage valide (1 à 100000)
            			    if (Nombre_Iteration <= 0 || Nombre_Iteration > 100000) 
            			    {
            			    	
            			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100000 !");
            			    }
            			    
            			} while (Nombre_Iteration <= 0 || Nombre_Iteration > 100000);
            	        
            			
            			//-------------------- boite de dialogue  5 : NOMBRE de flip -------------------------
            	        
            	        // ** NOMBRE de FLIPS :
            			do 
            			{
            			    String answer = JOptionPane.showInputDialog("Nombre des flips :");
            			    
            			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
            			    if (answer == null) 
            			    {
            			        System.exit(0);
            			    }
            			    
            			    
            			    // verif si l'utilisateur a fait introduire une valeur valide !
            			    try 
            			    {
            			        Nombre_Flip = Integer.parseInt(answer);
            			    
            			    }
            			    catch (NumberFormatException ee) 
            			    {
            			    	Nombre_Flip = -1; // Valeur invalide
            			    }
            			    
            			    // Vérifier si la valeur est dans la plage valide (1 à 100000)
            			    if (Nombre_Flip <= 0 || Nombre_Flip > 100000) 
            			    {
            			    	
            			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100000 !");
            			    }
            			    
            			} while (Nombre_Flip <= 0 || Nombre_Flip > 100000);
            	        
            			
            			
    					
            			//	-------------------- boite de dialogue  6 : NOMBRE de Chances -------------------------
            	        
            	        // ** NOMBRE de Chances :
            			do 
            			{
            			    String answer = JOptionPane.showInputDialog("Nombre de chances :");
            			    
            			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
            			    if (answer == null) 
            			    {
            			        System.exit(0);
            			    }
            			    
            			    
            			    // verif si l'utilisateur a fait introduire une valeur valide !
            			    try 
            			    {
            			    	Nombre_Chance = Integer.parseInt(answer);
            			    
            			    }
            			    catch (NumberFormatException ee) 
            			    {
            			    	Nombre_Chance = -1; // Valeur invalide
            			    }
            			    
            			    // Vérifier si la valeur est dans la plage valide (1 à 100)
            			    if (Nombre_Chance <= 0 || Nombre_Chance > 100) 
            			    {
            			    	
            			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100 !");
            			    }
            			    
            			} while (Nombre_Chance <= 0 || Nombre_Chance > 100);
            	        
            			
            			
            			
            			//-------------------- boite de dialogue  7 : NOMBRE d'abeilles -------------------------
            	        
            	        // ** NOMBRE de Bees :
            			do 
            			{
            			    String answer = JOptionPane.showInputDialog("Nombre des abeilles :");
            			    
            			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
            			    if (answer == null) 
            			    {
            			        System.exit(0);
            			    }
            			    
            			    
            			    // verif si l'utilisateur a fait introduire une valeur valide !
            			    try 
            			    {
            			    	Nombre_Bee = Integer.parseInt(answer);
            			    
            			    }
            			    catch (NumberFormatException ee) 
            			    {
            			    	Nombre_Bee = -1; // Valeur invalide
            			    }
            			    
            			    // Vérifier si la valeur est dans la plage valide (1 à 100000)
            			    if (Nombre_Bee <= 0 || Nombre_Bee > 100000) 
            			    {
            			    	
            			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100000 !");
            			    }
            			    
            			} while (Nombre_Bee <= 0 || Nombre_Bee > 100000);
            	        
            			
            			

            			//-------------------- boite de dialogue  8 : nombre iterations locales -------------------------
            	        
            	        // **  nombre iterations locales :
            			do 
            			{
            			    String answer = JOptionPane.showInputDialog("Nombre des iterations locales :");
            			    
            			    // Vérifier si l'utilisateur a cliqué sur Annuler ou a fermé la boîte de dialogue
            			    if (answer == null) 
            			    {
            			        System.exit(0);
            			    }
            			    
            			    
            			    // verif si l'utilisateur a fait introduire une valeur valide !
            			    try 
            			    {
            			    	Nombre_Iterations_Locales = Integer.parseInt(answer);
            			    
            			    }
            			    catch (NumberFormatException ee) 
            			    {
            			    	Nombre_Iterations_Locales = -1; // Valeur invalide
            			    }
            			    
            			    // Vérifier si la valeur est dans la plage valide (1 à 100000)
            			    if (Nombre_Iterations_Locales <= 0 || Nombre_Iterations_Locales > 100000) 
            			    {
            			    	
            			        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entre 1 et 100000 !");
            			    }
            			    
            			} while (Nombre_Iterations_Locales <= 0 || Nombre_Iterations_Locales > 100000 || Nombre_Iterations_Locales > Nombre_Bee );
            	        
            			
            			
        				
        				
        				// Lancement: 
           				LancerTraitementBSO.TraitementBSO(nsac, Fenetre0_LesSacsADos.nobj, capacite, Fenetre0_LesSacsADos.objet, Nombre_Iteration, Nombre_Iterations_Locales, Nombre_Bee, Nombre_Chance, Nombre_Flip);
           				
        				// Redirection :
            			Fenetre2_AfficherResultat_BSO page22 = new Fenetre2_AfficherResultat_BSO();

    				}
    			}
    			
    		}
        );
        
        button1.setText("Valider");
        button1.setFocusable(rootPaneCheckingEnabled);
        button1.setFont(new Font("Comic Sans",Font.BOLD ,16));
        button1.setForeground(new Color (0xffffff)); //clr du texte
        button1.setBackground(new Color(0x803A93));  //clr du boutton
        button1.setBorder(BorderFactory.createEtchedBorder()); //effet 3D du boutton
        // le boutton est grisé jusqu'à ce que choix de l'algorithme soit fait !
        //button1.setEnabled(false);
        
        
        
// -------------------- Boutton d'Annulation 2 -------------------------
        
        
        
        button2.setBounds(500,400,100,40);
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
        
        this.setLayout(null); //libel fixe or not !

		this.setTitle("Choix Algorithme"); //1ere interface est pour choisir l'algorithme !
		
		//frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // hide pour cacher, mais le programme ne se termine pas
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit = sortit et quitter !
		
		
		this.setSize(800,600); 	// REDIMENSIONNER l'interface ! 
		this.setVisible(true);   	// redre l'interface visible !
		
		//ajouter une icone à l'interface :
		ImageIcon img = new ImageIcon("logo.jpg"); 	// creer une image
		this.setIconImage(img.getImage());			// et l'xappliquer !
		
		//changer les couleurs de l'interface :
		this.getContentPane().setBackground(new Color(0,0,0)); //(background)

		
		
		
		
		// -------------------- Boutton RADIO 1 -------------------------

		
		GA_button.setBounds(50, 200, 200, 40);
        GA_button.setText("Genetic Algorithm");
        GA_button.addActionListener(this);
        GA_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        GA_button.setForeground(new Color (0xffffff)); //clr du texte
        GA_button.setBackground(new Color(0,0,0)); //(background)
		
        
        BSO_button.setBounds(300, 200, 300, 40);
        BSO_button.setText("Bee Swarm Optimization");
        BSO_button.addActionListener(this);
        BSO_button.setFont(new Font("Comic Sans",Font.BOLD ,16));
        BSO_button.setForeground(new Color (0xffffff)); //clr du texte
        BSO_button.setBackground(new Color(0,0,0)); //(background)
		
        
        
		// pour choisir une seul algorithme a la fois :
        ButtonGroup group = new ButtonGroup();
        
        group.add(GA_button);
        group.add(BSO_button);
        
		
		
		
		
		//-------------------- **** -------------------------
		
		
		this.add(label1);
		this.add(label2);
		
		
		this.add(GA_button);
		this.add(BSO_button);
		
		
		this.add(button1);
		this.add(button2);

		
	}

	
	
	
	
	// -------------------  RADIO button 1 ActionListener--------------------------------------------------
	
	@Override
	public void actionPerformed (ActionEvent e)
	{
		 if (e.getSource() == GA_button) 
		 {
	         Numero_Algo = 1;
			 button1.setEnabled(true);
	     }
		 else
		 {
			 if (e.getSource() == BSO_button)
			 {
				 Numero_Algo = 2;
				 button1.setEnabled(true);
				 
			 }
		 }
	}
	
}
