INCLUDE Irvine32.inc

.code             
main PROC
	call readDec
	push eax ;a
	call H
	call writeDec
	exit
main ENDP

H PROC
	push ebp
	mov ebp, esp 
	mov ebx, [ebp+8] 
	cmp ebx, 0 
	ja L1
	mov eax, 0 
	jmp DONE 

	L1:	
		dec ebx   ;starts from inner-most ( ) 
		push ebx 
		call H
		
		push eax 
		call H
		
		push eax 
		call H 

		mov ebx, [ebp + 8] ;n 
		sub ebx, eax  ;n - H(H(H(n-1)))
		mov eax, ebx  

	DONE:
	pop ebp 
	ret 4 

	H ENDP

END main
