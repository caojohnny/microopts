# Volatile R/W

What is the performance penalty of a `volatile` write/read?

# Running

``` shell
./gradlew jmh -Pargs="Volatile.*"
```

# Results

```
Benchmark               Mode  Cnt    Score   Error  Units
Volatile.baseline       avgt    5    0.537 ± 0.020  ns/op
Volatile.normalRead     avgt    5    3.044 ± 0.414  ns/op
Volatile.normalWrite    avgt    5   11.301 ± 0.081  ns/op
Volatile.tlrNextInt     avgt    5    5.197 ± 1.833  ns/op
Volatile.volatileRead   avgt    5    3.115 ± 0.076  ns/op
Volatile.volatileWrite  avgt    5  112.476 ± 4.195  ns/op
```
