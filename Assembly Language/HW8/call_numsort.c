/*This file is made by Hsin Han Wu*/
/*ID:403530026*/
#include <stdio.h>

extern int* NumSort (int, int*);

int main(){
	int* result;
	
	//initial a integer array
	int array[] = {4, 9, 5};
	//call NumSort function
	int array_size = sizeof(array);
	result = NumSort (array_size, array);
	
	//print out integer array
	int i;
	for(i = 0;i < array_size;i++){
		printf("%d ", result[i]);
	}
	
	return 0;
}
