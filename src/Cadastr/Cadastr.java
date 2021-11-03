package Cadastr;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Cadastr {
    final int lengthDistricts;
    final int widthDistricts;
    final int costDistricts;
    final int limitDistricts;

    public Cadastr(int lengthDistricts, int widthDistricts, int costDistricts, int limitDistricts) {
        this.lengthDistricts = lengthDistricts;
        this.widthDistricts = widthDistricts;
        this.costDistricts = costDistricts;
        this.limitDistricts = limitDistricts;
    }

    //генерация участков
    private DistrictGenerate districtGenerate = (length, width, cost, limit) ->
            // генерация длинны участка
            Stream.generate(() ->new int[]{
                        new Random().nextInt(length)+1,
                        new Random().nextInt(width)+1,
                        new Random().nextInt(cost)+1
            }).limit(limit).collect(Collectors.toList());

    public List<int[]> setDistrictGeneratet() {
        return districtGenerate.generate(lengthDistricts,widthDistricts,costDistricts,limitDistricts);
    }

    public Map<String,List<int[]>> groupingAllDistrict( int cost, List<int[]> list){
        return list.stream().collect(groupingBy(
                x->{
                    if(x[2]>x[0]*x[1]*cost) return "Это не честная сделка при цене за квадра " + cost +"(слишком дешево)";
                    else return "Это честная сделка при цене за квадрат " + cost ;
                }
        ));

    }


}

