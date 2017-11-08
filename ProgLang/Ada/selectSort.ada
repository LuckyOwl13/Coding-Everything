-- Ada sample program
-- N. L. Tinkham

with Ada.Text_IO, Ada.Integer_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO;

procedure Order is
-- Read a collection of integers and print them in increasing order
	Last_Index: constant Integer := 10;
	subtype Numarray_Index is Integer range 1..Last_Index;
	type Numarray is array(Numarray_Index) of Integer;
	A: Numarray;
	
	procedure Selection_Sort(A: in out Numarray) is
	-- Sort A, using selection sort
		Index_Biggest: Numarray_Index;

		procedure Swap(A: in out Numarray;
		               Index1, Index2: in Numarray_Index) is
		-- Exchange the array items at locations Index1 and Index2
			Temp: Integer;
		begin
			Temp := A(Index1);
			A(Index1) := A(Index2);
			A(Index2) := Temp;
		end Swap;

		function Array_Max(A: in Numarray;
			Highest_Index: in Numarray_Index)
			return Numarray_Index is
		-- Return the location of the largest element of A in the
		-- range 1..Highest_Index
			Loc_Biggest: Numarray_Index;
		begin
			Loc_Biggest := 1;
			for Current in 2..Highest_Index loop
				if A(Current) > A(Loc_Biggest) then
					Loc_Biggest := Current;
				end if;
			end loop;
			return Loc_Biggest;
		end Array_Max;

	begin -- Selection_Sort
		for Last_Unsorted in reverse 2..A'last loop
			-- Find the biggest number in the unsorted part
			-- of A, and swap it with the last number in the
			-- unsorted part of A.
			Index_Biggest := Array_Max(A, Last_Unsorted);
			Swap(A, Index_Biggest, Last_Unsorted);
		end loop;
	end Selection_Sort;

	procedure Get_Number(Num: out Integer) is
	-- Read a valid integer value for Num
	begin
		Get(Num);
	exception
	   when Data_Error | Constraint_Error =>
		Skip_Line;	-- Skip any remaining characters on line
		Put("Error: Invalid number.  Please re-enter the number.");
		Get_Number(Num);
	end Get_Number;

begin
	Put("Enter ");
	Put(Item => Last_Index, Width => 0);   -- No extra spaces before number
	Put(" Numbers: ");
	New_Line;
	for I in Numarray_Index loop
		Get_Number(A(I));
	end loop;
	Selection_Sort(A);
	New_Line;
	Put("Sorted list of numbers:");
	New_Line;
	for I in Numarray_Index loop
		Put(A(I));
		New_Line;
	end loop;
end order;