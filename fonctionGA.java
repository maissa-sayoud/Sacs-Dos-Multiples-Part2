import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class fonctionGA 
{
	
	
	public static boolean solusion_correct(boolean[][][] population,int[]capacite,int[][]objet,int i,int nsac,int nobjet,int[]PS,int npp){
	        // VERIFIER QUE L'OBJET AJOUTE SEULEMNT DANS UN SEL SAC A DOS: 
	        // Parcours de chaque colonne dans chaque matrice
	        for (int colonne = 0; colonne < nobjet; colonne++) 
	        {
	            boolean colonneCorrecte = false; // Indicateur si la colonne est correcte dans la matrice actuelle
	            // Vérification de chaque ligne dans la matrice pour la colonne actuelle
	            for (int ligne = 0; ligne < nsac; ligne++) 
	            {
	                // Si la valeur dans la cellule est égale à 1, la colonne est considérée comme "vraie"
	                if (population[i][ligne][colonne] == true) 
	                {
	                    // Si la colonne est déjà marquée comme "vraie", la solution n'est pas correcte
	                    if (colonneCorrecte) 
	                    {
	                    
	                        return false;
	                    }else {
	                    colonneCorrecte = true;
	                    }
	                }
	                    
	            }
	          
	        }
	        // VERIFER QUE CHAQUE SAC A DOS N'A PAS DOPACE LA CAPACITE : 
	       
	      
	        	for(int sac=0;sac<nsac;sac++) {
	        		if(PS[sac]>capacite[sac]) {
	        			
	        			return false; 
	        		}
	        	}
	        	
	        
	        
	    return true;
	}
	
	
	
	
	public static boolean solusion_correctCHILD(boolean[][] solusion,int[]capacite,int[][]objet,int nsac,int nobjet,int[]PointActualle_child,int npp){
        // VERIFIER QUE L'OBJET AJOUTE SEULEMNT DANS UN SEL SAC A DOS: 
        // Parcours de chaque colonne dans chaque matrice
        for (int colonne = 0; colonne < nobjet; colonne++) {
            boolean colonneCorrecte = false; // Indicateur si la colonne est correcte dans la matrice actuelle
            // Vérification de chaque ligne dans la matrice pour la colonne actuelle
            for (int ligne = 0; ligne < nsac; ligne++) {
                // Si la valeur dans la cellule est égale à 1, la colonne est considérée comme "vraie"
                if (solusion[ligne][colonne] == true) {
                    // Si la colonne est déjà marquée comme "vraie", la solution n'est pas correcte
                    if (colonneCorrecte) {
                        return false;
                    }
                    colonneCorrecte = true;
                }
            }
          
        }
        // VERIFER QUE CHAQUE SAC A DOS N'A PAS DOPACE LA CAPACITE : 
       
        for(int sol=0;sol<npp;sol++) {
        	for(int sac=0;sac<nsac;sac++) {
        		if(PointActualle_child[sac]>capacite[sac]) {
        			return false; 
        		}
        	}
        	
        }
        
    return true;
}

	
	
	
	
	
	
	
	
	
	public static int[] select_parent(boolean[][][]population,int npp,int nsac,int nobj) {
		 Random random = new Random();
		 int[] tableau=new int[npp];
		 
		for(int i=0;i<(npp);i++) {
			
		tableau[i]=random.nextInt(npp);
			
		}
		
		return tableau;
	}
	
	public static Pair<int[], Set<Integer>> choisirdeuxparentAleatoire(int npp,Set<Integer> parentsExclus,int[] parents){
		
	    Random random = new Random();
        int[] parentsChoisis = new int[2];

        for (int i = 0; i < 2; i++) {
            int indice;
            do {
                indice = random.nextInt(npp); // Choisir un indice aléatoire dans [0, n)
            } while (parentsExclus.contains(parents[indice])); // Répéter tant que l'indice est dans indicesExclus
            parentsExclus.add(parents[indice]);
            parentsChoisis[i] = parents[indice];
        }

        return new Pair<>(parentsChoisis, parentsExclus);
		
		
		
		
	
	}
	
	
	
	
	public static boolean[][][] croisement(boolean[][] PARENT1,boolean[][] PARENT2,int npc,int npp,int nsac,int nobj) {
		 Random random = new Random();
		 boolean [][] enfant1=new boolean[nsac][nobj];
		 boolean [][] enfant2=new boolean[nsac][nobj];
		    // Sélectionner les points de croisement random
		    List<Integer> pointsCroisement = new ArrayList<>();
		    for (int i = 0; i < npc; i++) {
		        int point = random.nextInt(nsac - 1) + 1; // Évite le premier et le dernier élément
		        if (!pointsCroisement.contains(point)) {
		            pointsCroisement.add(point);
		        }
		    }
		    Collections.sort(pointsCroisement);//on trie la liste 
		    
		    boolean croiser = false;
		    for (int i = 0; i < nsac; i++) {
		        if (pointsCroisement.contains(i)) {
		            croiser = !croiser; // Inverser le croisement à chaque point
		        }
		        if (croiser) {
		        	int x = i; // Ligne à copier
		        	int y = i; // Ligne de destination

		        	// Copier la ligne i dans la ligne j
		        	for (int k = 0; k < nobj; k++) {
		        	    enfant1[y][k] = PARENT2[i][k];
		        	}
		        	
		        	for (int k = 0; k < nobj; k++) {
		        	    enfant2[y][k] = PARENT1[i][k];
		        	}
		        	
		        } else {
		        	for (int k = 0; k < nobj; k++) {
		        	    enfant1[i][k] = PARENT1[i][k];
		        	}
		        	for (int k = 0; k < nobj; k++) {
		        	    enfant2[i][k] = PARENT2[i][k];
		        	}
		        }
		    }
		    
		    return new boolean[][][]{enfant1, enfant2};

		
	}
	
	
	public static boolean[][] mutation1( boolean[][]child,int nsac,int nobjet,int[]capacite,int[][]objet){
    int []point_actualle =new int[nsac];
		for (int c = 0; c < nsac; c++) {
    	    for (int d = 0; d< nobjet; d++) {
    	        point_actualle[c] = point_actualle[c]+objet[d][0];
    	    }
    	}
		
		for(int i=0;i<nobjet;i++) {
			Set<Integer> objetexclu = new HashSet<>();
			for(int j=0;j<nsac;j++) {
			  if(child[j][i]==true){
				  if( point_actualle[j]>capacite[j]){child[j][i]=false; 
				  point_actualle[j]=point_actualle[j]-objet[i][0];
				  }
				  else {
				   if(objetexclu.contains(i)) {
					  child[j][i]=false;
					  point_actualle[j]=point_actualle[j]-objet[0][i];
				  }else {
					  objetexclu.add(i);
				  }
				   }
					  }else {  
						  if(!objetexclu.contains(i)) {
							  if((point_actualle[j]+objet[i][0])<=capacite[j]){
								  child[j][i]=true;
								  objetexclu.add(i);
								  
							  }
						  }
						  
					  }
				  
				  
			  }
			}
			return child;
		}
		
		

	
	
	//MUTASION : PERMUTATION ENTRE DEUX LIGNE DE LA SOLUSION DE CHILDE 
	public static boolean[][] mutation( boolean[][]child,int nsac){
        Random random = new Random();

        // Générer deux indices de ligne aléatoires
        int indexLigne1 = random.nextInt(nsac);
        int indexLigne2 = random.nextInt(nsac);

        // Permuter les lignes choisies aléatoirement
        boolean[] temp = child[indexLigne1];
        child[indexLigne1] = child[indexLigne2];
        child[indexLigne2] = temp;
		
		return child;
		
	}
	
	
	public static int GetBestSolution(boolean[][][]children,int[] V_children) {
        int maxValeur_children = V_children[0]; 
        int indiceMax_children = 0; 
        
        for (int m = 1; m < V_children.length; m++) {
            if (V_children[m] > maxValeur_children) {
            	maxValeur_children = V_children[m];
            	indiceMax_children = m;  // la solusion num m de d'apres les children . 
            }
        }
		return indiceMax_children;
	}
	
	
	
}