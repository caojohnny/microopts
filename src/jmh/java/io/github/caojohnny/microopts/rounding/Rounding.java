package io.github.caojohnny.microopts.rounding;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class Rounding {
    private Location loc;

    @Setup(Level.Iteration)
    public void setUp() {
        double randDouble = ThreadLocalRandom.current()
                .nextDouble();
        this.loc = new Location(randDouble);
    }

    @Benchmark
    public double testGetBlockX() {
        return loc.getBlockX() + 0.5;
    }

    @Benchmark
    public double testExternalFloorX() {
        return (Math.floor(loc.getX())) + 0.5;
    }

    // Source: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/Location.java
    private static class Location {
        private double x;

        public Location(double x) {
            this.x = x;
        }

        public double getX() {
            return this.x;
        }

        public int getBlockX() {
            return locToBlock(this.x);
        }

        public static int locToBlock(double loc) {
            return NumberConversions.floor(loc);
        }
    }

    // Source: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/util/NumberConversions.java
    public static final class NumberConversions {
        private NumberConversions() {
        }

        public static int floor(double num) {
            final int floor = (int) num;
            return floor == num ? floor : floor - (int) (Double.doubleToRawLongBits(num) >>> 63);
        }
    }
}
