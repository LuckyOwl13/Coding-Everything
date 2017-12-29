% medical_test(+List, -ProbDPos1, -ProbDPos2, -ProbHNeg1, -ProbHNeg2, -Best)
%
% ProbDPos1 is P(D | Pos1)
% ProbDPos2 is P(D | Pos2)
% ProbHNeg1 is P(H | Neg1)
% ProbHNeg2 is P(H | Neg2)
% Best is "test1" when ProbDPos1 > ProbDPos2 and ProbHNeg1 > ProbHNeg2;
%	is "test2" when ProbDPos1 < ProbDPos2 and ProbHNeg1 < ProbHNeg2;
%	is "neither" if neither of those two are true.
%
% List is of the construction [ Nested | T ] where Nested is of the form [+Patient, +Sick, +Test1, +Test2]
% 	Patient is the patient's number, 
% 	Sick is 0 (healthy) or 1 (sick), 
% 	Test1 is 0 (ignored) or 1 (flagged),
% 	Test2 is 0 (ignored) or 1 (flagged).
medical_test(List, ProbDPos1, ProbDPos2, ProbHNeg1, ProbHNeg2, test1) :- 
	sick_sort(List, Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2),
	ProbDPos1 is Sick1 / Pos1, % # people flagged sick by test1 correctly / # people flagged by test1 total
	ProbDPos2 is Sick2 / Pos2, % # people flagged sick by test2 correctly / # people flagged by test2 total
	ProbHNeg1 is Fine1 / Neg1, % # people ignored by test1 correctly / # people ignored by test1 total
	ProbHNeg2 is Fine2 / Neg2, % # people ignored by test1 correctly / # people ignored by test1 total
	ProbDPos1 > ProbDPos2,
	ProbHNeg1 > ProbHNeg2.
medical_test(List, ProbDPos1, ProbDPos2, ProbHNeg1, ProbHNeg2, test2) :- 
	sick_sort(List, Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2),
	ProbDPos1 is Sick1 / Pos1, % # people flagged sick by test1 correctly / # people flagged by test1 total
	ProbDPos2 is Sick2 / Pos2, % # people flagged sick by test2 correctly / # people flagged by test2 total
	ProbHNeg1 is Fine1 / Neg1, % # people ignored by test1 correctly / # people ignored by test1 total
	ProbHNeg2 is Fine2 / Neg2, % # people ignored by test1 correctly / # people ignored by test1 total
	ProbDPos1 < ProbDPos2,
	ProbHNeg1 < ProbHNeg2.
medical_test(List, ProbDPos1, ProbDPos2, ProbHNeg1, ProbHNeg2, neither) :- 
	sick_sort(List, Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2),
	ProbDPos1 is Sick1 / Pos1, % # people flagged sick by test1 correctly / # people flagged by test1 total
	ProbDPos2 is Sick2 / Pos2, % # people flagged sick by test2 correctly / # people flagged by test2 total
	ProbHNeg1 is Fine1 / Neg1, % # people ignored by test1 correctly / # people ignored by test1 total
	ProbHNeg2 is Fine2 / Neg2. % # people ignored by test1 correctly / # people ignored by test1 total


