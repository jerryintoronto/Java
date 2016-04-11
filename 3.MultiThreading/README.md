#Main Concepts

##Consumer/Producer concepts
Required: if producers produces int 1 to 10, consumers has to consumer the right numbers. 

Required: Consumer/Producer are run on seperate thread (ExecutorService class is used) 

Problem: Multithreading is random, two threads run not in sequence. 
          
          For example: if (p = producer, c = consumer), we may get pppc, or cppcp.
          We want c to consume the correct p. 


##Swing Multithreading 
Problem: Swing was not designed for multithreading. 

        Use SwingWorker to perform long calculation in background. 

