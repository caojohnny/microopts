# `microopts`

Repository containing the source code and results for
various different micro-optimizations that probably aren't
worth considering.

The purpose is to demonstrate correct benchmarking
practices. There aren't any profoundly useful benchmarks,
only those that probably reinforce existing best-practice
advice that has been around for a while.

These results are simply put out there for reference. As
the JMH disclaimer states, these results mean nothing
without further analysis. Always take performance data
with a grain of salt and take performance claims with an
even smaller grain of salt.

# Building

``` shell
git clone https://github.com/AgentTroll/microopts.git
cd microopts
```

Instructions to run each benchmark can be found in their
respective packages. To run multiple benchmarks, use the
following arguments:

```shell
./gradlew jmh -Pargs="[Sqrt.*, Rounding.*]"
```

The `args` property follows the JMH command-line options,
so use `-Pargs="-help"` to print a help message.

# Results

Results are collected and stored with their respective
source packages.

Most of these results were obtained on a MacBook Pro
(Retina, 15-inch, Mid 2014):

  * 2.2 GHz Quad-Core Intel Core i7
  * 16 GB 1600 MHz DDR3
  * 251 GB APPLE SSD SM0256F

# Credits

Built with [IntelliJ IDEA](https://www.jetbrains.com/idea/)

Utilizes:

  * [JMH](https://openjdk.java.net/projects/code-tools/jmh/)
