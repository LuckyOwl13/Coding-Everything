-- Ada sample program
-- N. L. Tinkham

with Ada.Text_IO, Ada.Float_Text_IO, Ada.Numerics.Elementary_Functions;
use Ada.Text_IO, Ada.Float_Text_IO, Ada.Numerics.Elementary_Functions;

procedure Quadratic is
-- Read coefficients A, B, and C of the formula A x**2 + B x + C = 0,
-- and print the real root(s) of this polynomial.
-- Recall:  The roots are calculated using the quadratic formula:
--
--	x = -B +- sqrt(B**2 - 4 A C)
--	----------------------------
--			2 A
--
-- There may be 0, 1, or 2 real roots, depending on the sign of
-- the discriminant, B**2 - 4 A C.

	Discriminant:	float;
	A, B, C:	float;

begin
	put_line("Enter the coefficients of A x**2 + B x + C = 0:");
	put("A: ");
	get(A);
	put("B: ");
	get(B);
	put("C: ");
	get(C);
	Discriminant := B ** 2 - 4.0 * A * C;
	if Discriminant < 0.0 then
		Put_Line("There are no real roots.");
	elsif Discriminant = 0.0 then
		Put("The root is ");
		Put(-B / (2.0 * A), Exp => 0);
		Put(".");
		New_Line;
	else
		Put("The roots are ");
		Put((-B + Sqrt(Discriminant)) / (2.0 * A), Exp => 0);
		Put(" and ");
		Put((-B - Sqrt(Discriminant)) / (2.0 * A), Exp => 0);
		Put(".");
		New_Line;
	end if;
end Quadratic;