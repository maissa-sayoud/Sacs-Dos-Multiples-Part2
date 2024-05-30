import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class LancerTraitementGA 
{
	

	
	public static double executionTimeInSeconds_GA;
	
	public static int VALEURMAXIMALEGA;
	
	public static int NOEUDSGA;
	
	public static int[] poid_actualeGA;
	
	public static int [][] matriceGA;
	
	
	
	
	public static void TraitementGA(int nsac, int nobj, int [] capacite, int [][] objet, int nit, int npp, int npc)
	{
		
		 int nmbn = 0;
		
		 
		 
		 
		 
		 boolean[][][] population = new boolean[npp][nsac][nobj];

		 
		 
		
		 int[][] point_actualle = new int[npp][nsac]; // chaque ligne solusion  chaque colonne piont de chaque sac
        
		 int[][] point_actualle_children = new int[npp][nsac];
        
		 int[] vtotale =new int[npp];   // V de chaque solusion (on voulez maximise la valeur v ).
        
		 int[] vtotale_children =new int[npp];
    	
		 int[][] copiePointActualle = new int[npp][nsac];
    	
		 int[] copieVtotale = new int[vtotale.length];
		 
		 
		 
		 
    	
		 //fonctionGA eval = new fonctionGA();
    	
		 int vbest=0;
    	
		 long startTime = System.currentTimeMillis();
        
		 
		 
		 for (int i = 0; i < npp; i++) 
		 {   
			 vtotale[i] = 0;
		 }

		 
        
		 for (int i = 0; i < npp; i++) 
		 {
            
			 for (int j = 0; j < nsac; j++) 
			 {
                
				 point_actualle[i][j] = 0;
            
			 }
        
		 }

		 

		 
        // le poids et la valeur de chaque obje aleatoirememnt 
        
		 System.out.println();
        
		 System.out.print( "POINT D'OBJET : ");
        
		 Random random = new Random();
		 
		
		 for (int i = 0; i < objet.length; i++) {
            
			 for (int j = 0; j < objet[i].length; j++) {
               
				 int valeur = 0;
                
				 while (valeur == 0) {
                 
					 valeur = random.nextInt(100); // Valeur aléatoire entre 1 et 100
                           
				 }
                    
				 objet[i][j] = valeur;
                    
				 
                                              
			 }
            
			 System.out.print(objet[i][0]+ " ");
                                             
		 }

		 
		 
		 
		 // capacite de chaque sa a dos . 
        
		 System.out.println();
        
		 System.out.print( "CAPACITE : ");

		 for (int i = 0; i < capacite.length; i++) 
		 {
    	    
			 int valeur = 0;
    	    
			 while (valeur == 0) 
			 {
    	     
				 valeur = random.nextInt(100); // Valeur aléatoire entre 1 et 100
    	     }
			 
			 capacite[i] = valeur;
    	    
			 System.out.print(capacite[i] + " ");

		 }
        
		 System.out.println();

		 
		 
		 
		 
		 
        // POPULATION : 
        
			
		 boolean hdi;
        
        for (int i = 0; i < npp; i++) 
        {
        	
        	int [] PS=new int[nsac];

        	do 
        	{ 
        		
        		nmbn=nmbn+1;

        		Set<Integer> objetexclu = new HashSet<>();
        		
        		for (int j = 0; j < nsac; j++) {
            	
                
        			for (int k = 0; k < nobj; k++) 
        			{

        				hdi=random.nextBoolean();
                	
        				while(hdi==true && objetexclu.contains(k)) 
        				{

        					hdi=random.nextBoolean();
                	
        				}
                	
        				if(hdi==true) 
        				{

        					if(( PS[j]+objet[k][0])>capacite[j]) 
        					{ 

        						hdi =false;
        					}
        					else 
        					{
        						objetexclu.add(k);
                			
        						PS[j]=PS[j]+objet[k][0];
        					}

        				}
                	
        				population[i][j][k] = hdi;

        				if(population[i][j][k]==true) 
        				{

                	
        				}
        			}
        		}
        	}
        	while(!fonctionGA.solusion_correct(population,capacite,objet,i,nsac,nobj,PS,npp));

        	
        	    
        	for (int d = 0; d< nsac; d++) 
        	{
        		point_actualle[i][d] = PS[d];
        	}
        	    // Evaluate_population: 
            	
        		
        	for (int c = 0; c < nobj; c++) 
        	{
        		vtotale[i] =vtotale[i]+ objet[c][1];
        	}

        }

        
        boolean[][] SGBEST=new boolean[nsac][nobj];
        
        nmbn=nmbn+1;
       
        int MG= fonctionGA.GetBestSolution(population,vtotale);

        
        
        
        
        
        // recuper la solusion : 
        
        for (int i = 0; i < nsac; i++) 
        {
        	for (int j = 0; j < nobj; j++) 
        	{
        		SGBEST[i][j] = population[MG][i][j];
        	}
        }

        vbest=vtotale[MG];

        
        
        
        
        

        int nbr=npp;

        while(nit>0) 
        {
        	 
        	System.out.println();

        	System.out.print("iteration :  "+nit);

        	System.out.println();

        	int[] parents = fonctionGA.select_parent(population,npp,nsac,nobj);
        	 
        	


        	boolean [][][]children=new boolean[npp][nsac][nobj];

        	nmbn=nmbn+1;

        	for(int i=0; i<npp;i+=2) {
        		
        		Set<Integer> parentsExclus = new HashSet<>();

        		if(i==npp-1) 
        		{
        			 
        			   int indice;
          	         
        			   do 
        			   {
       	                 
        				   indice = random.nextInt(npp); // Choisir un indice aléatoire dans [0, n)
       	            
        			   } 
        			   while (parentsExclus.contains(parents[indice])); // Répéter tant que l'indice est dans indicesExclus
       	            
        			   parentsExclus.add(parents[indice]);
       	            
       	         
        			   int uniquechild = parents[indice];
  	           
        			   boolean[][] child= population[uniquechild];

        			   
	    		
        			   int [] copie_point_child=new int[nsac];
	    		
        			   child= fonctionGA.mutation1(child,nsac,nobj,capacite,objet);
	    		

    	

        			   for (int j = 0; j < nsac; j++) 
        			   {
        			    
        				   for (int k = 0; k < nobj; k++) 
        				   {
        			        
        					   children[i][j][k] = child[j][k];
        			    
        				   }
        			
        			   }
        		
        		}
        		else 
        		{
        	
        			Pair<int[], Set<Integer>> P = fonctionGA.choisirdeuxparentAleatoire(npp,parentsExclus,parents);
        	 

        			int[] deuxparent= P.getKey();
    		  
        			parentsExclus=  P.getValue();
    		  
        			int parent1=deuxparent[0];
    		  
        			int parent2=deuxparent[1];
   
    		  
        			boolean[][][] result=fonctionGA.croisement(population[parent1],population[parent2],npc,npp,nsac,nobj);
    		 

        			boolean[][] child1 = (boolean[][])result[0];
    		  
        			boolean[][] child2 = (boolean[][])result[1];
    
    
        			boolean teste;
    		  
        			int [] copie_point_child=new int[nsac];
    		  
    		  

        			child1=fonctionGA.mutation1(child1,nsac,nobj,capacite,objet);
    		
    	

        			for (int j = 0; j < nsac; j++) 
        			{

        				for (int k = 0; k < nobj; k++) 
        				{

        					children[(i)][j][k] = child1[j][k];
    			    
        				}
    			
        			}
  	
    		  
    		  
    		 
        		  
        		  
        			child2=fonctionGA.mutation1(child2,nsac,nobj,capacite,objet);
        		 
        		          	
        		  
        			for (int j = 0; j < nsac; j++) 
        			{
        			
        				for (int k = 0; k < nobj; k++) 
        				{

        					children[(i)][j][k] = child2[j][k];
        			    
        				}
        			
        			}
    		  

        		}

        		int[][] P_children=new int[npp][nsac];

        		nmbn=nmbn+1;

        		int [] V_children=new int [npp];

        		for(int a=0;a<npp;a++) 
        		{
        			
        			for(int s=0;s<nsac;s++)
        			{
        				
        				for(int d=0;d<nobj;d++)
        				{
        					
        					if(children[a][s][d]==true) 
        					{
        						
        						P_children[a][s]=P_children[a][s]+objet[d][0];

        						V_children[a]=V_children[a]+objet[d][1];
        					
        					}
        					else 
        					{
        						
        						P_children[a][s]=P_children[a][s]+0;

        						V_children[a]=V_children[a]+0;
        					
        					}

        					
        				
        				}
        			
        			}
        			
        		
        		}
        		 

        		int M=0;

        		boolean[][] SBEST=new boolean[nsac][nobj];

        		
               
        		M= fonctionGA.GetBestSolution(children,V_children);
               
        		nmbn=nmbn+1;
                // recuper la solusion : 
                
        		for (int x = 0; x < nsac; x++) 
        		{
                    
        			for (int j = 0; j < nobj; j++) 
        			{
                    	
        				SBEST[x][j] = children[M][x][j];
                    
        			}
                
        		}
                // MIS A JOUE DE LA gbest: 
                
        		if( V_children[M]>vbest) 
        		{
                
        			vbest=V_children[M];
                	MG=M;
                	
                	
                	for (int Z = 0; Z < SBEST.length; Z++) 
                	{
                	    
                		for (int j = 0; j < SBEST[0].length; j++) 
                		{
                	        
                			SGBEST[Z][j] = SBEST[Z][j];
                	    
                		}
                	
                	}
                
        		}
                /// MIS A JOU VTOTALE:
               
                	// REPLACE : 
                	
                	
                	
        		for (int Z = 0; Z < npp; Z++) 
        		{
                	    
        			for (int j = 0; j < nsac; j++) 
        			{
                	        
        				for (int k = 0; k < nobj; k++) 
        				{
                	            
        					population[Z][j][k] = children[Z][j][k];
                	            
        					nmbn=nmbn+1;

        				}

        			}
                	
        		}
               
        		
        		

        	}
        	

        	nit=nit-1;
        	
        	

        }

        long endTime = System.currentTimeMillis();

        System.out.print( "la meilleur solution trouve est : ");
         
        
        
        
        matriceGA = new int [nsac][nobj];
        poid_actualeGA = new int [nsac];
        

        for (int i = 0; i < SGBEST.length; i++) 
        {
            
        	for (int j = 0; j < SGBEST[i].length; j++) 
        	{
                /*****************************************/
        		if (SGBEST[i][j]==false)
        		{
        			matriceGA[i][j]=0;
        		}
        		else 
        		{
        			matriceGA[i][j]=1;
        		}
        		/*****************************************/
            
        	}
            
        	System.out.println(); 
        
        }
        
        

        for (int i = 0; i < SGBEST.length; i++) {
        	
        	int p=0;

        	System.out.print( "sac "+i+" :");

        	for (int j = 0; j < SGBEST[i].length; j++) 
        	{
            	
        		if( SGBEST[i][j]==true) 
        		{

        			System.out.print(" objet "+j);
                
        			p=p+objet[j][0];
                
        		}
            	
        	}
        	
        	poid_actualeGA [i] = p;
        	
        	
        	System.out.print("  "+p+" VS "+capacite[i]);
            
        	System.out.println(); 
        	
        	
        
        }
        
        
        //System.out.print( " Vtotale = "+vbest);
        VALEURMAXIMALEGA = vbest;
        
        
        //System.out.print( " nembre de noeud = "+nmbn);
        NOEUDSGA = nmbn;

        double executionTimeSeconds = (endTime - startTime) / 1000.0;

        
        //System.out.println("Temps d'exécution : " + executionTimeSeconds + " secondes");
        executionTimeInSeconds_GA = executionTimeSeconds;
	 
        
        
	 }
	

}
