# Hofstadler 

    H(n) = 0 if n = 0;
    H(n) = n - H(H(H(n-1))) if n > 0;

##Outputs

    n		H(n)   #of loops
    0:		0		1
    1:		1		4
    2:		1		13
    3:		2		22
    4:		3		40
    5:		4		76
    6:		4		139
    7:		5		202
    8:		5		319
    9:		6		436
    
    
##Stack (if n = 1 )

    eax (n)
    ret (to main) 
    ebp (?) 
    ebx     ;inner h(n-1)
    ret
    ebp 
    pop ebp   ;DONE 
    ret 4 
    eax     ;middle h(h(n-1)) 
    ret 
    ebp     
    pop ebp    ;DONE
    ret 4 
    eax     ;outter h(h(h(n-1)))
    ret
    ebp
    pop ebp     ;DONE
    ret 4
    pop ebp     ;DONE
    ret 4 

