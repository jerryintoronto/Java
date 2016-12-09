INCLUDE Irvine32.inc

.code
main PROC 
	call readDec
	push eax;a
	mov eax, 1
	call factorial
	call writeDec
	exit
main ENDP

factorial PROC 
	push ebp
	mov ebp, esp
	mov ebx, [ebp + 8]
	mul ebx

	cmp ebx, 1
	je DONE

	;else
	dec ebx
	push ebx
	call factorial

	DONE: 
	pop ebp ;removes "push ebp" from stack
	ret 4 ;removes "push ebx" from stack
	factorial ENDP 

END main
