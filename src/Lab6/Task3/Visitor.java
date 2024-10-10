package Lab6.Task3;

public class Visitor {
    private int visitorID;
    private String visitorIPAddress;


    public Visitor(int visitorID, String visitorIPAddress) {
        this.visitorID = visitorID;
        this.visitorIPAddress = visitorIPAddress;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public String getVisitorIPAddress() {
        return visitorIPAddress;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorID=" + visitorID +
                ", visitorIPAddress='" + visitorIPAddress + '\'' +
                '}';
    }
}
