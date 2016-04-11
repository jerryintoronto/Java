#Using ExecutorService to enable multithreading. 

##Client 

class myClass implements Runnable {

    Socket socket = new Socket (InetAddress.getByName("IP"), PortNumber); 
    Scanner input = new Scanner(socket.getInputStream());
    Formatter output = new Formatter(socket.getOutputStream()); 
    ExecutorService w = Executors.newFixedThreadPool(1); 
    w.execute(this); 
    
    public void run()
 }


##Server

ExecutorService e Executor.newFixedThreadPool(max); 

ServerSocket s = new ServerSocket(PortNumber, max); 

for (int i = 0; i < max; i++)  e.execute(new myClass(s.accept(),i)); 
    
class myClass implements Runnable {
    
    -socket
    -input
    -output
    
    -public void run()
}


