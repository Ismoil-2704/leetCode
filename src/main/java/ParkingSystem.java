public class ParkingSystem {
    private int b;
    private int m;
    private int s;
    public ParkingSystem(int big, int medium, int small) {
        this.b = big;
        this.m = medium;
        this.s = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1 && b > 0) {
            b = b - 1;
            return true;
        }
        if(carType == 2 && m > 0) {
            m = m - 1;
            return true;
        }
        if(carType == 3 && s > 0) {
            s = s - 1;
            return true;
        }
        else {
            return false;
        }
    }
}
