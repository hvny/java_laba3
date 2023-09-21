package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] arr1 = {                     //матрица
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {                       //запуск теста
            arrTest(arr1);

        } catch (MyArraySizeException | MyArrayDataException | MyHappyException e) {
            e.printStackTrace();
        }
    }

    static void arrTest(String[][] arr) throws MyArraySizeException, MyArrayDataException, MyHappyException {
        int sum = 0;

        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("Неверное количество столбцов");

            for (int k = 0; k < arr[i].length; k++) {
                //System.out.print(arr[i][k] + " ");

                try {
                    sum += Integer.valueOf(arr[i][k]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] исходного массива находится не целое число %s.", i+1, k+1, arr[i][k]));
                }
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    if (CheckString(arr[i][j])) {           //проверка на счастливое число
                        throw new MyHappyException("Some message");
                    }
                } catch(MyHappyException e) {
                    System.err.println(new MyHappyException(String.format("В позиции [%d][%d] исходного массива находится счастливое число %s.", i+1, j+1, arr[i][j])));
                    //System.err.println(String.format("В позиции [%d][%d] исходного массива находится счастливое число %s.", i+1, j+1, arr[i][j]));
                }
            }
            //System.out.println();
        }
        System.out.println("Сумма элементов массива: " + sum);
    }

    public static boolean CheckString(String s) { //метод проверяющий счастливую строку
        if (s.length() != 6) {
            return false;
        }
        else {
            int sumOfTheFirstGroup = 0;
            int sumOfTheSecondGroup = 0;
            String[] arrOfNums = s.split("");

            for (int i = 0; i < arrOfNums.length/2; i++) {
                sumOfTheFirstGroup += Integer.valueOf(arrOfNums[i]);
                sumOfTheSecondGroup += Integer.valueOf(arrOfNums[arrOfNums.length - 1 - i]);
            }
            //System.out.println(String.format("Строка: " + s + "Сумма первых: " + sumOfTheFirstGroup + "Сумма последних: " + sumOfTheSecondGroup));

            if (sumOfTheFirstGroup == sumOfTheSecondGroup) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}