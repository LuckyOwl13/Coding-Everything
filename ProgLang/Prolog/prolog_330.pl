% average(+X, +Y, +Z, ?Avg)
% Avg is the average of X and Y and Z

average(X, Y, Z, Avg) :- Avg  is  (X + Y + Z) / 3.0.

% monus(+X, +Y, ?Difference)
% If X >= Y then Difference is X - Y; otherwise, Difference is 0.

monus(X, Y, Difference) :- X >= Y, Difference is X - Y.
monus(X, Y, 0) :- X < Y.

% newmember(+Item, +L)
% Item is a member of list L.

newmember(Item, [ Item | _ ]).
newmember(Item, [_ | T]) :- newmember(Item, T).

% newdelete(+Item, +OldL, -NewL)
% NewL is the result of deleting the first occurrence of Item from list OldL.
% Succeed with list unchanged if Item not found.

newdelete(_, [], []).
newdelete(Item, [ Item | T ], T).
newdelete(Item, [ H | T ], [ H | NewT ]) :- 
	Item \== H, 
	newdelete(Item, T, NewT).

% newdelete2(+Item, +OldL, -NewL)
% NewL is the result of deleting all occurrences of Item from list OldL.
% Succeed with list unchanged if Item not found.

newdelete2(_, [], []).
newdelete2(Item, [ Item | T ], NewT ) :-
	newdelete2(Item, T, NewT).
newdelete2(Item, [ H | T ], [ H | NewT ]) :- 
	Item \== H, 
	newdelete2(Item, T, NewT).

% sumlist(+L, -Sum)
% Sum is the sum of the numbers in list L.

sumlist([], 0).
sumlist([H | T], Sum) :-
	sumlist(T, TSum),
	Sum is H + TSum.

% occurs(+Item, +L, -Count)
% Count is the number of occurrences of Item in list L.

occurs(_, [], 0).
occurs(Item, [Item | T], Count) :-
	occurs(Item, T, TCount),
	Count is 1 + TCount.
occurs(Item, [H | T], Count) :-
	Item \== H,
	occurs(Item, T, Count).

% state_capital(+InfoList, +State, -Capital)
% Capital is the capital of State, as specified in InfoList.
% (Describe InfoList here)

state_capital([ [ State, Capital] | _ ], State, Capital).
state_capital([ [ OtherState, _ ] | T ], State, Capital) :-
	OtherState \== State,
	state_capital(T, State, Capital).

