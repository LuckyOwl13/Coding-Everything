-- N. L. Tinkham
-- Illustrates fixed-length strings, records, and I/O.

-- Read a list of zip codes, ending with a dot on a line by itself.
-- Count the occurrences of Glassboro (08028), Pitman (08071), 
-- Mantua (08051), and "other" (anything else), and print these counts.
-- Revised February 2016


with Ada.Text_IO, Ada.Integer_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO;

procedure Zip is

	NumDifferentTowns: constant Integer := 4;	-- 3 towns' zip codes + "other"

	subtype Zip5 is string(1..5);			-- 5-digit zip code
	
	type ZipCount is record
		Zip: Zip5;
		Count: Natural;
	end record;
	type ZipCountList is array(1..NumDifferentTowns) of ZipCount;

	Tally: ZipCountList;
	
	NumZips: Integer;	-- The number of zip codes in the input
	NextZip: Zip5;		-- The next zip code in the input

begin

	Tally(1).Zip := "08028";
	Tally(2).Zip := "08071";
	Tally(3).Zip := "08051";
	Tally(4).Zip := "other";
	for I in 1..NumDifferentTowns loop
		Tally(I).Count := 0;
	end loop;

	Put("How many zip codes will you be entering? ");
	Get(NumZips);
	for I in 1..NumZips loop
		Get(NextZip);

		if NextZip = "08028" then
			Tally(1).Count := Tally(1).Count + 1;
		elsif NextZip = "08071" then
			Tally(2).Count := Tally(2).Count + 1;
		elsif NextZip = "08051" then
			Tally(3).Count := Tally(3).Count + 1;
		else
			Tally(4).Count := Tally(4).Count + 1;
		end if;
	end loop;

	New_Line;
	for I in 1..NumDifferentTowns loop
		Put(Tally(I).Zip);
		Put(Tally(I).Count);
		New_Line;
	end loop;
end Zip;