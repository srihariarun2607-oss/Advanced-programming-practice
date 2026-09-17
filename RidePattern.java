public class RidePattern {

    public static void main(String[] args) {

        String[] rideName = new String[5];
        int[] rideNumber = new int[5];

        rideNumber[0] = 1;
        rideNumber[1] = 2;
        rideNumber[2] = 3;
        rideNumber[3] = 4;
        rideNumber[4] = 5;

        rideName[0] = "Roller Coaster";
        rideName[1] = "Ferris Wheel";
        rideName[2] = "Bumper Cars";
        rideName[3] = "Water Ride";
        rideName[4] = "Haunted House";

        for (int i = 0; i < 5; i++) {

            System.out.print(rideName[i] + " : ");

            for (int j = 1; j <= rideNumber[i]; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}