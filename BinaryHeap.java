import java.util.Arrays;

public class BinaryHeap {
	
	public int[] arr;
	public int size;
	
	public BinaryHeap() {
		arr = new int[10];
		size = 0;
	}
	
	private int parent(int index) {
		return (index - 1) / 2;
	}
	
	private int leftChild(int index) {
		return (2 * index + 1);
		
	}
	
	private int rightChild(int index) {
		return (2 * index + 2);
	}
	
	private void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
		
	public void add(int num) {
		arr[size++] = num;
		
		int current = size - 1;
		
		while (arr[current] < arr[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public int remove() {
		int min = arr[0];
		arr[0] = arr[--size];
		minHeapify(0);
		return min;
	}
	
	private void minHeapify(int index) {
		if (index < size / 2) {
			if (arr[index] > arr[leftChild(index)] || arr[index] > arr[rightChild(index)]) {
				if (arr[leftChild(index)] < arr[rightChild(index)]) {
					swap(index, leftChild(index));
					minHeapify(leftChild(index));
				} else {
					swap(index, rightChild(index));
					minHeapify(rightChild(index));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryHeap heap = new BinaryHeap();
		heap.add(3);
		heap.add(2);
		heap.add(1);
		
		System.out.println(Arrays.toString(heap.arr));
		
	}
}
