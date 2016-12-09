#Parameter Passing 

##Calling 
    push x
    push y
    push z
    call ABC

##Equivalent in JAVA

    ABC(x,y,z); 
    
    
##Receiving the parameters

    ABC PROC 
      mov eax, [esp + 4] ;z (assume x,y,z are DWORDs if you are new)
      mov ebx, [esp + 8] ;y 
      mov ecx, [esp + 12] ;z 
      
    ABC ENDP 
    
    
##What is [esp + 4] ??!??! 

    esp contains a 32 bit value, the address of stack 
    [ ] goes to that address
    [esp] would go to address esp, which is TOP of the stack 
    
    NOTE: call ABC, secretly pushes the address of call location to stack
          so, the top of stack is an address 
          to get z, [esp + 4] does the job.
          Remember z is 4 bytes, so thats why 4 is added. 
          
    



