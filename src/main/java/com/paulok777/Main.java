package com.paulok777;

import com.paulok777.generators.CaveGenerator;
import com.paulok777.populators.SurroundedHomaPopulator;
import com.paulok777.populators.SurroundedTreasurePopulator;

public class Main {

    public static void main(String[] args) {
        String[][] cave1 = new CaveGenerator(new SurroundedHomaPopulator()).generateWinlessCave();
        String[][] cave2 = new CaveGenerator(new SurroundedTreasurePopulator()).generateWinlessCave();
        printMatrix(cave1);
        System.out.println();
        printMatrix(cave2);
    }

    public static void printMatrix(Object[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                String value = matrix[i][j] == null ? "null" : matrix[i][j].toString();
                if (j == matrix[i].length - 1) {
                    System.out.printf("%10s|\n", value);
                } else {
                    System.out.printf("%10s|", value);
                }
            }
        }
    }
}
