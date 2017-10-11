#include<iostream>
#include<stdio.h>

using namespace std;
void swap(int *x, int *y);

void ss(int arr[], int n){
	
	int i,min;
	for(i=0; i<n-1; i++){
	min = i;
	for(int j=i+1; j<n; j++)
	if(arr[min] > arr[j])
	min = j;
	swap(&arr[min],&arr[i]);
	}	
}


void swap(int *x, int *y){

	int temp = *x;
	*x = *y;
	*y = temp;
}

void print(int arr[], int size){
	for(int i=0; i<size; i++){
		cout<<arr[i]<<"\t";
	}
}
int main(){
	int n;
	cout<<"enter the no of elements required :";
	cin>>n;
	int arr[n];
	for(int i=0 ; i<n; i++){
		cout<<"enter the elements:"<<"\n";
		cin>>arr[i];
		
	}
	ss(arr, n);
	cout<<"sorted list:";
	print(arr, n);
	/*int arr[] = {64, 25, 12, 22, 11};
    int n = sizeof(arr)/sizeof(arr[0]);
    ss(arr, n);
    cout<<"Sorted array: \n";
    print(arr, n);
    return 0;*/
	return 0;
}
