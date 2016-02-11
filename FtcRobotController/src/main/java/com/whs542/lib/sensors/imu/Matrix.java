package com.whs542.lib.sensors.imu;

public class Matrix
{
	int rows;
	int columns;
	double [][] data;

	public Matrix(int M, int N)
    {
    	rows = M;
        columns = N;
        data = new double[rows][columns];
    }

    public Matrix(Matrix m)
    {
        rows = m.rows;
        columns = m.columns;
        for (int i = 0; i < rows; i++ )
        {
            for(int j = 0; j < columns; j++)
            {
                data[i][j] = m.data[i][j];
            }
        }
    }

    // create matrix based on 2d array
    public Matrix(double[][] dataMatrix)
    {
        rows = dataMatrix.length;
        columns = dataMatrix[0].length;
        data = new double[rows][columns];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
               data[i][j] = dataMatrix[i][j];
            }
        }
    }

    public void setEqualTo(Matrix m)
    {
    	if (rows != m.rows || columns != m.columns) throw new RuntimeException("Illegal matrix dimensions.");

        for (int i = 0; i < rows; i++ )
        {
            for(int j = 0; j < columns; j++)
            {
                data[i][j] = m.data[i][j];
            }
        }
    }

    public Vector vectorFromRow(int rowNumber)
    {
        Vector outputVector = new Vector(columns);
        for(int i = 0; i < columns; i++)
        {
        	outputVector.setEntry(i, data[rowNumber][i]);
        }
        return outputVector;
    }

    public Vector vectorFromColumn(int columnNumber)
    {
        Vector outputVector = new Vector(rows);
        for(int i = 0; i < columns; i++)
        {
        	outputVector.setEntry(i, data[i][columnNumber]);
        }
        return outputVector;
    }

    public void rowFromVector(Vector v, int rowNumber)
    {
    	if (columns != v.n) throw new RuntimeException("Illegal vector dimensions.");

        for(int i = 0; i < columns; i++)
        {
            data[rowNumber][i] = v.getEntry(i);
        }
    }

    public void columnFromVector(Vector v, int columnNumber)
    {
    	if (rows != v.n) throw new RuntimeException("Illegal vector dimensions.");

        for(int i = 0; i < rows; i++)
        {
            data[i][columnNumber] = v.getEntry(i);
        }
    }

    public double getEntry(int row, int column)
    {
    	return data[row][column];
    }

    public void setEntry(int row, int column, double value)
    {
    	data[row][column] = value;
    }

    public Matrix add(Matrix m)
    {
    	if (rows != m.rows || columns != m.columns) throw new RuntimeException("Illegal matrix dimensions.");

        Matrix outputMatrix = new Matrix(rows, columns);
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                outputMatrix.setEntry(i,j, data[i][j] + m.getEntry(i,j));
            }
        }
        return outputMatrix;
    }

    public Matrix subtract(Matrix m)
    {
    	if (rows != m.rows || columns != m.columns) throw new RuntimeException("Illegal matrix dimensions.");

        Matrix outputMatrix = new Matrix(rows, columns);
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                outputMatrix.setEntry(i,j, data[i][j] - m.getEntry(i,j));
            }
        }
        return outputMatrix;
    }

    /*public Matrix scaleBy(double scalar)
    {

    }*/

    /*public Matrix multiplyBy(Matrix m)
    {

    }*/

    /*Matrix operator * (double scalar)
    {
        Matrix ret;
        for(int x = 0; x < N; x++)
        {
            for(int y = 0; y < N; y++)
            {
                ret._cell[x*N+y] = _cell[x*N+y] * scalar;
            }
        }
        return ret;
    }

    Matrix operator * (Matrix m)
    {
        Matrix ret;
        for(int x = 0; x < N; x++)
        {
            for(int y = 0; y < N; y++)
            {
                Vector<N> row = row_to_vector(x);
                Vector<N> col = m.col_to_vector(y);
                ret.cell(x, y) = row.dot(col);
            }
        }
        return ret;
    }

    Matrix transpose()
    {
        Matrix ret;
        for(int x = 0; x < N; x++)
        {
            for(int y = 0; y < N; y++)
            {
                ret.cell(y, x) = cell(x, y);
            }
        }
        return ret;
    }

    Matrix<N-1> minor_matrix(int row, int col)
    {
        int colCount = 0, rowCount = 0;
        Matrix<N-1> ret;
        for(int i = 0; i < N; i++ )
        {
            if( i != row )
            {
                for(int j = 0; j < N; j++ )
                {
                    if( j != col )
                    {
                        ret(rowCount, colCount) = cell(i, j);
                        colCount++;
                    }
                }
                rowCount++;
            }
        }
        return ret;
    }

    double determinant()
    {
        if(N == 1)
            return cell(0, 0);

        float det = 0.0;
        for(int i = 0; i < N; i++ )
        {
            Matrix<N-1> minor = minor_matrix(0, i);
            det += (i%2==1?-1.0:1.0) * cell(0, i) * minor.determinant();
        }
        return det;
    }

    Matrix invert()
    {
        Matrix ret;
        float det = determinant();

        for(int x = 0; x < N; x++)
        {
            for(int y = 0; y < N; y++)
            {
                Matrix<N-1> minor = minor_matrix(y, x);
                ret(x, y) = det*minor.determinant();
                if( (x+y)%2 == 1)
                    ret(x, y) = -ret(x, y);
            }
        }
        return ret;
    }*/

}