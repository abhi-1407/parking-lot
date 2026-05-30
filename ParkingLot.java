//import java.util.ArrayList;
//import java.util.List;
//
//public class ParkingLot {
//    private static volatile ParkingLot instance;
//    private final String name;
//    private final List<EntryGate> entryGates;
//    private final List<ExitGate> exitGates;
//
//    private ParkingLot(String name){
//        this.name = name;
//        this.entryGates = new ArrayList<>();
//        this.exitGates = new ArrayList<>();
//    }
//
//    public static synchronized ParkingLot getInstance(String name) {
//        if (instance == null) {
//            synchronized (ParkingLot.class) {
//                //double check locking to ensure thread safety
//                if (instance == null) {
//                    instance = new ParkingLot(name);
//                }
//            }
//        }
//        return instance;
//    }
//
//    public void addEntryGate(EntryGate entryGate) {
//        entryGates.add(entryGate);
//    }
//
//    public void addExitGate(ExitGate exitGate) {
//        exitGates.add(exitGate);
//    }
//}