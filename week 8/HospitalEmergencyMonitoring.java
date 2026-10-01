public class HospitalEmergencyMonitoring {
    public static void main(String[] args) throws InterruptedException {
        Thread emergencyAlert = new EmergencyAlert();
        Thread vitalMonitor = new VitalMonitor();
        Thread reportGenerator = new ReportGenerator();

        emergencyAlert.setPriority(Thread.MAX_PRIORITY);
        vitalMonitor.setPriority(Thread.NORM_PRIORITY);
        reportGenerator.setPriority(Thread.MIN_PRIORITY);

        displayThread(emergencyAlert);
        displayThread(vitalMonitor);
        displayThread(reportGenerator);

        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();

        emergencyAlert.join();
        vitalMonitor.join();
        reportGenerator.join();
    }

    private static void displayThread(Thread thread) {
        System.out.println(thread.getName() + " priority: " + thread.getPriority());
    }
}

class EmergencyAlert extends Thread {
    EmergencyAlert() {
        super("EmergencyAlert");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is checking critical patient alerts.");
    }
}

class VitalMonitor extends Thread {
    VitalMonitor() {
        super("VitalMonitor");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is continuously checking vital signs.");
    }
}

class ReportGenerator extends Thread {
    ReportGenerator() {
        super("ReportGenerator");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is preparing routine reports.");
    }
}