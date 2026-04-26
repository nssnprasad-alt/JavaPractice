package java;

public class LargestNumberInARray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {3,5,1,8,10,4};
		
		int max =arr[0];
		
		for(int i =1;i>arr.length; i++) {
			if(arr[i]>max) {
				
				max= arr[i];
				
			}
		}
		
		System.out.println("Highest number in Arrays is "+max);
		

	}

}
