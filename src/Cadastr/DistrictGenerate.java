package Cadastr;

import java.util.List;

@FunctionalInterface
public interface DistrictGenerate {
    List<int[]> generate(int length, int width, int cost, int limit);
}

