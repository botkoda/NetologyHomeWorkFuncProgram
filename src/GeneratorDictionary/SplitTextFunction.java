package GeneratorDictionary;

import java.util.List;

@FunctionalInterface
public interface SplitTextFunction {
    List<String> splitText(String s);
}
