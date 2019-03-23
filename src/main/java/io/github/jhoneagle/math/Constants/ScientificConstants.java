package io.github.jhoneagle.math.Constants;

public class ScientificConstants {
    /**
     * Light year
     */
    public static final double LIGHT_YEAR = 9.4607304725808E15;
    /**
     * Astronomical unit
     */
    public static final double ASTRONOMICAL_UNIT = 149597870700.0 * Units.METRE;
    /**
     * Parsec
     */
    public static final double PARSEC = 206264.806247096 * ASTRONOMICAL_UNIT;
    /**
     * Kiloparsec
     */
    public static final double KILOPARSEC = Units.KILO * PARSEC;
    /**
     * Earth equatorial radius
     */
    public static final double EARTH_RADIUS_EQUATORIAL = 6378.1370 * Units.KILOMETRE;
    /**
     * Earth polar radius
     */
    public static final double EARTH_RADIUS_POLAR = 6356.7523 * Units.KILOMETRE;
    /**
     * Earth mean radius
     */
    public static final double EARTH_RADIUS_MEAN = 6371.0088 * Units.KILOMETRE;
    /**
     * Earth mass
     */
    public static final double EARTH_MASS = 5.9722 * Units.YOTTA * Units.KILOGRAM;
    /**
     * Earth semi-major axis
     */
    public static final double EARTH_SEMI_MAJOR_AXIS = 1.000001018 * ASTRONOMICAL_UNIT;
    /**
     * Moon mean radius
     */
    public static final double MOON_RADIUS_MEAN = 1737.1 * Units.KILOMETRE;
    /**
     * Moon mass
     */
    public static final double MOON_MASS = 0.012300037 * EARTH_MASS;
    /**
     * Moon semi-major axis
     */
    public static final double MONN_SEMI_MAJOR_AXIS = 384399 * Units.KILOMETRE;
    /**
     * Solar radius
     */
    public static final double SOLAR_RADIUS = 695700 * Units.KILOMETRE;
    /**
     * Solar mass
     */
    public static final double SOLAR_MASS = 332946.0487 * EARTH_MASS;
    /**
     * Light speed
     */
    public static final double LIGHT_SPEED = 299792458.0 * Units.METRE_PER_SECOND;
    /**
     * Gravitational constant
     */
    public static final double GRAVITATIONAL_CONSTANT = 6.67408E-11 * Units.METRE3 * (1.0 / Units.KILOGRAM) * (1.0 / (Units.SECOND * Units.SECOND)) ;
    /**
     * Gravitational acceleration - Earth (normal)
     */
    public static final double GRAVIT_ACC_EARTH = 9.80665 * Units.METRE_PER_SECOND2;
    /**
     * Planck constant
     */
    public static final double PLANCK_CONSTANT = 6.626070040E-34 * Units.METRE2 * Units.KILOGRAM / Units.SECOND;
    /**
     * Planck mass
     */
    public static final double PLANCK_MASS = 2.176470E-8 * Units.KILOGRAM;
    /**
     * Avagadro's constant
     */
    public static final double N_A = 6.022140857E23 / Units.MOLE;
    /**
     * Gas constant
     */
    public static final double R = 8.3144598 * Units.JOULE / (Units.KELVIN * Units.MOLE);
    /**
     * Boltzmann constant
     */
    public static final double BOLTZMANN_CONSTANT = R / N_A;
    /**
     * Neutron rest mass
     */
    public static final double NEUTRON_REST_MASS = 1.674927471E-27 * Units.KILOGRAM;
    /**
     * Neutron equivalent rest mass
     */
    public static final double NEUTRON_EQUIVALENT_REST_MASS = 939.5654133 * Units.MEGA_ELECTRONO_VOLT / (LIGHT_SPEED * LIGHT_SPEED);
    /**
     * Proton rest mass
     */
    public static final double PROTON_REST_MASS = 1.672621898E-27 * Units.KILOGRAM;
    /**
     * Proton equivalent rest mass
     */
    public static final double PROTON_EQUIVALENT_REST_MASS = 938.2720813 * Units.MEGA_ELECTRONO_VOLT / (LIGHT_SPEED * LIGHT_SPEED);
    /**
     * Elementary charge
     */
    public static final double ELEMENTARY_CHARGE = 1.6021766208E-19*Units.COULOMB;
    /**
     * Electron rest mass
     */
    public static final double ELECTRON_REST_MASS = 9.10938356E-31 * Units.KILOGRAM;
    /**
     * Electron equivalent rest mass
     */
    public static final double ELECTRON_EQUIVALENT_REST_MASS = 0.5109989461 * Units.MEGA_ELECTRONO_VOLT / (LIGHT_SPEED * LIGHT_SPEED);
    /**
     * Vacuum permittivity
     */
    public static final double VACUUM_PERMITTIVITY = 8.854187817E-12 * Units.AMPERE * Units.AMPERE * Units.SECOND * Units.SECOND * Units.SECOND * Units.SECOND / (Units.METRE3 * Units.KILOGRAM);
    /**
     * Vacuum permeability
     */
    public static final double VACUUM_PERMEABILITY = 4.0E-7 * Math.PI * Units.KILOGRAM * Units.METRE / (Units.SECOND * Units.SECOND * Units.AMPERE * Units.AMPERE);
}
