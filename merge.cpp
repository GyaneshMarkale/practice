#include<iostream>
#include<stdlib.h>

using namespace std;

void merge(int arr[],int p, int q, int r){
	int n1, n2;
	n1=q-p+1;
	n2=r-q;
	int l1[n1], l2[n2];
	for(int i=0; i<n1; i++)
	l1[i] = arr[p+i];
	for(int j=0; j<n2; j++)
	l2[j] = arr[q+j+1];
	
	int i= 0, j=0,k=p;
	//for(k=p; k<r; k++){
	while(i<n1 && j<n2){
	
	if(l1[i]<=l2[j]){
	arr[k] = l1[i];
	i++;
	}
	else{
	arr[k] = l2[j];
	j++;
	}
	k++;
	}
	while(i<n1){
	arr[k]= l1[i];
	i++;
	k++;
	}
	while(j<n2){
	arr[k]= l2[j];
	j++;
	k++;
	}
}
void mergesort(int arr[], int p, int r){
	if(p<r){
		int q=(p+(r-1))/2;
		mergesort(arr,p,q);
		mergesort(arr,q+1,r);
		merge(arr,p,q,r);
	}

}
void print(int arr[], int size){
	for(int i=0; i<size; i++){
		cout<<arr[i]<<"\t";
	}

}
int main(){
	int n, i;
	cout<<"range of list";
	cin>>n;
	int arr[n];
	for(i=0; i<n; i++){
		cout<<"enter the element:\n";
		cin>>arr[i];
	}
	mergesort(arr, 0, n-1);
	print(arr, n);
	
	return 0;
	
}
