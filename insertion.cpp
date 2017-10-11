#include<iostream>
#include<stdio.h>
using namespace std;

void is(int arr[], int n){
	
	int i,k,j;
	for(i=1; i<n; i++){
		k= arr[i];
		j=i-1;
		while(j>=0 && arr[j]>k){
			arr[j+1] = arr[j];
			j=j-1;
		}
		arr[j+1] = k;
	}
}

void print(int arr[], int size){
	for(int i=0; i<size; i++){
		cout<<arr[i]<<"\n";
	
	}
}

int main(){
	int n;
	cout<<"enter the number of elements required:";
	cin>>n;
	int arr[n];
	for(int i=0; i<n; i++){
		cout<<"enter the element:";
		cin>>arr[i];
	}
	is(arr, n);
	print(arr, n);
	return 0;
}
