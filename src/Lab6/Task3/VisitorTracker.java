package Lab6.Task3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Visitor class
class Visitor {
    int visitorId;
    String ipAddress;

    public Visitor(int visitorId, String ipAddress) {
        this.visitorId = visitorId;
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return visitorId == visitor.visitorId && Objects.equals(ipAddress, visitor.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorId, ipAddress);
    }

    @Override
    public String toString() {
        return "Visitor ID: " + visitorId + ", IP Address: " + ipAddress;
    }
}

public class VisitorTracker {
    private Set<Visitor> visitorSet;

    public VisitorTracker() {
        this.visitorSet = new HashSet<>();
    }

    // Add a visitor to the HashSet
    public void addVisitor(int visitorId, String ipAddress) {
        Visitor visitor = new Visitor(visitorId, ipAddress);
        if (visitorSet.add(visitor)) {
//            System.out.println("Visitor added: " + visitor);
        } else {
//            System.out.println("Visitor already exists: " + visitor);
        }
    }

    // Remove a visitor (for example, those who haven't returned in a specified time period)
    public void removeVisitor(int visitorId) {
        visitorSet.removeIf(visitor -> visitor.visitorId == visitorId);
//        System.out.println("Removed visitor with ID: " + visitorId);
    }

    // Check if a visitor has been tracked before
    public boolean checkVisitor(int visitorId) {
        return visitorSet.stream().anyMatch(visitor -> visitor.visitorId == visitorId);
    }

    // List all unique visitors
    public void listAllVisitors() {
//        System.out.println("All unique visitors:");
//        visitorSet.forEach(System.out::println);
    }

    // Performance testing for adding, removing, checking, and listing
    public static void performanceTest(int count) {
        VisitorTracker tracker = new VisitorTracker();
        long startTime, endTime;

        // Test adding visitors
        startTime = System.nanoTime();
        for (int i = 1; i <= count; i++) {
            tracker.addVisitor(i, "192.168.0." + i);
        }
        endTime = System.nanoTime();
        System.out.println("Time to add " + count + " visitors: " + (endTime - startTime) + " ns");

        // Test checking a visitor
        startTime = System.nanoTime();
        tracker.checkVisitor(count / 2); // Check middle visitor
        endTime = System.nanoTime();
        System.out.println("Time to check a visitor: " + (endTime - startTime) + " ns");

        // Test removing visitors
        startTime = System.nanoTime();
        tracker.removeVisitor(count / 2); // Remove middle visitor
        endTime = System.nanoTime();
        System.out.println("Time to remove a visitor: " + (endTime - startTime) + " ns");

        // Test listing all visitors
        startTime = System.nanoTime();
        tracker.listAllVisitors();
        endTime = System.nanoTime();
        System.out.println("Time to list all visitors: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        // Performance test for 100, 1,000, and 10,000 visitors
        System.out.println("Performance Test with 100 Visitors");
        performanceTest(100);

        System.out.println("\nPerformance Test with 1,000 Visitors");
        performanceTest(1_000);

        System.out.println("\nPerformance Test with 10,000 Visitors");
        performanceTest(10_000);
    }
}
