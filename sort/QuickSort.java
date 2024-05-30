public class QuickSort {

    private int[] a, stack;
    private int left, right, top, array_index, compare_index, pivot, partition;
    private boolean isPartioning = false;

    public QuickSort(int[] a) {
        this.a = a;
        stack = new int[80];
        left = 0;
        right = 79;
        array_index = 0;
        compare_index = 0;
        pivot = 0;
        partition = -1;
        top = -1;
        stack[++top] = 0;
        stack[++top] = 79;
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int[] sort() {
        if (top >= 0) {

            if (isPartioning == false) {
                right = stack[top--];
                left = stack[top];
                array_index = left - 1;
                pivot = a[right];
                compare_index = left;
                isPartioning = true;
            }

            if (compare_index <= right - 1) {

                if (a[compare_index] <= pivot) {
                    array_index++;
                    swap(a, array_index, compare_index);
                }

                compare_index++;
                return a;
            }

            swap(a, array_index + 1, right);
            partition = array_index + 1;
            top--;

            if (partition - 1 > left) {
                stack[++top] = left;
                stack[++top] = partition - 1;
            }

            if (partition + 1 < right) {
                stack[++top] = partition + 1;
                stack[++top] = right;
            }

            isPartioning = false;
        }

        return a;
    }

    public void push(int val) {
        top++;
        stack[top] = val;
    }

    public void setArray(int[] a) {
        this.a = a;
    }

    public int[] getArray() {
        return a;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int geteft() {
        return left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getRight() {
        return right;
    }

    public void setArrayIndex(int array_index) {
        this.array_index = array_index;
    }

    public int get_Array_Index() {
        return array_index;
    }

    public void setCompareIndex(int compare_index) {
        this.compare_index = compare_index;
    }

    public int getCompareIndex() {
        return compare_index;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public int getPartition() {
        return partition;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getTop() {
        return top;
    }

    public void setIsPartioning(boolean isPartioning) {
        this.isPartioning = isPartioning;
    }

    public boolean getIsPartitioning() {
        return isPartioning;
    }
}
