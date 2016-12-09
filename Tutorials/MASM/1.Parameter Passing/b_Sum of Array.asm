INCLUDE Irvine32.inc 

;INPUT: array from .data (memory)
;OUTPUT: sum of array
;KEY CONCEPTS: procedure with parameters   

.data
	array DWORD 1,2,3,4,5,6 

.code             
	main PROC 
		push OFFSET array ;first parameter 
		push LENGTHOF array ;second parameter 
		call sumOfArray 

		exit
		main ENDP
	
	sumOfArray PROC 
		push ebp  ;saves ebp
		mov ebp, esp 
		mov esi, [ebp+12] ;address of array
		mov ecx, [ebp+8] ;length of array 

		xor eax, eax ; set eax to 0

		L1: 
			add eax, [esi]
			add esi, 4 ;array is of type DWORD - 4 bits 
			loop L1

		call writeDec ; screen output sum in eax
		pop ebp ;restores original ebp
		ret	8 ;add esp by 8, cleans the stack, prevent memory leak
		sumOfArray ENDP

END main
