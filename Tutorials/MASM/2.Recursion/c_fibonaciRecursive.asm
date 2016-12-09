INCLUDE Irvine32.inc

.code
	main PROC

		call readDec
		mov edx, eax ;edx stores user input
		mov ecx, eax ;ebc stores user input 

		L1:
		
		mov eax, edx 
		sub eax, ecx
		push eax
		mov eax, 0 ;output stored in eax, clear that now
		call fibonaci
		call writeDec

		mov al, ' '
		call writeChar
		dec ecx
		cmp ecx, 0
		jl FIN
		jmp L1

		FIN: exit
	main ENDP

	fibonaci PROC 
		push ebp
		mov ebp, esp

		mov ebx, [ebp + 8]
		cmp ebx, 1
		je DONE 
		cmp ebx, 0
		je DONE 
		
		;else

		;f(n-1)
		dec ebx
		push ebx 
		call fibonaci

		;f(n-2)
		pop ebx
		dec ebx
		push ebx
		call fibonaci

		;leafs
		pop ebx
		pop ebp
		ret

	DONE:
		add eax, ebx  
		pop ebp
		ret 

	fibonaci ENDP
END main
