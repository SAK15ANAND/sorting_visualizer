public class InsertionSort {
    private int a[], i, j, key;
    private boolean start_of_iteration = false;

    public InsertionSort(int a[]) {
        this.a = a;
        i = 1;
    }

    public int[] sort() {

        if (start_of_iteration == false) {
            key = a[i];
            j = i - 1;
            start_of_iteration = true;
        }

        if (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
            return a;
        } else {
            a[j + 1] = key;
            i++;
        }

        start_of_iteration = false;
        return a;
    }

    public void set_Array(int a[]) {
        this.a = a;
    }

    public int[] get_Array() {
        return a;
    }

    public void set_Array_index(int i) {
        this.i = i;
    }

    public int get_Array_Index() {
        return i;
    }

    public void set_compare_index(int j) {
        this.j = j;
    }

    public int get_compare_index() {
        return j;
    }

    public void start_of_iteration(boolean start_of_iteration) {
        this.start_of_iteration = start_of_iteration;
    }

    public boolean start_of_iteration() {
        return start_of_iteration;
    }

}
