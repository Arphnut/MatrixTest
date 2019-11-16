// Import the class Scanner from the package java.util
import java.util.Scanner;
// Import the Random class, from java.util
import java.util.Random;

public class MatrixTest{
    public static void main(String[] args) {
	Matrix aTest =  new Matrix(3,3);
    }
}

class Matrix{
    private int dimN;
    private int dimP;
    private int matrix[][];

    public Matrix(int n, int p) {
	dimN = n;
	dimP = p;
	matrix = RandomMatrix();
    }

    public int[][] getMatrix() {
	return this.matrix;
    }

    public void setMatrix(int[][] mat) {
	this.matrix = mat;
    }

    public void setMatrix(int i, int j, int val) {
	this.matrix[i][j] = val;
    }
    
    public int[][] RandomMatrix() {
	int[][] matrix = new int[dimN][dimP];
	Random rand = new Random();
	for(int i=0; i<=dimN; i++)
	    {
		for(int j=0; j<=dimP; i++)
		    {
			matrix[i][j] = rand.nextInt(20);
		    }
	    }
	return matrix;
    }
}

class Vector {
    private int dimN;
    private int vector[];

    public Vector(int n) {
	dimN = n;
	vector = RandomVector();
    }

    public int[] RandomVector() {
	int[] vector = new int[dimN];
	Random rand = new Random();
	for(int i=0; i<=dimN;i++)
	    {
		vector[i] = rand.nextInt(20);
	    }
	return vector;
    }
}
