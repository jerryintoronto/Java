INCLUDE Irvine32.inc

.code
main PROC 
	call readDec
	push eax;a
	call factorial
	call writeDec
	
	exit
main ENDP

factorial PROC 

	push ebp
	mov ebp, esp 
	mov ecx, [ebp + 8]
	mov eax, 1

	TOP:
		mul ecx 
		cmp ecx, 2
		je DONE
		loop TOP

	DONE: 
		pop ebp
		ret 4
		factorial ENDP

END main
