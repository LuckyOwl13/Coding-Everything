/* By Caitlin McElwee
Reads input containing an integer N on a line by itself, representing the number of patients in the list. 
This is followed by N lines, each containing four integers: 
	a patient number, then three numbers (1 or 0) for whether patient has disease, tested pos on test 1, tested pos on test 2.
The output is four conditional probabilities:
	P(Diseased|Pos1)
	P(Diseased|Pos2)
	P(Healthy|Pos1)
	P(Healthy|Pos2)
Then one of the following three messages: "Test 1 is better", "Test 2 is better", or "Neither test is better".

Revised October 2017
*/
int count;
cout << "How many patients? ";
cin >> count;

float YesSick1 = 0.0;
float Pos1 = 0.0;

float YesSick2 = 0.0;
float Pos2 = 0.0;

float YesFine1 = 0.0;
float Neg1 = 0.0;

float YesFine2 = 0.0;
float Neg2 = 0.0;


int number, isSick, test1, test2;
for (int i = 1; i <= count; i++){
	cout << "Next: "
	cin >> number >> isSick >> test1 >> test2;
	cout << number << " " << isSick << " " << test1 << " " << test2;
	
	if (isSick = 0){
		if (test1 = 0){
			YesFine1 += 1.0;
			Neg1 += 1.0;
		}	// end if test1
		else Pos1 += 1.0;	// end else test1
		if (test2 = 0){
			YesFine2 += 1.0;
			Neg2 += 1.0;
		}	// end if test2
		else Pos2 += 1.0;// end else test2
	}	// end if
	else {
		if (test1 = 1){
			YesSick1 += 1.0;
			Pos1 += 1.0;
		}	// end if test1
		else Neg1 += 1.0;	// end else test1
		if (test2 = 1){
			YesSick2 += 1.0;
			Pos2 += 1.0;
		}	// end if test2
		else Neg2 += 1.0;// end else test2
	}	// end else
}	// end for


float DgivenPos1 = 0.0, DgivenPos2 = 0.0, HgivenPos1 = 0.0, HgivenPos2 = 0.0;

DgivenPos1 = YesSick1 / Pos1;
DgivenPos2 = YesSick2 / Pos2;
HgivenPos1 = YesFine1 / Neg1;
HgivenPos2 = YesFine2 / Neg2;

cout << "P(D | Pos1) = " << DgivenPos1 << "\n";
cout << "P(D | Pos2) = " << DgivenPos2 << "\n";
cout << "P(H | Neg1) = " << HgivenPos1 << "\n";
cout << "P(H | Neg2) = " << HgivenPos2 << "\n";

if (DgivenPos1 > DgivenPos2 && HgivenPos1 > HgivenPos2) cout << "Test 1 is better";
else if (DgivenPos1 < DgivenPos2 && HgivenPos1 < HgivenPos2) cout << "Test 2 is better";
else cout << "Neither test is better";