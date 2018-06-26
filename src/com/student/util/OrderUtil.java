package com.student.util;

public class OrderUtil {

	public static void bubbleSort(int [] array,boolean isAsce){
		int x=0;
		if(isAsce){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j]>array[j+1]){
					x=array[j];
					array[j]=array[j+1];
					array[j+1]=x;
				}
				
			}
			
		}
		
		
	
		}else{
			for(int i=0;i<array.length;i++){
				for(int j=0;j<array.length-1-i;j++){
					if(array[j]<array[j+1]){
						x=array[j];
						array[j]=array[j+1];
						array[j+1]=x;
					}
					
				}
				
			}
			
			
		}
		}
	
}
