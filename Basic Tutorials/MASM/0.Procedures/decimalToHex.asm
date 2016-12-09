;INPUT : decimal    (0-65525)
;OUTPUT : hex   (0-FFFF)
;KEY CONCEPTS: subroutines(procedures), ROL(bit shift), conditions, loops

INCLUDE Irvine32.inc 
.code        
    
    main PROC
		CALL readDec                          
		MOV ebx, eax 
		CMP ebx, 15
		jg L1
			;otherwise
			CALL DisplayHexDigit	
			jmp loopEND
		L1:
			CMP ebx, 255
		jg L2
			;otherwise
			CALL DisplayHexByte 
			jmp loopEND
		L2:
			CALL DisplayHexWord
		loopEND:
			exit
	main ENDP     


	DisplayHexDigit PROC
		MOV al, bl
		AND al, 0fh ;take out 1st/left byte and set to 0 
		cmp al, 9
		jg L2
			;otherwise less than or equal to 9
			ADD al, 48
		jmp L1
		L2: 
			;9-15
			ADD al, 55
		L1:
			CALL writeChar
		ret 
	DisplayHexDigit ENDP


	DisplayHexByte PROC 
		ROR bx, 4
		CALL DisplayHexDigit 
		ROL bx, 4
		CALL DisplayHexDigit 	
		ret	
	DisplayHexByte ENDP


	DisplayHexWord PROC 
		mov ecx, 4
		TOP: 
			;will loop 4 times for each byte
			ROL bx, 4
			CALL DisplayHexDigit
		loop TOP 
		ret
	DisplayHexWord ENDP

END main
