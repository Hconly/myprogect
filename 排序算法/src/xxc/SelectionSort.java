package xxc;


public class SelectionSort {
	public static void main(String[] args) {
		int  [] arr = {1,2,4,9,6,5,0};
		int count  = 0;
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					minIndex = i;
				}
			}
			if(minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
				count++;
			}
		}
		System.out.println(count);
		System.out.println(arr);
	}
}
