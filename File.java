
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File 
{

	public static int[][] ExtractData1(int n, String csv_name)
	{
		//CSV file contient des données séparées par des virgules :
		// premiere donnée c'est la valeur
		// deuxieme donnée represente le poids 
		int[][] items = new int[n][2];
		
		String file = csv_name;
		
		BufferedReader reader = null ;
		
		String line = "";
		
        //List<Item> items = new ArrayList<Item>();

        
        //int indice = 0;
		
		try 
		{
			reader = new BufferedReader(new FileReader(file)) ;
			
			int i=0;
			
			while ((line = reader.readLine()) != null)
			{
				String[] row = line.split(",");
				
				
				// Conversion des valeurs du CSV en entiers
                int valeur = Integer.parseInt(row[0]);
                int poids = Integer.parseInt(row[1]);
                
                items [i][0] = valeur;
                items [i][1] = poids ;
                
                i++;
               
			}
			
			// -- verifier si la table des items est bien remplie : 
            System.out.println(" Table des items : ");
            
            for (int k = 0; k < n; k++) 
            {
         	    System.out.println(items[k][0] + " " + items[k][1]);
         	}
         	
			
			
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			
		}
		
		
		return items;
		
	}
}
