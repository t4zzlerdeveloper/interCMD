# interCMD (Very very badly optimized!!)
##### Simple Java Command Interperter Class


## Documentation:
  - interCMD(Scanner scanner,String className);
    - [ Initializes the command interperter, Scanner and className are optional ]
   
  - addCommand(String command,String voidNameToRun);
    - [ Add a new command and the function to be trigerred ]
   
  - setExitCommand(String exitCommand);
    - [ Change default "exit" command to a custom one ]
   
  - run(int cycles)
    - [ Run the command interperter, cycles is optional and can be used to specify the amount of commands to re read]



## Example:
```
  public static void main(String[] args){
    Scanner sr = new Scanner(System.in);
    interCMD ic = new interCMD(sr);
    ic.addCommand("hh","sayhello");
    ic.setExitCommand("byebye");
    ic.run();
  }
  
  public static void sayhello(){
    System.out.println("Hello world");
  }
  ```
