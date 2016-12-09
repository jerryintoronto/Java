#Setup for C programming

there are so many options, and to be frank I'm not sure whats the best. 

##UNIX (Ubuntu)

it was required to use UNIX for lab test (when I took the course)

nano
    plain text editor
    easy to use, for beginners only 

vim/vi/emac
    take a while to learn
    probably all Google engineers use one of these 3
    

##MAC

?

##WINDOWS

setup up for C/C++ is harder on Windows.

    you need need to install a c compiler
    google "c compiler for windows" 
    visual studio has built in c compiler, but I do not recommend visual studios 
    you can ssh (remote access school servers) and not worry about compiler/ide

1. IDE route - install compiler, install ides 

dev c++

    this is what i used
    the syntax checking is good for beginners 
    
eclipse

    for 60-212 the prof might recommend eclipse
    very good editor, this is what I use now 
    
codeblock

    tried, dislikes its user interface 
    
SSH into school server

    you will probably need to do this sooner or later
    http://www.help.cs.uwindsor.ca/en/servers/remote-access/secure-shell/


Cygwin 

    unix like envirnment on windows
    learning this will give you a head start for 60-256 (assuming you don't ssh) 

Dual Boot ubuntu 

    did not work for me 

Windows 10 bash terminal?

    have not tried
 
##Other

Online C Compiler

Use Text Editors (Notepad++) in combination with command line compiler 


##Working from UNIX command line (or when you ssh) 

everyone should know how to do this

1.create a c file

    touch test.c 

2.check if it is there

    ls

3.edit using nano editor

    nano test
    

4.type or copy this code:

    #include <stdio.h>

    int main()
    {
            printf("hello world!");
            return 0;
    }

5.quit and save

    ctrl + x
    y
    ENTER
    
5b)read file from command line (OPTIONAL)

    cat test.c 

6.compile

    gcc test.c
    
7.run

    ./a.out







   

    
    
    
    
