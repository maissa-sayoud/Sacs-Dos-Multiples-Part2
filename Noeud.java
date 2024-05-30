	public class Noeud {
	    private int[][] matrice;
	    private int f;
	   private int [] p;
       private int c;
	    public Noeud(int[][] matrice, int f,int [] p,int c) {
	        this.matrice = matrice;
	        this.f = f;
	        this.p=p;
	        this.c=c;
	        
	      
	    }
	    public int getc() {
	        return c;
	    }

	    public void setc(int c) {
	        this.c = c;
	    }
	   
	    public int[][] getMatrice() {
	        return matrice;
	    }

	    public void setMatrice(int[][] matrice) {
	        this.matrice = matrice;
	    }

	    public int getf() {
	        return f;
	    }

	    public void setf(int f) {
	        this.f= f;
	    }
	    public int [] getp() {
	        return p;
	    }

	    public void setp(int [] p) {
	        this.p= p;
	    }
	    
	    public void setColonne(int indice, int[] nouvelleColonne) {
	        for (int i = 0; i < matrice.length; i++) {
	            matrice[i][indice] = nouvelleColonne[i];
	        }
	    }
	    public void setligne(int indice, int[] nouvelleligne) {
	        for (int i = 0; i < nouvelleligne.length; i++) {
	            matrice[indice][i] = nouvelleligne[i];
	        }
	    }
	    public void setcase(int indiceligne, int indicecolonne, int valeur ) {
	        
	            matrice[indiceligne][indicecolonne] = valeur;
	        
	    }
	    public void setcasep( int indicecolonne, int valeur ) {
	        
            p[indicecolonne] = valeur;
        
    }
	}
