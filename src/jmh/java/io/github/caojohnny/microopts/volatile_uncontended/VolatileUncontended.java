package io.github.caojohnny.microopts.volatile_uncontended;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class VolatileUncontended {
    private volatile int volatileField;
    private int normalField;

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public int tlrNextInt() {
        return ThreadLocalRandom
                .current()
                .nextInt();
    }

    @Benchmark
    public int normalRead() {
        return this.normalField;
    }

    @Benchmark
    public void normalWrite() {
        this.normalField = ThreadLocalRandom
                .current()
                .nextInt();
    }

    @Benchmark
    public int volatileRead() {
        return this.volatileField;
    }

    @Benchmark
    public void volatileWrite() {
        this.volatileField = ThreadLocalRandom
                .current()
                .nextInt();
    }
}
