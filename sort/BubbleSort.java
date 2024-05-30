public class BubbleSort {
    private int a[], i, j; // i=array index and j=compare index

    public BubbleSort(int a[]) {
        this.a = a;
        i = 0;
        j = Integer.MAX_VALUE;
    }

    public int[] sort() {
        if (a[j] > a[j + 1]) {
            int temp = a[j];
            a[j] = a[j + 1];
            a[j + 1] = temp;
        }
        if ((j + 1) >= (a.length - i - 1)) {
            i++;
            j = 0;
        } else {
            j++;
        }
        return a;
    }

    public int[] get_Array() {
        return a;
    }

    public void set_Array(int a[]) {
        this.a = a;
    }

    public int get_Array_index() {
        return i;
    }

    public void set_Array_Index(int i) {
        this.i = i;
    }

    public void set_Compare_index(int j) {
        this.j = j;
    }

    public int get_Compare_index() {
        return j;
    }

}
