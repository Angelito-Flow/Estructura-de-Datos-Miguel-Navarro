public class Main {

    public static void main(String[] args) {
        int[] array = {105, 27, 500, 0, 58, 82, 10};
        System.out.println("\nArreglo inicial:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nArreglo ordenado:");
        printArray(array);
    }

    // esta es la función principal para dividir y ordenar el arreglo
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // se dividir en mitades
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // se fusionar las mitades ordenadas
            merge(array, left, middle, right);
        }
    }

    // la función para fusionar dos mitades ordenadas
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // copia datos a arreglos temporales
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        // fusiona los subarreglos en array[]
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copia elementos restantes de leftArray[]
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // copia elementos restantes de rightArray[]
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // función para imprimir el arreglo
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}