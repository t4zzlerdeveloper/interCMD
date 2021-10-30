
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class interCMD {
    private static String[] cmds = new String[99];
    private static  String[] funcs = new String[99];
    private static String exitCmd = "exit";
    private static String classToRun = "Main";
    private static int i = 0;
    private static Scanner sr;
    private static boolean CR = true;

    //INITIALIZATION

    public interCMD(Scanner in){
        sr = in;
        init();
    }

    public interCMD(Scanner in,String className){
        sr = in;
        classToRun = className;
        init();
    }

    private static void init(){
        Arrays.fill(cmds,null);
        Arrays.fill(funcs,null);
        CR = true;
    }

    //RESET CLASS

    public static void reset(){
        i=0;
        Arrays.fill(cmds,null);
        Arrays.fill(funcs,null);
        CR = false;
    }


    //RUN FUNCTIONS

    public static void run(int cycles){
        runFunction(cycles);
    }

    public static void run(){
        runFunction(0);
    }

    private static void runFunction(int cycles){
        cycles++;
        if(cycles == 1) cycles = -1;
        while(CR){
            cycles--;
            if(cycles == 0) break;
            String input = sr.next();
            if(!CR) break;
            int a = 0;
            if(input.equals(exitCmd)) break;
            for (String c:cmds) {
                if(input.equals(c)){
                    try{
                        Class t = Class.forName(classToRun);
                        Object obj = t.newInstance();

                        Method method = t.getDeclaredMethod(funcs[a], null);
                        method.setAccessible(true);
                        method.invoke(obj, null);
                    }
                    catch (Exception e){}
                    System.out.println();
                    break;
                }
                a++;
            }
        }
    }

    //EDIT COMMANDS

    public static void addCommand(String cmd, String func){
        cmds[i] = cmd;
        funcs[i] = func;
        i++;
    }

    public static void setExitCommand(String cmd){
        exitCmd = cmd;
    }
}
