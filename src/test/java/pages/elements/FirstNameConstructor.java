package pages.elements;

import java.util.*;


public class FirstNameConstructor {

    public String[] splitPostCode(String postCode) {

        String[] splitPostCodeOneElem = new String[postCode.length()];

        for (int i = 1; i < postCode.length(); i++) {
            splitPostCodeOneElem = postCode.split("");

        }
        return splitPostCodeOneElem;
    }

    public List<String> joinPostCode(String[] splitPostCodeOneElem) {

        String[] splitPostCodeTwoElem = new String[splitPostCodeOneElem.length];

        List<String> splitPostCodeStr = new ArrayList<>();
        for (int i = 0; i < splitPostCodeOneElem.length - 1; i = i + 2) {
            splitPostCodeTwoElem[i] = String.join("", splitPostCodeOneElem[i], splitPostCodeOneElem[i + 1]);
            splitPostCodeStr = new ArrayList<>(Arrays.asList(splitPostCodeTwoElem));
            splitPostCodeStr.removeIf(Objects::isNull);

        }
        return splitPostCodeStr;

    }

    public List<Integer> convertPostCodeToNum(ArrayList<String> splitPostCodeStr) {

        List<Integer> splitPostCodeNum = new ArrayList<>();
        for (int i = 0; i < splitPostCodeStr.size(); i++) {
            splitPostCodeNum.add(i, Integer.parseInt(splitPostCodeStr.get(i)));
        }
        return splitPostCodeNum;
    }

    public Map<Integer, String> createMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "a");
        map.put(1, "b");
        map.put(2, "c");
        map.put(3, "d");
        map.put(4, "e");
        map.put(5, "f");
        map.put(6, "g");
        map.put(7, "h");
        map.put(8, "i");
        map.put(9, "j");
        map.put(10, "k");
        map.put(11, "l");
        map.put(12, "m");
        map.put(13, "n");
        map.put(14, "o");
        map.put(15, "p");
        map.put(16, "q");
        map.put(17, "r");
        map.put(18, "s");
        map.put(19, "t");
        map.put(20, "u");
        map.put(21, "v");
        map.put(22, "w");
        map.put(23, "x");
        map.put(24, "y");
        map.put(25, "z");

        return map;
    }

}
