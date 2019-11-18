// Import the class Scanner from the package java.util
import java.util.Scanner;
// Import the Random class, from java.util
import java.util.Random;

public class MatrixTest{
    public static void main(String[] args) {
	Matrix aTest =  new Matrix(3,4);
	System.out.println(aTest);
	Vector vTest = new Vector(4);
	System.out.println(vTest);
	System.out.println(aTest.transpose());
	System.out.println(aTest.vectorMultiplication(vTest));
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

    public Matrix(int n, int p, int[][] mat) {
	dimN = n;
	dimP = p;
	matrix = mat;
    }

    public int[][] getMatrix() {
	return this.matrix;
    }

    public int getMatrix(int i, int j) {
    	return this.matrix[i][j];
    }
    
    public void setMatrix(int[][] mat) {
	this.matrix = mat;
    }

    public void setMatrix(int i, int j, int val) {
	this.matrix[i][j] = val;
    }

    public String toString() {
	String matrixString = "[";
	for(int i = 0; i < dimN; i++)
	    {
		matrixString += "[ ";
		for(int j = 0; j < dimP; j++)
		    {
			matrixString += this.matrix[i][j]+", ";
		    }
		matrixString = matrixString.substring(0, matrixString.length()-2);
		matrixString += " ]\n";
	    }
	return matrixString;
    }
    
    public int[][] RandomMatrix() {
	int[][] matrix = new int[dimN][dimP];
	Random rand = new Random();
	for(int i = 0; i < dimN; i++)
	    {
		for(int j = 0; j < dimP; j++)
		    {
			matrix[i][j] = rand.nextInt(20);
		    }
	    }
	return matrix;
    }

    public Matrix transpose() {
	int[][] trans = new int[this.dimP][this.dimN];
	for(int i = 0; i < dimN; i++)
	    {
		for(int j = 0; j < dimP; j++)
		    {
			trans[j][i] = matrix[i][j];
		    }
	    }
	Matrix transMatrix = new Matrix(dimP, dimN, trans);
	return transMatrix;
    }

    public Vector vectorMultiplication(Vector vect) {
	int[][] vectRes = new int[this.dimN][1];
	for(int i = 0; i < this.dimN; i++)
	    {
		int sum = 0;
		for(int j = 0; j < this.dimP; j++)
		    {
			sum += this.matrix[i][j] * vect.getMatrix(j,0);
		    }
		vectRes[i][0] = sum;
	    }
	Vector vectorRes = new Vector(this.dimN, vectRes);
	return vectorRes;
    }
}

class Vector extends Matrix {
    public Vector(int n) {
	super(n, 1);
    }

    public Vector(int n, int[][] vect) {
	super(n, 1, vect);
    }
}
