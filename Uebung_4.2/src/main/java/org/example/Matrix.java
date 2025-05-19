package org.example;



public class Matrix<T extends Number> {
    private final Number[][] value;
    private final int rows;
    private final int coloumns;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.coloumns = cols;
        this.value = new Number[rows][cols];
    }

    public void set(int row, int col, T value) {
        if (!validPosition(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        this.value[row][col] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int row, int col) {
        if (!validPosition(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) value[row][col];
    }

    private boolean validPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < coloumns;
    }

    public int getRowCount() {
        return rows;
    }

    public int getColCount() {
        return coloumns;
    }

    public Matrix<Double> add(Matrix<? extends Number> other) {
        if (rows != other.rows || coloumns != other.coloumns) {
            throw new IllegalArgumentException("Dimensions must match");
        }

        Matrix<Double> result = new Matrix<>(rows, coloumns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < coloumns; j++) {
                double sum = this.get(i, j).doubleValue() + other.get(i, j).doubleValue();
                result.set(i, j, sum);
            }
        }

        return result;
    }

    public Matrix<Double> multiply(Number scalar) {
        Matrix<Double> result = new Matrix<>(rows, coloumns);
        double factor = scalar.doubleValue();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < coloumns; j++) {
                double product = this.get(i, j).doubleValue() * factor;
                result.set(i, j, product);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            out.append("[ ");
            for (int j = 0; j < coloumns; j++) {
                Number val = value[i][j];
                out.append(val != null ? String.format("%.2f ", val.doubleValue()) : "null ");
            }
            out.append("]\n");
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Matrix<Integer> m1 = new Matrix<>(2, 2);
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(1, 0, 3);
        m1.set(1, 1, 4);

        Matrix<Double> m2 = new Matrix<>(2, 2);
        m2.set(0, 0, 0.5);
        m2.set(0, 1, 1.5);
        m2.set(1, 0, 2.5);
        m2.set(1, 1, 3.5);

        Matrix<Double> added = m1.add(m2);
        Matrix<Double> scaled = m1.multiply(2);

        System.out.println("Addition:");
        System.out.println(added);

        System.out.println("Skalarmultiplikation:");
        System.out.println(scaled);
    }
}
