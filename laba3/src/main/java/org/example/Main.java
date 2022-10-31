package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            arrTest(arr1);

        } catch (MyArraySizeException e) {
            e.printStackTrace();

        } catch (MyArrayDataException e){
            e.printStackTrace();
        }

    }

    static void arrTest(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("Неверное количество столбцов");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                try {
                    sum += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] исходного массива находится не целое число %s.", i, j, arr[i][j]));
                }
            }
            System.out.println();
        }
        System.out.println("Сумма элементов массива: " + sum);
    }
}