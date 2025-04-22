package com.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingUtility {


    /*
       Please write a Java program of Gnome Sort that uses iteration to
       achieve a sorting of Comparable objects
    */

    public static <T extends Comparable<T>> void gnomeSort(T[] data) {

        // TODO implement Gnome Sort here

        int pos = 0;

        while (pos < data.length) {
            if (pos == 0 || data[pos].compareTo(data[pos - 1]) >= 0) {
                pos = pos + 1;
            } else {
                // swap a[pos] and a[pos - 1]
                T temp = data[pos];
                data[pos] = data[pos - 1];
                data[pos - 1] = temp;
                pos = pos - 1;
            }
        }
    }

        /*
           Please write a Java program of Cocktail Shaker Sort which is a modified
           type of bubble sort to sort Comparable objects
        */

    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {

        // TODO implement Cocktail Shaker Sort here

        boolean swapped;

        do {
            swapped = false;

            // Forward pass
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    // Swap elements
                    T temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break; // No swaps, array is sorted
            }

            swapped = false;

            // Backward pass
            for (int i = data.length - 2; i >= 0; i--) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    // Swap elements
                    T temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    swapped = true;
                }
            }

        } while (swapped);
    }

    /*
       Please write a Java program of Shell Sort which is a generalization of
       insertion sort to sort Comparable objects.

       Create 'gaps' as an ArrayList and fill it with the values in the pseudo code
       below. Also, the input array is going to be of Comparable objects.

       gaps = [701, 301, 132, 57, 23, 10, 4, 1]
    */


    public static <T extends Comparable<T>> void shellSort(T[] data) {

        // TODO implement Shell Sort here

        ArrayList<Integer> gaps = new ArrayList<>(Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1));
        int n = data.length;

        // Start with the largest gap and work down to a gap of 1
        for (int gap : gaps) {
            // Gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                T temp = data[i];
                int j = i;

                // Shift earlier gap-sorted elements up until correct location is found
                while (j >= gap && data[j - gap].compareTo(temp) > 0) {
                    data[j] = data[j - gap];
                    j -= gap;
                }

                // Put temp (original a[i]) in its correct location
                data[j] = temp;
            }
        }
    }


    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





