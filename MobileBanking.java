interface BasicSecurity {
    void login();
    void logout();
}

interface AdvancedSecurity extends BasicSecurity {
    void fingerprintAuth();
    void faceRecognitionAuth();
}

class BankingApplication implements AdvancedSecurity {
    public void login() {
        System.out.println("Basic Login successful.");
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }

    public void fingerprintAuth() {
        System.out.println("Fingerprint authentication successful.");
    }

    public void faceRecognitionAuth() {
        System.out.println("Face recognition authentication successful.");
    }
}

public class MobileBanking {
    public static void main(String[] args) {
        BankingApplication app = new BankingApplication();
        app.login();
        app.fingerprintAuth();
        app.faceRecognitionAuth();
        app.logout();
    }
}
