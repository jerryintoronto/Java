INCLUDE Irvine32.inc 

;return [(A * B) / C] + [ A * (B / C) ] in the EAX register. 
;2/3 is rounded down to 0
;8 bit unsigned operands

.code             
	main PROC
	push 3 ;A
	push 2 ;B
	push 1 ;C
	call calculate
	add esp, 12 ; 3 (# pushes) * 4 (4 bits) = 12  
	
	exit
	main ENDP
	
	calculate PROC 
		push ebp
		mov ebp, esp

		xor eax,eax
		
		;[(A * B) / C] 
		mov al, [ebp+16] ;A
		mov bl, [ebp+12] ;B 
		MUL bl
		mov bl, [ebp+8] ;C
		DIV bl

		XOR ah, ah ;clears AH (reminder)
		push ax ;saves ax

		;[ A * (B / C) ]
		mov al, [ebp+12] ;B
		mov bl, [ebp+8] ;C
		DIV bl
		XOR ah, ah ;clears Ah
		mov bl, [ebp+16] ;A
		MUL bl 

		;adds together
		pop bx ;get saved ax 
		add ax, bx
		call writeDec

		pop ebp
		ret	
		calculate ENDP

END main
