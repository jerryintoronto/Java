#Procedures (also known as Functions, Methods or SubRoutines) 

###Must haves
    
      userDefined_name PROC
      
      ret  
      userDefined_name ENDP 
  
  
###What is "ret" 

      ret looks at the current STACK, grabs what is on TOP, and goes to that address
      
      if top of stack is not an return address, you will get an error
