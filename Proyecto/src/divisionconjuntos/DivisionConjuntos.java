/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisionconjuntos;

/**
 *
 * @author Andrés Movilla
 */
public class DivisionConjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	int[] arr = {3,1,1,1, 2,2,1,1};
	int k = 5;
	if (findPart(arr, k)) {
	    System.out.println("Can be divided.");
	} else {
	    System.out.println("Can not be divided.");
	}
	
    }
    
    public static boolean findPart(int[] arr, int k) {
	int sum = 0;
	for (int i = 0; i < arr.length; i++) {
	    sum += arr[i];
	}
	
	if (sum%k != 0) {
	    return false;
	}
	
	boolean part[][] = new boolean[sum/k+1][arr.length+1];
	for (int i = 0; i <= arr.length; i++) {
	    part[0][i] = true;
	}
	
	for (int i = 1; i <= sum/k; i++) {
	    part[i][0] = false;
	}
	
	for (int i = 1; i <= sum/k; i++) {
	    for (int j = 1; j <= arr.length; j++) {
		part[i][j] = part[i][j-1];
		if (i >= arr[j-1]) {
		    part[i][j] = part[i][j] || part[i-arr[j-1]][j-1];
		}
	    }
	}
	
	return part[sum/k][arr.length];
    }
    
}
