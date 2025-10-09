package DesignPatterns.PrototyePattern;

public class NetworkConnection implements Cloneable{
    private String ip;
    private String heavyData;

    public String getIp(String s) {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHeavyData() {
        return heavyData;
    }

    public void setHeavyData(String heavyData) {
        this.heavyData = heavyData;
    }

    public void loadHeavyData() throws InterruptedException {
        this.heavyData = "very heavy data to load";
        Thread.sleep(2000);
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", heavyData='" + heavyData + '\'' +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
