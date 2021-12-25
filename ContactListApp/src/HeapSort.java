package CS263;
class HeapSort {

    public void heapify(DoublyLinkedList a, int n, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && (a.get(left).data.mobile_number.compareTo(a.get(largest).data.mobile_number) > 0))
            largest = left;

        if (right < n && (a.get(right).data.mobile_number.compareTo(a.get(largest).data.mobile_number) > 0))
            largest = right;

        if (largest != i) {

            Node temp = a.get(largest);
            Node temp1 = a.get(i);
            Node temp2 = a.get(i);
            temp1 = temp;
            temp = temp2;

            heapify(a, n, largest);
        }
    }

    public void heapSort(DoublyLinkedList a, int n)
    {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);
        for (int i = n - 1; i >= 0; i--) {
            Node temp = a.get(0);
            Node temp1 = a.get(i);
            Node temp2 = a.get(i);
            temp1 = temp;
            temp = temp2;

            heapify(a, i, 0);
        }
    }
}