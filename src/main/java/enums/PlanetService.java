package enums;

import java.io.Serializable;

/**
 * An example to demonstrate some of the details of Java enum implementation, based on the original Planet enum from Oracle's Java documentation.
 *
 * Java’s enum types are full-fledged classes, far more powerful than their counterparts in these other languages, where enums are essentially int values [Effective Java, 2nd edition]
 * (also see http://stackoverflow.com/questions/469287/c-sharp-vs-java-enum-for-those-new-to-c)
 *
 *
 */
public class PlanetService {

    public static void main(String[] args) {
        //Planet, like all enums, has a static values method that returns an array of its values in the order they were declared.
        for(Planet p : Planet.values()) {
            System.out.printf("Planet %s, mass %f KG, radius %f Meters and Surface Gravity %f %n", p, p.getMass(), p.getRadius(), p.getSurfaceGravity());
        }
    }

}

////An enum can implement Interface, but they cannot extend any class -- the reason being enum implicitly extends lava.lang.Enum
enum Planet implements Serializable {
    //Enums may contain one or more enum constants, which define unique instances of the enum type
    //enum instances are implicitly static and final!!
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    //enums can have further fields (and methods)
    private final double mass;           // In kilograms
    private final double radius;         // In meters
    private final double surfaceGravity; // In m / s^2

    //Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    /* Each enum must provide a constructor matching the arguments in the declaration -- though, it cannot enforce the initialization (upto the programmer)
        An enum constructor cannot be public or protected (The constructor actually isn't package-private though it appears so...
        it is "implicitly private", the way interface methods are implicitly public even if you don't add the keyword.)
     */
     Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    //default toString implementation just prints the constant -- enough for most of the cases. Here it is overriden to decorate the default output
    @Override
    public String toString() {
        return "✭ ✮ " + super.toString() + " ✭ ✮";
    }
}
