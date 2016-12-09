INCLUDE Irvine32.inc
.code             

main PROC
	;reads 2 decimals
	call readDec
	push eax  ;a
	call readDec
	push eax   ;b

	call GCD
	exit
main ENDP

GCD PROC 
	push ebp
	mov ebp, esp

	mov eax, [ebp + 12] ;a
	mov ebx, [ebp + 8] ;b

	L1:
		mov edx, 0
		div ebx
		cmp edx, 0 ;remainder is stored in edx
		je FINISH
			;else
			mov eax, ebx
			mov ebx, edx
			jmp L1

	FINISH: 
		mov eax, ebx
		call writeDec

	pop ebp
	ret 8
	GCD ENDP 
END main
