# TypeCheck

This experiment was prompted by the following SpigotMC
thread: 

# Running

``` shell
./gradlew jmh -Pargs="TypeCheck.*"
```

# Results

```
Benchmark             Mode  Cnt  Score   Error  Units
TypeCheck.instanceOf  avgt   25  2.727 ± 0.019  ns/op
TypeCheck.typeEquals  avgt   25  6.287 ± 0.585  ns/op
```
