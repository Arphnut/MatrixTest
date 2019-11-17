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

    // public int getMatrix(int i, int j) {
    // 	return this.matrix[i][j];
    // }
    
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
	int[] vectRes = new int[this.dimN];
	for(int i = 0; i < this.dimN; i++)
	    {
		int sum = 0;
		for(int j = 0; j < this.dimP; j++)
		    {
			sum += this.matrix[i][j] * vect.getVector(j);
		    }
		vectRes[i] = sum;
	    }
	Vector vectorRes = new Vector(this.dimN, vectRes);
	return vectorRes;
    }
}

class Vector {
    private int dimN;
    private int vector[];

    public Vector(int n) {
	dimN = n;
	vector = RandomVector();
    }

    public Vector(int n, int[] vect) {
	dimN = n;
	vector = vect;
    }

    public int[] getVector() {
	return this.vector;
    }

    public int getVector(int i) {
	return this.vector[i];
    }


    public int[] RandomVector() {
	int[] vector = new int[dimN];
	Random rand = new Random();
	for(int i = 0; i < dimN; i++)
	    {
		vector[i] = rand.nextInt(20);
	    }
	return vector;
    }

    public String toString() {
	String vectorString = "[";
	for(int i = 0; i < this.dimN; i++)
	    {
		vectorString += this.vector[i] + ", ";
	    }
	vectorString = vectorString.substring(0, vectorString.length()-2);
	vectorString += " ]";
	return vectorString;
    }
}
