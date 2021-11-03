package GeneratorDictionary;

import java.util.Arrays;
import java.util.List;

//final-переменная text и immutable-объект CreateListText
public class CreateListText {
    private final String text;

    public CreateListText(String text) {
        this.text = text;
    }

    //Детерминированность функций и реализация монад.
    private SplitTextFunction splitTextFunction = (s) -> Arrays
            .stream(s.split(" "))
            .map(x -> x.toUpperCase())
            .sorted()
            .toList();

    public List<String> splitAborigenText() {
        return splitTextFunction.splitText(text);
    }


}