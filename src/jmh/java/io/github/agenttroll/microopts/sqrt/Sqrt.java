package io.github.agenttroll.microopts.sqrt;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class Sqrt {
    private static final double[] TEST_RANGES = {
            1, 10,
            100, 1_000,
            10_000, 50_000,
            100_000, 500_000,
            1_000_000, 5_000_000
    };

    @Param({"0", "2", "4", "6", "8"})
    private int range;

    private double randDouble;

    @Setup(Level.Iteration)
    public void setUp() {
        double lowerBound = TEST_RANGES[range];
        double upperBound = TEST_RANGES[range + 1];
        this.randDouble = ThreadLocalRandom.current()
                .nextDouble(lowerBound, upperBound);
    }

    @Benchmark
    public double sqrt() {
        return Math.sqrt(this.randDouble);
    }
}
