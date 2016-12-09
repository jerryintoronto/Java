INCLUDE Irvine32.inc

.data
last dword ?
.code
main PROC

	call readDec
	push eax
	call fibonaci
	call writeDec 

	exit
main ENDP

fibonaci PROC 
	push ebp
	mov ebp, esp 

	mov eax, 0 ;c
	mov ebx, 0 ;a
	mov edx, 1 ;b

	;for (int  i = 2 ; i <= n ; i++)
	mov ecx, [ebp + 8]
	mov last, ecx
	mov ecx, 2
	TOP:
	
	cmp ecx, last 
	ja DONE
	;else

	;c = a + b
	mov eax, ebx
	add eax, edx

	;a = b
	mov ebx, edx
	;b = c
	mov edx, eax

	inc ecx
	jmp TOP

	DONE:
	pop ebp
	ret 
	fibonaci ENDP

END main
