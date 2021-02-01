import java.util.Scanner;
import java.util.*;

/*
	#==========================================#  				
    # Original from (C) PapeCoding					       
    # Questions to www.facebook.com/PapeCoding 
    # Modifications made to the second part of the calculation
	#==========================================#
*/

public class Main {

    public static ArrayList<long[]> compute(long x, long y){ 		
		long[] R = new long[4];										
		long[] Ralt = new long[4];									
		ArrayList<long[]> Rggt = new ArrayList<long[]>();			
		
		if(x > y){
			R[0] = x;		
			R[2] = y;				
		} else {
			R[0] = y;		
			R[2] = x;		
		}
		
		R[1] = (long) (R[0]/R[2]);		
		R[3] = R[0] -(R[1]*R[2]);		
        System.out.println("");
		System.out.println(R[0] + " = " + R[1] + " * " + R[2] + " + " + R[3]); 			
		
		Rggt.add(Arrays.copyOf(R, R.length));   
		
		while(R[3] != 0){											 
			Ralt = R;												
			R[0] = Ralt[2];																							
			R[2] = Ralt[3];															
			R[1] = (long) (R[0]/R[2]);												
			R[3] = R[0] -(R[1]*R[2]);										
			System.out.println(R[0] + " = " + R[1] + " * " + R[2] + " + " + R[3]);      
			Rggt.add(Arrays.copyOf(R, R.length));  
		}
		System.out.println("");
		System.out.println("Greatest common divisor is d = " + R[2]);  
		return(Rggt);									
    }
    
	public static void bezout(long x, long y){			
		ArrayList<long[]> Rggt = compute(x,y); 			
		if(Rggt.size() == 1){return;}					
		long[] R = new long[4];
		long[] Ralt = new long[4];
		long[] Rand = Rggt.get(Rggt.size() - 2);		
		
		System.out.println("");
		System.out.println("====================================");
		System.out.println("");
		System.out.println("Bezout Identity:");
		System.out.println("");
		System.out.println(" " + Rand[3]);           	
				
		R[0] = 1;                       
		R[1] = Rand[0];                 
		R[2] = - Rand[1];               
		R[3] = Rand[2];                 
		
		if(R[2] >= 0){
			System.out.println("= " +  R[0] + " * " + R[1] + " + " + R[2] + " * " + R[3]);   
			
         
		} else {
            System.out.println("= " +  R[0] + " * " + R[1] + " - " + -R[2] + " * " + R[3]);            
			if(Rggt.size() > 2){
				System.out.print("= " +  R[0] + " * " + R[1] + " - " + -R[2] + " * " );
			}
        }
				
        for(int g = 3; g <= Rggt.size(); g++){			
			Ralt = Arrays.copyOf(R, R.length);
			Rand = Rggt.get(Rggt.size() - g);
			R[0] = Ralt[2];                             
			R[1] = Rand[0];                             
			R[2] = Ralt[0]+(Ralt[2]*(-1)*Rand[1]);      
			R[3] = Ralt[1];                             
			System.out.println("(" + R[1] + " - " + Rand[1] + " * " + R[3] + ")"); 
			if(R[2] >= 0){
				System.out.println("= " +  R[0] + " * " + R[1] + " + " + R[2] + " * " + R[3]);      
				if(g < Rggt.size()){
				System.out.print("= " +  R[0] + " * " + R[1] + " + " + R[2] + " * " );				
				}
			} else {
				System.out.println("= " +  R[0] + " * " + R[1] + " - " + -R[2] + " * " + R[3]);
				if(g < Rggt.size()){
					System.out.print("= " +  R[0] + " * " + R[1] + " + " + R[2] + " * " );				
				}
			}
			
        }
        System.out.println("");
		System.out.println("Therefore, a = " + R[0] + " and b = " + R[2]);
		System.out.println("with a * x + b * y = d");
		System.out.println("with x > y");
	

	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

		long x = 0;
        long y  = 0;
        
        System.out.println("Enter the first number (for example 144)");
        x = scanner.nextLong();
        System.out.println("Enter the second number (for example 42)");
        y = scanner.nextLong();

		if((x != 1) && (y != 1)){
			if((x != 0) && (y != 0)){
				bezout(x, y);
			} else {
				if(x == 0){
					System.out.println("You chose 0 as a number. So the greatest divisor is: " + y );
					System.out.println("Therefore, a = 0 and b =" + y);
				} else {
					System.out.println("You chose 0 as a number. So the greatest divisor is: " + x );
					System.out.println("Therefore, a = 0 and b = " + x);
				}
					System.out.println("with a * x + b * y = d");
					System.out.println("with x > y");
				
			}
		} else {
			System.out.println("You chose 1 as a number. So the greatest divisor is always 1.");
		}
        
        scanner.close();

    }
}
