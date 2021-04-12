package io.github.agenttroll.microopts.typecheck;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Fork(5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class TypeCheck {
    private enum Type {
        ONE, TWO, THREE, FOUR, FIVE
    }

    private interface GenericType {
        Type getType();
    }

    private static class OneType implements GenericType {
        @Override
        public Type getType() {
            return Type.ONE;
        }
    }

    private static class TwoType implements GenericType {
        @Override
        public Type getType() {
            return Type.TWO;
        }
    }

    private static class ThreeType implements GenericType {
        @Override
        public Type getType() {
            return Type.THREE;
        }
    }

    private static class FourType implements GenericType {
        @Override
        public Type getType() {
            return Type.FOUR;
        }
    }

    private static class FiveType implements GenericType {
        @Override
        public Type getType() {
            return Type.FIVE;
        }
    }

    private static final GenericType[] types = new GenericType[Type.values().length];
    static {
        types[0] = new OneType();
        types[1] = new TwoType();
        types[2] = new ThreeType();
        types[3] = new FourType();
        types[4] = new FiveType();
    }

    private GenericType randType;

    @Setup(Level.Iteration)
    public void setup() {
        this.randType = types[
                ThreadLocalRandom.current().nextInt(types.length)];
    }

    @Benchmark
    public boolean instanceOf() {
        return this.randType instanceof OneType;
    }

    @Benchmark
    public boolean typeEquals() {
        return this.randType.getType() == Type.ONE;
    }
}
