INCLUDE Irvine32.inc
.code             
main PROC
	
	call readDec
	push eax ;a
	call readDec
	push eax ;b
	call gcdRecursive
	mov eax, ebx
	call writeDec
	exit
main ENDP

gcdRecursive PROC
	push ebp
	mov ebp, esp

	mov eax, [esp + 12]
	mov ebx, [esp + 8]
	mov edx, 0
	div ebx
	cmp edx, 0
	je DONE
	;else
	push ebx
	push edx
	call gcdRecursive

	DONE: 
	pop ebp ;important!
	ret 8 ;important!

gcdRecursive ENDP
END main
