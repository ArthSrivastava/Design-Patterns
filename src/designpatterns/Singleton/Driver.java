package designpatterns.Singleton;

public class Driver {
    public static void main(String[] args) {
        //Works for single thread
//        TVSet tvSet1 = TVSet.getTvSetSingleThreaded();
//        TVSet tvSet2 = TVSet.getTvSetSingleThreaded();
//        System.out.println(tvSet1);
//        System.out.println(tvSet2);

        //Single Threaded method fails if more than 1 thread try to access.
//        Thread t1 = new Thread(TVSet::getTvSetSingleThreaded);
//        Thread t2 = new Thread(TVSet::getTvSetSingleThreaded);

        //Synchronized method level multithreaded method
//        Thread t1 = new Thread(TVSet::getTvSetMultiThreaded1);
//        Thread t2 = new Thread(TVSet::getTvSetMultiThreaded1);

        //Best method
        Thread t1 = new Thread(TVSet::getTvSetMultiThreaded2);
        Thread t2 = new Thread(TVSet::getTvSetMultiThreaded2);
        t1.start();
        t2.start();

    }
}
