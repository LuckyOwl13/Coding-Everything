
(define (medical_test Patient_Data)	; Here, Patient_Data is the list of patient lists. All of them in one
	
	(define stats (format_checked (check_patients Patient_Data))) ; run everything and save the resulting list to "stats"
	
	; format return from check_patients to put out expected output
	(cond 	( 	(and 	(> (car stats) (cadr stats) ) 	; if #sickyesOne > #sickyesTwo
					          (> (caddr stats) (cadddr stats))); & if #finenoOne > #finenoTwo
						                (addToEnd stats "test1")) ; appends "test1" to the end of list 'stats'
			    ( 	(and 	(< (car stats) (cadr stats) ) 	; if #sickyesOne > #sickyesTwo
					          (< (caddr stats) (cadddr stats) )); & if #finenoOne > #finenoTwo
						                (addToEnd stats "test2")) ; appends "test2" to the end of list 'stats'
			    (else             (addToEnd stats "neither")) ; appends "neither" to the end of list 'stats'
	) ; end cond
) ; end (define medical_test)

(define (check_patients Patient_Data)	; Here, Patient_Data is the list of patient lists. All of them in one
	(cond 	((null? Patient_Data) '(0 0 0 0 0 0 0 0))	; [works] Base case, return all-zero set
    			(else 	
    						(add_pairs	(getTheDeets    (car Patient_Data) )	; Add together the current patient's getTheDeets
    									      (check_patients (cdr Patient_Data) )	; with those of the below recursions
    						)	; use add_pairs to get everything lined up at the end of handling a persons
    			)	; end else
	)	; end cond
) ; end (define check_patients)

; Return the patient's [a list's] data formatted to align with medical_test
; through the use of a horrible nested-if block. Nice.
(define (getTheDeets patient) ; [works]
	(cond	((and (and (= (cadr patient) 0) (= (caddr patient) 0))  (= (cadddr patient) 0)) '(0 0  0 0  1 1  1 1))	; Fine, saidNo1, saidNo2 [Right Right]
	     	((and (and (= (cadr patient) 0) (= (caddr patient) 0))  (= (cadddr patient) 1)) '(0 0  0 1  1 1  0 0))	; Fine, saidNo1, saidYes2 [Right Wrong]
			((and (and (= (cadr patient) 0) (= (caddr patient) 1))  (= (cadddr patient) 0)) '(0 1  0 0  0 0  1 1)) 	; Fine, saidYes1, saidNo2 [Wrong Right]
			((and (and (= (cadr patient) 0) (= (caddr patient) 1))  (= (cadddr patient) 1)) '(0 1  0 1  0 0  0 0))	; Fine, saidYes1, saidYes2 [Wrong Wrong]
			((and (and (= (cadr patient) 1) (= (caddr patient) 0))  (= (cadddr patient) 0)) '(0 0  0 0  0 1  0 1)) 	; Sick, saidNo1, saidNo2 [Wrong Wrong]
			((and (and (= (cadr patient) 1) (= (caddr patient) 0))  (= (cadddr patient) 1)) '(0 0  1 1  0 1  0 0))	; Sick, saidNo1, saidYes2 [Wrong Right]
			((and (and (= (cadr patient) 1) (= (caddr patient) 1))  (= (cadddr patient) 0)) '(1 1  0 0  0 0  0 1)) 	; Sick, saidYes1, saidNo2 [Right Wrong]
			((and (and (= (cadr patient) 1) (= (caddr patient) 1))  (= (cadddr patient) 1)) '(1 1  1 1  0 0  0 0))	; Sick, saidYes1, saidYes2 [Right Right]
			(else '(0 0  0 0  0 0  0 0)) ; if none of those worked, pass back an empty stats list bc something went wrong
	; #sick1 #saidYes1 #sick2 #saidYes2 #fine1 #saidNo1 #fine2 #saidNo2
	) ; end cond
) ; end define (getTheDeets patient)


; Returns a list of fractions of [even-index/odd-index] pairs
(define (format_checked patients_stats) 

	(cond	((null? patients_stats) '()) ; Base Case, returns the empty list
			(else (cons (/ (car patients_stats) (cadr patients_stats)) (format_checked (cddr patients_stats)))) ; If a patient is given
	) ; end cond

) ; end define (format_checked patients_stats) 


; Return the given List but with newItem now at the end of it
(define (addToEnd List newItem)

	(cond 	((null? List) 	(cons newItem ()))	; if list empty, return new list with newItem in it
			(else 			(cons (car List) 
		      			        (addToEnd (cdr List) newItem))) ; otherwise add top item to below recursions
	) ; end cond
	
) ; end define (addToEnd List newItem)


; Return a list containing the sums of the numbers in x and y:
(define (add_pairs x y) ; [works]
	; (add_pairs ’(1 3 5) ’(2 10 20)) returns (3 13 25).
	; Assume the lists have the same length.
	(cond 	
      ((or (null? x) (null? y)) '() ) ; If either x or y has run out of items, return the empty list
			(else 
		      (cons (+ (car x) (car y)) ; add the top items of the two lists
					      (add_pairs (cdr x) (cdr y))) ; to the returned list of below recursions
	    )
	) ; end cond
) ; end define



(medical_test '(
     (1   1   1   0)
     (2   1   1   1)
     (3   0   0   0)
     (4   0   0   0)
     (5   1   1   0)
     (6   0   0   0)
     (7   0   0   0)
     (8   1   0   1)
     (9   0   1   0)
     (10  0   0   0)
))


