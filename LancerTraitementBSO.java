import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LancerTraitementBSO 
{
	
	
	public static double executionTimeInSeconds_BSO;
	
	public static int VALEURMAXIMALEBSO;
	
	public static int NOEUDSBSO;
	
	public static int[] poid_actualeBSO;
	
	public static int [][] matriceBSO;
	
	
	
	public static void TraitementBSO(int nsac, int nobj, int [] capacite, int [][] objet, int nit, int nitl, int nbee, int nchance, int nflip)
	{
		
		    int nbrn=0;

		    
		    
		    
		    
		    
		    Noeud [] Points=new Noeud[nbee];
		    Noeud [] dance =new Noeud[nbee];    // grp de solusion apre searcheArea . 


		    int i=0; 
		    
		    long startTime = System.currentTimeMillis();
		    // pour inisialise best solusion initiale : 
		    int [][]matriceZero= new int[nsac][nobj];
		    
		    for (int ii = 0; ii < nsac; ii++) 
		    {
		        for (int j = 0; j < nobj; j++) 
		        {
		        	matriceZero[ii][j] = 0;
		        }
		    }
		    
		   
		    
		    int []tableau=new int[nsac];
		    
		    for (int ii = 0; ii <nsac; ii++) 
		    {
		        tableau[ii] = 0;
		    }
		    
		   
		    int  ff=0;
		   
		    int cc=0;
			
		   
		    for(int ii=0;ii<nbee;ii++)
		   
		    {
			   
		    	dance[ii] = new Noeud(matriceZero,ff,tableau,cc); 
			   
		    	Points[ii] = new Noeud(matriceZero,ff,tableau,cc); 
		    }
		    
		    
		    Random random = new Random();
		    
		    // liste taboo :
		    List<Noeud> listetaboo = new ArrayList<>();
		    
	        System.out.println();
	        System.out.print( "OBJET : ");
	        System.out.println();
	        
	        // les valeur de poid et V:
	        for (int ii = 0; ii < nobj; ii++) 
	        {
	            for (int jj = 0; jj <2; jj++) 
	            {
	               
	            	int valeur = 0;
	                while (valeur == 0) 
	                {
	                 
	                	valeur = random.nextInt(100); // Valeur aléatoire entre 1 et 100
	                           
	                }
	                    
	                objet[ii][jj] = valeur;
	                
	                System.out.print(objet[ii][jj]+ " ");
	                      
	            } 
	            System.out.println();
	        
	        }
	        
	        // capacite de chaque sa a dos . 
	        
	        System.out.println();
	        System.out.print( "CAPACITE des sac a dos : ");
	        
	        for (int ii = 0; ii < nsac; ii++) 
	        {
	    	    int valeur = 0;
	    	    while (valeur == 0) 
	    	    {
	    	        valeur = random.nextInt(100); // Valeur aléatoire entre 1 et 100
	    	    }
	    	    
	    	    capacite[ii] = valeur;
	    	    System.out.print(capacite[ii] + " ");
	    	    
	    	}
	        
	        System.out.println();
	        //fonction eval = new fonction();
		   
		    // first solusion : 
		    
		    Noeud So = fonction.BeeInt(nsac,nobj,capacite,objet,nchance); 
		    nbrn=nbrn+1;
		    Noeud Sref= new Noeud(So.getMatrice(),So.getf(),So.getp(),So.getc());
		    nbrn=nbrn+1;
		    
		    
		    
		    Noeud BESTSOLUSIO=new Noeud(Sref.getMatrice(), Sref.getf(), Sref.getp(), Sref.getc());
		    
		    nbrn=nbrn+1;
		    while(i<nit) 
		    {
		    
		    	listetaboo.add(new Noeud(Sref.getMatrice(),Sref.getf(),Sref.getp(),Sref.getc()));
		   
		    
		    	Noeud [] pp= fonction.SearchPoints(nbee,Sref, nsac,nobj,objet,capacite,nflip,Points); // bien 
		   
		    	nbrn=nbrn*nbee;
		   
		    
		    	for(int ii=0;ii<nbee;ii++)
		    
		    	{
			   
			   
		    		Points[ii].setMatrice(pp[ii].getMatrice());
			   
		    		Points[ii].setp(pp[ii].getp());
			   
		    		Points[ii].setf(pp[ii].getf());
			   
		    		Points[ii].setc(pp[ii].getc());
   
		    
		    	} 
		   
		   

		    
		    	// cv :
		    	// for eache bee : 
		    
		    	for(int b=0;b<nbee;b++) 
		    	{
		    	
		    	
		    		Noeud SL =fonction.localesearch(Points[i],nsac,nobj,capacite,objet,nitl);
		    	
		    		nbrn=nbrn+1;
		    	
		    		dance[b].setMatrice(SL.getMatrice());
		    		dance[b].setf(SL.getf());
		    		dance[b].setp(SL.getp());
		    		dance[b].setc(SL.getc());
		    	
		    	}              
		    
		    
		        
		    	Noeud sbestq =fonction.best_quality(dance,nbee,nsac,nobj);
		    	
		    	nbrn=nbrn+1;
		        
		    
		    	Noeud BESTSOLUSIO0 =fonction.best_solusion(sbestq,Sref,nsac, nobj,capacite,objet,nchance,listetaboo,dance,nbee);
		    
		    	nbrn=nbrn*nbee;
		    	nbrn=nbrn+1;
		    
		    	Sref.setMatrice(BESTSOLUSIO0.getMatrice());
		    	Sref.setf(BESTSOLUSIO0.getf());
		    	Sref.setc(BESTSOLUSIO0.getc());
		    	Sref.setp(BESTSOLUSIO0.getp());
		    
		    	i++; 
		    	
		    }
		    
		    long endTime = System.currentTimeMillis();
		    // show the  best solution .....
		    
		    
		    int v=0;
		    
		    System.out.println(); 
		    System.out.print(" best solution:");
		    System.out.println(); 
		    
		    
		    
		    
		    poid_actualeBSO = new int [nsac];

		    
		    for (int ii = 0; ii < nsac; ii++) 
		    {
		    	System.out.print("sac"+ii); 
		    	System.out.print(" {"); 
		        
		    	for (int j = 0; j <nobj; j++) 
		        {
		        	if(Sref.getMatrice()[ii][j]==1)
		        	{
		        		v=v+objet[j][1];
		    			System.out.print("objet "+j+" "); 
		    		}
		        		
		        	
		        } 
		    	
		    	poid_actualeBSO[ii] = Sref.getp()[ii];
		    	
		    	System.out.print(" }"); 
		        System.out.print("   "+Sref.getp()[ii]+"VS"+capacite[ii]); 
		        System.out.println(); 
		    }

		    
		    
		    
		    matriceBSO = new int [nsac][nobj];
		    
		    matriceBSO = Sref.getMatrice();
		    
		    //System.out.print(" V= "+v); 
		    VALEURMAXIMALEBSO = v;
		    
		    
		    //System.out.print("nembre de noeud  "+nbrn); 
		    NOEUDSBSO = nbrn;
		    
		    double executionTimeSeconds = (endTime - startTime) / 1000.0;

	        //System.out.println("Temps d'exécution : " + executionTimeSeconds + " secondes");
	        executionTimeInSeconds_BSO = executionTimeSeconds;
	 
	        
	        
	        
	   
	        
	        
	}

}











