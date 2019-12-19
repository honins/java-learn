/**
 * @author Created by hy
 * @date on 2019/12/19 10:36
 */
public class Test {

//    What does $$ in javac generated name mean?
//    https://stackoverflow.com/questions/36057007/what-does-in-javac-generated-name-mean
    public static void main(String... args) {
        if(args.length==0) {
            final boolean meFirst = Math.random()<0.5;
            if(meFirst) {
                Runnable r=Test::main;
                System.out.println("first run:\t"+r.getClass());
            }
            main("second run");
            if(!meFirst) {
                Runnable r=Test::main;
                System.out.println("first run:\t"+r.getClass());
            }
        }
        else {
            Runnable r=Test::main;
            System.out.println(args[0]+":\t"+r.getClass());
            if(args[0].equals("second run")) main("last run");
        }
    }

}
