package enums;

public class PlanetService {

}
enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private double mass;           // In kilograms
    private double radius;         // In meters
    private double surfaceGravity; // In m / s^2


    Planet(double v, double v1) {

    }
}
