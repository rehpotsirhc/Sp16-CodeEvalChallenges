#include <iostream>
using namespace std;
void main() {
    

	const int n = 8;
	int mult = 2;
	bool primes[n];

	double sum = 0;

	while(mult >= 2 && pow(mult, 2) <= n)
	{
		cout << "Mult: " << mult << endl;
		for(int i = mult * 2; i <n; i += mult)
		{
			cout << "i: " << i << endl;
			primes[i] = 1;
		}

		int prevMult = mult;
		for(int i = mult + 1; i < n; i++)
		{
			if(primes[i] == 0) 
				mult = i;	
		}

		if(mult == prevMult)
			mult = -1;
	}

	for(int i = 2; i < n; i++)
	{
		if(primes[i] == 0)
		{
			cout << i << endl;
			sum+= i;
		} 
	}

	cout << "Sum: " << sum << endl;


	for(int i = 0; i < n;i++)
	{
		cout << i << " " << primes[i] <<endl;
	}


} 