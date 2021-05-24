# Volatile Uncontended

Does the performance of `volatile` read/writes change
without contention?

# Running

``` shell
./gradlew jmh -Pargs="VolatileUncontended.*"
```

# Results

```
Benchmark                          Mode  Cnt   Score   Error  Units
VolatileUncontended.baseline       avgt    5   0.461 ± 0.002  ns/op
VolatileUncontended.normalRead     avgt    5   2.613 ± 0.038  ns/op
VolatileUncontended.normalWrite    avgt    5   1.976 ± 0.014  ns/op
VolatileUncontended.tlrNextInt     avgt    5   4.003 ± 0.020  ns/op
VolatileUncontended.volatileRead   avgt    5   2.607 ± 0.018  ns/op
VolatileUncontended.volatileWrite  avgt    5  10.133 ± 0.034  ns/op
```
