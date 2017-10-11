#include<iostream>
#include<stdlib.h>

using namespace std;
void swap(int *x, int *y){
	int temp = *x;
	*x=*y;
	*y=temp;
}

int partion(int arr[], int p,int r){
	int x,i,j;
	 x=arr[r];
	i = p-1;
	for(j=p; j<=r-1; j++){
		if(arr[j]<=x){
		i++;
		swap(&arr[i],&arr[j]);
		}
	}
	swap(&arr[i+1], &arr[r]);
	return i+1;

}
void quicksort(int arr[], int p, int r){
	if(p<r){
		int q = partion(arr, p, r);
		quicksort(arr, p, q-1);
		quicksort(arr, q+1,r);
	}
}
void print(int arr[], int size){
	for(int i=0; i<size; i++){
		cout<<arr[i];
		cout<<"\n";
			
	}
}
int main(){
	int n, i;
	cout<<"range of list";
	cin>>n;
	int arr[n];
	for(i=0; i<n; i++){
		cout<<"enter the element:";
		cin>>arr[i];
	}
	quicksort(arr, 0, n-1);
	print(arr, n);
	
	return 0;
	
}
