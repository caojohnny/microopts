# Rounding

This experiment was prompted by the following SpigotMC
thread: https://www.spigotmc.org/threads/which-location-option-would-be-better-for-performance.477397/

# Running

``` shell
./gradlew jmh -Pargs="Rounding.*"
```

# Results

```
Benchmark                    Mode  Cnt  Score   Error  Units
Rounding.testExternalFloorX  avgt    5  3.316 ± 0.008  ns/op
Rounding.testGetBlockX       avgt    5  4.809 ± 0.011  ns/op
```

# Credits

Utilizes some code from [Bukkit](https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse)
