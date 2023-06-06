package designpatterns.Singleton;

public class TVSet {

    //volatile as it acts as a flag for checking
    private static volatile TVSet tvSet;
    private TVSet() {
        System.out.println("TVSet constructor instantiated!");
    }

    public static TVSet getTvSetSingleThreaded() {
        if(tvSet == null) {
            tvSet = new TVSet();
        }
        return tvSet;
    }

    //This applies synchronization to all the code but what if code is present before the check or after it,
    //we just have to worry about only one line then why should we synchronize the whole method
    public static synchronized TVSet getTvSetMultiThreaded1() {
        if(tvSet == null) {
            tvSet = new TVSet();
        }
        return tvSet;
    }

    public static TVSet getTvSetMultiThreaded2() {
        //volatile is helpful in this first if check to maintain consistency of variables
        if(tvSet == null) { //Optimisation check: What if thread 5, 6 arrive at some later time when the object is made
                            //then they won't enter the if block and unnecessary synchronization will not be done
            synchronized (TVSet.class) {
                //This is for the start threads which have arrived at the same time
                //Lets say two threads T1, T2 arrive and T1 takes the lock and creates an object and T2 is waiting for T1
                //to release the lock, then after releasing lock (by T1) T2 can create the object once again
                //So another check is made here just to make sure T2 won't be able to create another object
                //This is termed as **Double Checking**
                if(tvSet == null)
                    tvSet = new TVSet();
            }
        }
        return tvSet;
    }
}
