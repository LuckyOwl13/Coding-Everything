-- Caitlin E. McElwee

-- Reads input containing an integer N on a line by itself, representing the number of patients in the list. 
-- This is followed by N lines, each containing four integers: 
-- a patient number, then three numbers (1 or 0) for whether patient has disease, tested pos on test 1, tested pos on test 2.
-- The output is four conditional probabilities:
-- P(Diseased|Pos1)
-- P(Diseased|Pos2)
-- P(Healthy|Pos1)
-- P(Healthy|Pos2)
-- Then one of the following three messages: "Test 1 is better", "Test 2 is better", or "Neither test is better".

-- Revised October 2017

with Ada.Text_IO, Ada.Integer_Text_IO, Ada.Float_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO, Ada.Float_Text_IO;

procedure medcomparer is
	
	Total: Integer;	-- Count of all patients there will be
	
	type Patient is record	-- Data type for patients
		num:   Float;
		sick:  Float;
		test1: Float;
		test2: Float;
	end record;
	
	Best_Test: Integer := 0;  -- Integer to store best test, default neither
	
	-- Procedure for collecting patient data
	function Run_Analysis(Total: in Integer) return Integer is
		
		betterTest: Integer;
		
		type PatientList is array(1..Total) of Patient;

		List: PatientList; -- Collection of all Patient records
		
		
		YesSick1: Float := 0.0;		-- # rightly sick patients for test1
		YesSick2: Float := 0.0;		-- # rightly sick patients for test2
		
		YesFine1: Float := 0.0;		-- # rightly fine patients for test1
		YesFine2: Float := 0.0;		-- # rightly fine patients for test2
		
		Pos1Count: Float := 0.0;	-- # patients who were positive for test1
		Pos2Count: Float := 0.0;	-- # patients who were positive for test2
		
		Neg1Count: Float := 0.0;   -- # patients who were negitive for test1
		Neg2Count: Float := 0.0;   -- # patients who were negitive for test2
		
		DgivenPos1: Float := 0.0;  -- P(D | Pos1)
		DgivenPos2: Float := 0.0;  -- P(D | Pos2)
		HgivenPos1: Float := 0.0;  -- P(H | Neg1)
		HgivenPos2: Float := 0.0;  -- P(H | Neg2)
		
		Results: array(1..2) of Float;
		
	begin
		for I in 1..Total loop
			-- Intake next patient's stats
			Put("Next: ");		
			Get(List(I).num);
			Get(List(I).sick);
			Get(List(I).test1);
			Get(List(I).test2);
			
			-- Echo said patient's stats
			Put(List(I).num, Aft => 0, Exp => 0);	
			Put(List(I).sick, Aft => 0, Exp => 0);
			Put(List(I).test1, Aft => 0, Exp => 0);
			Put(List(I).test2, Aft => 0, Exp => 0);
			
			
			if List(I).sick = 0.0 then	-- Given the patient is actually healthy...
				if List(I).test1 = 0.0 then	-- Test1 correctly ignored healthy patient
					YesFine1:= YesFine1 + 1.0;
					Neg1Count:= Neg1Count + 1.0;
				else	-- Test1 falsely flagged healthy patient
					Pos1Count:= Pos1Count + 1.0;
				end if;
				if List(I).test2 = 0.0 then	-- Test2 correctly ignored healthy patient
					YesFine2:= YesFine2 + 1.0;
					Neg2Count:= Neg2Count + 1.0;
				else	-- Test2 falsely flagged healthy patient
					Pos2Count:= Pos2Count + 1.0;
				end if;
			else	-- Given the patient is actually sick...
				if List(I).test1 =1.0 then	-- Test1 correctly flagged diseased patient
					YesSick1 := YesSick1 + 1.0;
					Pos1Count:= Pos1Count + 1.0;
				else	-- Test1 falsely ignored diseased patient
					Neg1Count:= Neg1Count + 1.0;
				end if;
				if List(I).test2 = 1.0 then	-- Test2 correctly flagged diseased patient
					YesSick2 := YesSick2 + 1.0;
					Pos2Count:= Pos2Count + 1.0;
				else	-- Test2 falsely ignored diseased patient
					Neg2Count:= Neg2Count + 1.0;
				end if;
			end if;
			
			New_Line;
		end loop;	-- end for
		
		
		-- Calculate probabilities
		DgivenPos1 := YesSick1 / Pos1Count;
		DgivenPos2 := YesSick2 / Pos2Count;
		HgivenPos1 := YesFine1 / Neg1Count;
		HgivenPos2 := YesFine2 / Neg2Count;
		
		
		-- Calculate the results: which test is better for 1) detecting the sick and 2) ignoring the healthy?
		Results(1) := DgivenPos1 - DgivenPos2;  -- If pos, test1 better; if neg, test2 better.
		Results(2) := HgivenPos1 - HgivenPos2;  -- If 0, equal.
		
		
		-- Figure out which test is better: if both positive, test1 better; if both negative, test2 better. If mixed or even, no test better
		if (Results(1) > 0.0) and (Results(2) > 0.0) then
			betterTest := 1;
		elsif (Results(1) < 0.0 and Results(2) < 0.0) then
			betterTest := 2;
		end if;
		
		
		-- Print resulting probabilities
		New_Line;
		Put("P(D | Pos1) = ");
		Put(DgivenPos1, Aft => 2, Exp => 0);
		New_Line;
		Put("P(D | Pos2) = ");
		Put(DgivenPos2, Aft => 2, Exp => 0);
		New_Line;
		Put("P(H | Neg1) = ");
		Put(HgivenPos1, Aft => 2, Exp => 0);
		New_Line;
		Put("P(H | Neg2) = ");
		Put(HgivenPos2, Aft => 2, Exp => 0);
		New_Line;
		
		return betterTest;
	end Run_Analysis;
	-- End Procedure for collecting patient data
	
begin	-- medComparer

	Put("How many patients? ");
	Get(Total);
	Put(Total);
	New_Line;
	
	Best_Test := Run_Analysis(Total);
	
	New_Line;
	if Best_Test = 1 then
		Put("Test 1 is better");
	elsif Best_Test = 2 then
		Put("Test 2 is better");
	else
		Put("Neither test is better");
	end if;
	
end medcomparer;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	