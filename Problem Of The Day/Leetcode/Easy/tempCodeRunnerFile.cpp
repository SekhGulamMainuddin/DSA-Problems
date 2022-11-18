 int flag=0;

    for(int i=2;i<size;i++){
        if(n%primeNumbers[i]==0 && primeNumbers[i]!=2 && primeNumbers[i]!=3 && primeNumbers[i]!=5){
            flag=1;
            break;
        }
    }

    if(flag)
        cout<<"Not an Ugly Number"<<endl;
    else
        cout<<"Ugly Number"<<endl;