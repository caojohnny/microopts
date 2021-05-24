# Sqrt

Is the `Math#sqrt(double)` function as slow as people claim
it to be?

# Running

``` shell
./gradlew jmh -Pargs="Sqrt.*"
```

# Results

```
Benchmark                                     (range)  Mode  Cnt  Score   Error  Units
Sqrt.sqrt        0  avgt    5  6.117 ± 0.018  ns/op
Sqrt.sqrt        2  avgt    5  6.127 ± 0.021  ns/op
Sqrt.sqrt        4  avgt    5  6.125 ± 0.034  ns/op
Sqrt.sqrt        6  avgt    5  6.116 ± 0.015  ns/op
Sqrt.sqrt        8  avgt    5  6.112 ± 0.015  ns/op
```
