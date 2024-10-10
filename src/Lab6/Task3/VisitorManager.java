package Lab6.Task3;

import java.util.HashSet;

public class VisitorManager {
    private HashSet<Integer> hashSet;

    public VisitorManager() {
       hashSet = new HashSet<>();
    }

    public HashSet<Integer> getHashSet() {
        return hashSet;
    }

    public void addVisitor(Visitor visitor){
        hashSet.add(visitor.getVisitorID());
    }
    public void removeVisitor(Visitor visitor){
        hashSet.remove(visitor.getVisitorID());
        System.out.println("Removed: " + visitor.getVisitorIPAddress() );
    }
    public void checkVisitor(int visitorID ){
        if(hashSet.contains(visitorID)){
            System.out.println("It exists");
        } else {
            System.out.println("It does not exists");
        }
    }

    public void listAll() {
        System.out.println(hashSet);
    }
}
