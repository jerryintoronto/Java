#RECURSION 

##Calling

  MAIN PROC
  
    push eax
    push ebx
    call Recur
    
  MAIN ENDP 
    
##Recursive procedure
  
  Recur PROC
  
    push ebp  ;stores orginal 
    mov ebp, esp ; esp is the stack pointer
  
  
    ;(see STACK SEGMENT below )
    
    mov eax, [ebp + 12] 
    mov ebx, [ebp + 8] 
    
    
    ;Recursive parameter passing and self calling
    
    push eax
    push ebx
    call Recur 
    
    ;(see STACK SEGMENT 2 ) 
    
    
    ;whats pushed must be popped 
    
    pop ebp
    ret 8
    
  Recur ENDP
    
    
## STACK SEGMENT
    
    eax   -> [ebp + 12]
    ebx   -> [ebp + 8]
    RET   -> [ebp + 4]
    ebp   -> [ebp + 0]
    
## STACK SEGMENT 2

    eax   -> [ebp + 12]   OR   -> [esp + 24] 
    ebx   -> [ebp + 8]    OR   -> [esp + 20]
    RET   -> [ebp + 4]    OR   -> [esp + 16]
    ebp   -> [ebp + 0]    OR   -> [esp + 12]
    
    eax   -> [ebp - 4]    OR   -> [esp + 8]
    ebx   -> [ebp - 8]    OR   -> [esp + 4]
    RET   -> [ebp - 12]   OR   -> [esp + 0] 
    
    
    