% sick_sort( +List, +Sick1, +Sick2, +Fine1, +Fine2, +Pos1, +Pos2, +Neg1, +Neg2, -ProbDPos1, -ProbDPos2, -ProbHNeg1, -ProbHNeg2)
% Recursively processes each nested list in List and:
% 	if Sick == 0 & Test1 == 0 & Test2 == 0, Fine1 is RFine1 + 1, Neg1 is RNeg1 + 1, Fine2 is RFine2 + 1, Neg2 is RNeg2 + 1.
% 	if Sick == 0 & Test1 == 0 & Test2 == 1, Fine1 is RFine1 + 1, Neg1 is RNeg1 + 1, Pos2 is RPos2 + 1.
% 	if Sick == 0 & Test1 == 1 & Test2 == 0, Pos1 is RPos1 + 1, Fine2 is RFine2 + 1, Neg2 is RNeg2 + 1.
% 	if Sick == 0 & Test1 == 1 & Test2 == 1, Pos1 is RPos1 + 1, Pos2 is RPos2 + 1.
% 	if Sick == 1 & Test1 == 0 & Test2 == 0, Neg1 is RNeg1 + 1, Neg2 is RNeg2 + 1.
% 	if Sick == 1 & Test1 == 0 & Test2 == 1, Neg1 is RNeg1 + 1, Sick2 is RSick2 + 1, Pos2 is RPos2 + 1.
% 	if Sick == 1 & Test1 == 1 & Test2 == 0, Sick1 is RSick1 + 1, Pos1 is RPos1 + 1, Neg2 is RNeg2 + 1.
% 	if Sick == 1 & Test1 == 1 & Test2 == 1, Sick1 is RSick1 + 1, Pos1 is RPos1 + 1, Sick2 is RSick2 + 1, Pos2 is RPos2 + 1.
sick_sort([], 0, 0, 0, 0, 0, 0, 0, 0).
sick_sort([ [_, 0, 0, 0] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Fine1 is RFine1 + 1,% test1 correctly ignored
	Neg1 is RNeg1 + 1,
	Fine2 is RFine2 + 1,% test2 correctly ignored
	Neg2 is RNeg2 + 1,
	
	Sick1 is RSick1,	% variables unused this time are passed upward
	Pos1 is RPos1,
	Sick2 is RSick2,
	Pos2 is RPos2.
sick_sort([ [_, 0, 0, 1] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Fine1 is RFine1 + 1,% test1 correctly ignored
	Neg1 is RNeg1 + 1,
	Pos2 is RPos2 + 1,	% test2 incorrectly flagged
	
	Sick1 is RSick1,	% variables unused this time are passed upward
	Pos1 is RPos1,
	Sick2 is RSick2, 
	Fine2 is RFine2,
	Neg2 is RNeg2.
sick_sort([ [_, 0, 1, 0] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Pos1 is RPos1 + 1,	% test1 incorrectly flagged
	Fine2 is RFine2 + 1,% test2 correctly ignored
	Neg2 is RNeg2 + 1,	
	
	Sick1 is RSick1,	% variables unused this time are passed upward
	Sick2 is RSick2,
	Pos2 is RPos2,
	Fine1 is RFine1,
	Neg1 is RNeg1.
sick_sort([ [_, 0, 1, 1] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Pos1 is RPos1 + 1,	% test1 incorrectly flagged
	Pos2 is RPos2 + 1,	% test2 incorrectly flagged
	
	Sick1 is RSick1,	% variables unused this time are passed upward
	Sick2 is RSick2,
	Fine1 is RFine1,
	Neg1 is RNeg1,
	Fine2 is RFine2,
	Neg2 is RNeg2.
sick_sort([ [_, 1, 0, 0] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Neg1 is RNeg1 + 1, 	% test1 incorrectly ignored
	Neg2 is RNeg2 + 1, 	% test2 incorrectly ignored
	
	Sick1 is RSick1,	% variables unused this time are passed upward
	Pos1 is RPos1,
	Sick2 is RSick2,
	Pos2 is RPos2,
	Fine1 is RFine1,
	Fine2 is RFine2.
sick_sort([ [_, 1, 0, 1] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Neg1 is RNeg1 + 1, 	% test1 incorrectly ignored
	Sick2 is RSick2 + 1,% test2 correctly flagged
	Pos2 is RPos2 + 1, 
	
	Sick1 is RSick1,	% variables unused this time are passed upward
	Pos1 is RPos1,
	Fine1 is RFine1,
	Fine2 is RFine2,
	Neg2 is RNeg2.
sick_sort([ [_, 1, 1, 0] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Sick1 is RSick1 + 1,% test1 correctly flagged
	Pos1 is RPos1 + 1, 
	Neg2 is RNeg2 + 1, 	% test2 incorrectly ignored
	
	Sick2 is RSick2,	% variables unused this time are passed upward
	Pos2 is RPos2,
	Fine1 is RFine1,
	Neg1 is RNeg1,
	Fine2 is RFine2.
sick_sort([ [_, 1, 1, 1] | T ], Sick1, Sick2, Fine1, Fine2, Pos1, Pos2, Neg1, Neg2) :-
	sick_sort(T, RSick1, RSick2, RFine1, RFine2, RPos1, RPos2, RNeg1, RNeg2),
	Sick1 is RSick1 + 1,% test1 correctly flagged
	Pos1 is RPos1 + 1, 
	Sick2 is RSick2 + 1,% test2 correctly flagged
	Pos2 is RPos2 + 1,

	Fine1 is RFine1,	% variables unused this time are passed upward
	Neg1 is RNeg1,
	Fine2 is RFine2,
	Neg2 is RNeg2.