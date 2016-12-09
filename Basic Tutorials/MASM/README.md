# MASM

##Recursions can be better understood through ASM  

###1) Procedure (e.g. Method in Java) 

JAVA:

    public static void main (String args[]) 
    {
        <code here>
    }

ASM:

    MAIN proc 
        <code here>
    MAIN ENDP 

Main is the entry point for JAVA as it is for ASM. 

###STACK 

Before moving forward, you have to understand stack. In ASM, stack grows downward (North to South). 

*push calls*

    push eax (pushes eax on top of stack)
    call xyz (pushes current address on top of stack) 
     
    
*pop calls*

    pop eax (pop top of stack to eax) 
    ret (pop top of stack and go to that address (no error checking)) 
  


###2) Parameter Passing 

    see Folder 1 
    
###3) Recursion
    
    see Folder 2 
    
    
    

  


