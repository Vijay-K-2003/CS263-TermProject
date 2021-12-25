class HeapSort {

    public void heapify(DoublyLinkedList a, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        // If left child is larger than root
        if (left < n && (a.get(left).data.name.compareTo(a.get(largest).data.name) > 0))
            largest = left;
        // If right child is larger than root
        if (right < n && (a.get(right).data.name.compareTo(a.get(largest).data.name) > 0))
            largest = right;
        // If root is not largest
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