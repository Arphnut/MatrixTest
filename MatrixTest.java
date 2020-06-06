// Import the class Scanner from the package java.util
import java.util.Scanner;	
// Import the Random class, from java.util
import java.util.Random;

public class MatrixTest{
    public static void main(String[] args) {
	Matrix aTest =  new Matrix(3, 3);
	Matrix bTest = new Matrix(3, 3);
	System.out.println(aTest);
	System.out.println(bTest);
	System.out.println(aTest.matrixAddition(bTest));
	System.out.println(aTest.matrixSubstraction(bTest));
    }
}

class DimensionException extends Exception {
    public DimensionException() {
	System.out.println("Exception in thread\n"
			   + "The dimension of the two matrices should correlate\n");
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

    public void testMulDimension(Matrix mat)
	throws DimensionException
    {
	if (this.dimP != mat.dimN)
	    throw new DimensionException();
    }

    public void testSumDimension(Matrix mat)
	throws DimensionException
    { if ((this.dimN != mat.dimN) || (this.dimP != mat.dimP))
	    throw new DimensionException();
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

    public Matrix matrixAddition(Matrix mat) {
	try {
	    this.testSumDimension(mat);
	}
	catch (DimensionException ex) {
	    return null;
	}
	int[][] matRes = new int[this.dimN][this.dimP];
	for (int i=0; i < this.dimN; i++) {
	    for (int j=0; j < this.dimP; j++) {
		matRes[i][j] = this.matrix[i][j] + mat.matrix[i][j];
	    }
	}
	Matrix matrixRes = new Matrix(this.dimN, this.dimP, matRes);
	return matrixRes;
    }

    public Matrix matrixSubstraction(Matrix mat) {
	try {
	    this.testSumDimension(mat);
	}
	catch (DimensionException ex) {
	    return null;
	}
	int[][] matRes = new int[this.dimN][this.dimP];
	for (int i=0; i < this.dimN; i++) {
	    for (int j=0; j < this.dimP; j++) {
		matRes[i][j] = this.matrix[i][j] - mat.matrix[i][j];
	    }
	}
	Matrix matrixRes = new Matrix(this.dimN, this.dimP, matRes);
	return matrixRes;
    }

    public Matrix matrixMultiplication(Matrix mat) {
	try {
	    this.testMulDimension(mat);
	}
	catch (DimensionException ex) {
	    return null;
	}
	int[][] matRes = new int[this.dimN][mat.dimP];
	for(int i=0; i < this.dimN; i++)
	    {
		for(int j=0; j < mat.dimP;  j++)
		    {
			int sum = 0;
			for(int k=0; k < this.dimP; k++)
			    {
				sum += this.matrix[i][k] * mat.matrix[k][j];
			    }
			matRes[i][j] = sum;
		    }
	    }
	Matrix matrixRes = new Matrix(this.dimN, mat.dimP, matRes);
	return matrixRes;
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
