#include<iostream>
#include<stdlib.h>

using namespace std;
void swap(int *x, int *y){
	int temp = *x;
	*x = *y;
	*y = temp;
}
void bubblesort(int arr[], int n){
	for(int i=n-1; i>=0; i--){
		for(int j=0; j<i; j++){
			if(arr[j]>arr[j+1]){
			swap(&arr[j],&arr[j+1]);
			}
		}
	}
}
void print(int arr[],int size){
	for(int i=0; i<size; i++){
		cout<<arr[i];
		cout<<"\n";
	}
}
int main(){
	int n,i;
	cout<<"range of list";
	cin>>n;
	int arr[n];
	for(int i=0; i<n; i++){
	cout<<"enter the element";
	cin>>arr[i];
	}
	bubblesort(arr, n);
	print(arr, n);
	return 0;
}
