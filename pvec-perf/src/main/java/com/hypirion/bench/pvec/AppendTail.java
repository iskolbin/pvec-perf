package com.hypirion.bench.pvec;

import java.util.Random;
import com.hypirion.pvec.PVec;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Level;

@State(Scope.Benchmark)
public class AppendTail {

    @Param({"4", "8", "12", "16", "20", "24", "28"})
    public int offset;
    int size;

    PVec p;

    @Setup(Level.Trial)
    public void setup() {
        size = 32 + offset;
        p = new PVec();
        for (int i = 0; i < size; i++) {
            p = p.push(new Object());
        }
    }

    @Benchmark
    public PVec benchAppendTail() {
        return p.push(null);
    }
}
