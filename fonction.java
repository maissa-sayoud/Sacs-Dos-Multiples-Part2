import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.sound.midi.Soundbank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class fonction {
	
	public static  Noeud BeeInt(int nsac,int nobj,int [] capacite,int[][] objet,int nchance){
		
		int [][] solusion=new int[nsac][nobj];
		int [] PS=new int[nsac];
		for(int i=0;i<nsac;i++) {
			PS[i]=0;
		}
		int v=0;
		Random random = new Random();
		Set<Integer> objetexclu = new HashSet<>();
		int hdi =0;
        for (int j = 0; j < nsac; j++) {
        	
            for (int k = 0; k < nobj; k++) {
            	hdi=random.nextInt(2);
            	while(hdi==1 && objetexclu.contains(k)) {
            		hdi=random.nextInt(2);
            	}
            	if(hdi==1) { 
            		if(( PS[j]+objet[k][0])>capacite[j]) { 
            			hdi =0;
            			
            		}else {
            			objetexclu.add(k);
            			PS[j]=PS[j]+objet[k][0];
            			v=v+objet[k][1];
            			solusion[j][k] = hdi;
            		}
            		
            	}else {
            		solusion[j][k] = hdi;
            	}
            	
            }
        }
        
        Noeud result = new Noeud(solusion,v,PS,nchance);
        
		
        return result  ; 
		
	}
	
	
	public static Noeud[] SearchPoints(int nbee,Noeud Sref,int nsac,int nobjet,int[][]objet,int []capacite,int nflip,Noeud [] points) {
		int h=0; 
		int i=0; 
		int p;
		int indice=0;
	  while (i<nbee) {
		  
		  if (h>=nobjet) {
			  h %= nobjet;
			  
		  }

		  
		  Noeud S=new Noeud(Sref.getMatrice(), Sref.getf(), Sref.getp(), Sref.getc());
		  Set<Integer> objetexclu = new HashSet<>();
		  
		  for(int x=0; x<nsac;x++) {
			  for (int y=0;y<nobjet;y++) {
				  if( S.getMatrice()[x][y]==1) {
					  objetexclu.add(y);
				  }
				  
			  }
			  
		  }
		  
		  for(int d=0;d<nsac;d++) {
			  

			  
			  p=0;
		  do {
			  indice=((nflip*p)+h);
			  
			  if ( S.getMatrice()[d][indice]==1) {
				  S.setcase(d, indice, 0);  
				   objetexclu.remove(indice);
				   int hhh=S.getf()-objet[indice][1];
				   S.setf(hhh);
				   S.setcasep(d, S.getp()[d]-objet[indice][0]);
			  }else {   
				  if (!objetexclu.contains(indice)) {
					  if( (S.getp()[d]+objet[indice][0])<=capacite[d]) {
						  S.setcase(d, indice, 1);
			
					  objetexclu.add(indice);
					  int hhh=(S.getf()+objet[indice][1]);
					  S.setf( hhh);
					  S.setcasep(d, (S.getp()[d]+objet[indice][0]));
					  }
					 
				  }
				  
			  }
			  p++;
			 // System.out.print(" indice =  "+indice); 
			  
		  }while((((nflip*p) + h)< nobjet));
	  }
		  points[i].setMatrice(S.getMatrice());
		  points[i].setc(S.getc());
		  int hh=S.getf();
		  points[i].setf(hh);
		  points[i].setp(S.getp());
 
		  h++;
		  i++;
		  }	

	    
		return points ; 
	  
	}
	
	
	
	
	
	public static Noeud  best_quality( Noeud []dance,int nbee,int nsac,int nobj) {
		  int indice =0;
		  Noeud first = new Noeud(dance[0].getMatrice(), dance[0].getf(),dance[0].getp(), dance[0].getc());
		  int v= first.getf();
		for (int i=0;i<nbee;i++) { 
			if(dance[i].getf()>v) {
				indice= i; 
				v=dance[i].getf();
				
			}
			
		}
		
		return dance[indice];
		
	}
	
	public static Noeud localesearch( Noeud S,int nsac,int nobj, int [] capacite,int [][]objet,int nitl ) {
		Random random = new Random();
		Noeud solusion = new Noeud(S.getMatrice(), S.getf(), S.getp(), S.getc()); 
		int indice;
		  Set<Integer> objetexclu = new HashSet<>();
		  for(int x=0; x<nsac;x++) {
			  for (int y=0;y<nobj;y++) {
				  if( solusion.getMatrice()[x][y]==1) {
					  objetexclu.add(y);
				  }
				  
			  }
			  
		  }
		for(int i=0;i<nitl;i++) {
			
			for(int x=0;x<nsac;x++) {
					 for(int d=0;d<2;d++) {
					indice=random.nextInt(nobj);
					 //int[] nouvelleColonne = new int[nobj];
					if(solusion.getMatrice()[x][indice]==1) {
						
					    solusion.setcase(x, indice, 0);
					    int h=((solusion.getf())-(objet[indice][1]));
					    solusion.setf(h);
					    int hh=solusion.getp()[x] - objet[indice][0];
					    solusion.setcasep(x,hh);
						objetexclu.remove(indice);
					    }else {
					         if(!objetexclu.contains(indice)) {
					    	  if(((solusion.getp()[x])+objet[indice][0])<=capacite[x]) {
					    		  solusion.setcase(x, indice, 1);
					    		  int hhhh=solusion.getf()+objet[indice][1];
							    	solusion.setf(hhhh);
							    	int hh =solusion.getp()[x]  + objet[indice][0];
								    solusion.setcasep(x,hh);
									objetexclu.add(indice);
					    	    			}
					    	    			
					    	    		}
					    	    	}
					    	    }  
					    	}
					    }
		return solusion;
					 }

	

	
	
	//best_diversite max diverse  ;
	static Noeud best_diversite ( List<Noeud> taboo, Noeud [] dance,int nsac,int nobj,int [] capacite,int [][]objet,int nbee) {
		 int max_diverse=0;
		 int [] diverse=new int [nbee];
		 Noeud  premierElement = taboo.get(0);
		 for(int i=0;i<nbee;i++) {
			 int mindiverse= dance[i].getf()-premierElement.getf();
			 for (Noeud element : taboo) {
				 if(dance[i].getf()- element.getf()>mindiverse) {
					 mindiverse=dance[i].getf()- element.getf();
				 }
				 
				}
			 diverse[i]=mindiverse;
			 
		 }
	         int max=diverse[0]; 
	         int indice=0;
		    for (int i = 0; i < diverse.length; i++) {
		        if (diverse[i] > max) {
		            max = diverse[i]; // Mettre à jour la valeur maximale si un élément plus grand est trouvé
		            indice = i;
		        }
		    }

		    return dance[indice] ;
		 
		 
		
		
		
		
	}
	
	
	public static Noeud  best_solusion(Noeud sbest,Noeud Sref,int nsac,int nobj, int [] capacite,int [][]objet,int nchance,List<Noeud> taboo, Noeud []dance,int nbee) {

		if((sbest.getf()-Sref.getf())>0){
			
			Sref.setMatrice(sbest.getMatrice());
			int hhhh=sbest.getf();
			Sref.setf(hhhh);
			Sref.setp(sbest.getp());
			Sref.setc(sbest.getc());
			if(Sref.getc()<nchance ) {
			   Sref.setc(nchance);
			}
		   }else {
			   sbest.setc((sbest.getc()-1));
			   if(sbest.getc()>0){
					Sref.setMatrice(sbest.getMatrice());
					int hh=sbest.getf();
					Sref.setf(hh);
					Sref.setp(sbest.getp());
					Sref.setc(sbest.getc());
				   
			   }else {
				   
				   Noeud n = best_diversite( taboo,dance,nsac,nobj,capacite,objet,nbee) ;
					Sref.setMatrice(n.getMatrice());
					int ddd=n.getf();
					Sref.setf(ddd);
					Sref.setp(n.getp());
					Sref.setc(n.getc());
					Sref.setc(Sref.getc()-1);
			   }
			   

		   }
		return Sref ;
		
		
		
	}
	
	
	
}