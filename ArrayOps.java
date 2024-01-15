public class ArrayOps {
    public static void main(String[] args) {
        System.out.println(secondMaxValue(new int[] {10, 9, 8, 6}));
    }
    
    public static int findMissingInt (int [] array) {
        // Write your code here:
        int[] arrNums = new int[(array.length + 1)];
        int missingNum = -1;

        for (int i = 0; i < array.length; i++) {
            arrNums[array[i]] = 1;
        }

        for (int i = 0; i < arrNums.length; i++) {
            if (arrNums[i] == 0) {
                missingNum = i;
            }
        }

        return missingNum;
    }

    public static int secondMaxValue(int [] array) {
        // Write your code here:
        int firstMax = -1;
        int secondMax = -1;
        int firstMaxIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstMax) {
                firstMax = array[i];
                firstMaxIndex = i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] > secondMax) && (i != firstMaxIndex)) {
                secondMax = array[i];
            }
        }

        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
       int[] sameArray1 = new int[array1.length];
       int[] sameArray2 = new int[array2.length];
       boolean same = true;

       // is array1 a subset of array2?
       for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    sameArray1[i] = 1;
                }
            }
       }

       for (int i = 0; i < sameArray1.length; i++) {
            if (sameArray1[i] == 0) {
                same = false;
            }
       }


       // is array2 a subset of array1?
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array2[i] == array1[j]) {
                    sameArray2[i] = 1;
                }
            }
        }

        for (int i = 0; i < sameArray2.length; i++) {
            if (sameArray2[i] == 0) {
                same = false;
            }
        }
       
        return same;
    }

    public static boolean isSorted(int [] array) {
        boolean sorted = true;

        // We define incdec = 1 if increasing, incdec = -1 if decreasing
        int incdec = 1;
        if (array.length >= 2) {
            if ((array[1] < array[0])) {
                incdec = -1;
            }

            for (int i = 0; i < (array.length - 1); i++) {
                if (incdec == 1) { 
                    if ((array[i]) > (array[i + 1])) {
                        sorted = false;
                    }
                }
                else if (incdec == -1) {
                    if ((array[i]) < (array[i + 1])) {
                        sorted = false;
                    }
                }
            }
        }
        return sorted;
    }
}
