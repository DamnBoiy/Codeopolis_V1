package Logic;

public class PermutationArrays {


    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        permute(array, 0);
    }

    /**
     * Gibt alle Permutationen des Arrays aus, beginnend ab Index 'start'.
     * @param array Das zu permutierende Array.
     * @param start Der aktuelle Index, an dem die Permutation beginnt.
     */
    public static void permute(int[] array, int start) {
        if (start == array.length - 1) {
            printArray(array, 0); // Ausgabe einer Permutation
        } else {
            recursiveSwap(array, start, start);
        }
    }

    /**
     * Führt rekursives Swappen und Permutieren ohne Schleifen durch.
     * @param array Das Array.
     * @param start Aktueller Startindex für Permutationen.
     * @param i Aktueller Index zum Swappen.
     */
    private static void recursiveSwap(int[] array, int start, int i) {
        if (i >= array.length) return;

        swap(array, start, i);
        permute(array, start + 1);
        swap(array, start, i); // Rückgängig machen (Backtracking)

        recursiveSwap(array, start, i + 1); // Rekursiv zum nächsten Index
    }

    /**
     * Tauscht zwei Elemente im Array.
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Gibt das Array rekursiv aus.
     */
    private static void printArray(int[] array, int index) {
        if (index >= array.length) {
            System.out.println(" "); // avoiding Array Index out of bounds = Array ended
            return;
        }
        System.out.print(array[index] + " ");
        printArray(array, index + 1);
    }
}

/*

Code erklärt:

 permute([1,2,3], start=0)
 └── swap(0,0) → [1,2,3]
     └── permute([1,2,3], start=1)
         ├── swap(1,1) → [1,2,3]
         │   └── permute([1,2,3], start=2) → Ausgabe: 1 2 3
         └── swap(1,2) → [1,3,2]
             └── permute([1,3,2], start=2) → Ausgabe: 1 3 2
*/


