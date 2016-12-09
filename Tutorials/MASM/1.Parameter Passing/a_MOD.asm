INCLUDE Irvine32.inc
;no parameter passing, but push is used here to store value. 

.code             

main PROC
	
	mov edx, 0 ; A / B = C, if B is 32 bits
				;A has to be 64 bits, where 32 left-most bits are stored in EDX 
				;clears edx

	;reads 2 numbers, store in stack
	call readDec
	push eax ;a         esp-=4 in the background
	call readDec 
	push eax ;b         esp-=4 in the background

	;retrives values and perform division
	mov eax, [esp + 4] ; gets a, esp is the stack pointer 
	mov ebx, [esp] ;gets b
	div ebx  ;performs (edx:eax / ebx) in background

	;print out answers
	call writeDec ;quotient is automatically stored in eax
	call crlf ;writes line ("\n")
	mov eax, edx ;remainder (MOD) is stored in EDX for (64 bits/32 bits) divisions
	call writeDec 

	add esp, 8 ; 2(pushes) * 4(each is 4 bits) add 8 to esp restores esp to pre-push value
	exit

main ENDP
END main
