package DesignPatterns.PrototyePattern;

public class Main {
    public static void main (String[] args) throws InterruptedException, CloneNotSupportedException {
        // this will take to load because sleep(heavy)
        NetworkConnection nc1 = new NetworkConnection();
        nc1.setIp("1.1.1.1");
        nc1.loadHeavyData();
        System.out.println(nc1);

        // this will not take time, clone object picked up from already loaded data (cached data)
        NetworkConnection nc2 = (NetworkConnection) nc1.clone();
        System.out.println(nc2);
    }
}
