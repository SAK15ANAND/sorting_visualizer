public class SelectionSort {
    private int array_index, compare_index, min_idx;
    private int[] a;
    private boolean min;

    public SelectionSort(int a[]) {
        this.a = a;
        array_index = 0;
        compare_index = 1;
        min_idx = 0;
        min = false;
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int[] sort() {

        if (min == false) {
            min_idx = array_index;
            min = true;
        }

        if (a[compare_index] < a[min_idx]) {
            min_idx = compare_index;
        }

        compare_index++;

        if (compare_index >= 80) {
            swap(a, min_idx, array_index);
            array_index++;
            compare_index = array_index + 1;
            min = false;
        }

        return a;
    }

    public void setArray(int a[]) {
        this.a = a;
    }

    public int[] getArray() {
        return a;
    }

    public void set_Array_index(int array_index) {
        this.array_index = array_index;
    }

    public int get_Array_Index() {
        return array_index;
    }

    public void set_Compare_Index(int compare_index) {
        this.compare_index = compare_index;
    }

    public int get_Compare_Index() {
        return compare_index;
    }

    public void set_Min_Idx(int min_idx) {
        this.min_idx = min_idx;
    }

    public int get_Min_Idx() {
        return min_idx;
    }
}
