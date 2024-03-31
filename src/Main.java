import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String input;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        /*String filepath = "input.txt";
        try {
            input = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
            throw new Exception(e);
        } */

        input = "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] ad\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] gold\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] quartz\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] ad\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] gold\n" +
                //"[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 4 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] quartz\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 5 block(s)]";

        System.out.println(kürzen(input));
        System.out.println("Hi!");
        ArrayList<Integer> array = array(kürzen(input));
        System.out.println("Array: ");
        System.out.println(array);
        ArrayList<ArrayList<Integer>> packed = packing(array);
        System.out.println("Packed");
        System.out.println(packed);







    }

    private static void tabellieren(ArrayList<ArrayList<Integer>> input) {
        System.out.println("Höhe | Ancient Debris | Nether Gold Ore | Nether Quartz Ore");
        for (int i = 0; i < input.size(); i++) {

        }
    }


    private static String kürzen(String input) {
        String output="";

        output=input.toLowerCase();
        output=output.replaceAll("\\[\\d{2}:\\d{2}:\\d{2}] \\[render thread/info]: \\[system] \\[chat] \\[@] ", "");
        output=output.replaceAll("\\[\\d{2}:\\d{2}:\\d{2}] \\[render thread/info]: \\[system] \\[chat] \\[@: successfully filled ", "");
        output=output.replaceAll(" block\\(s\\)]", "");


        return output;
    }


    private static ArrayList<Integer> array(String input) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        // String in Zeilen aufteilen
        String[] lines = input.split("\\n");

        // Zeilen verarbeiten und Zahlen zur ArrayList hinzufügen oder 0 falls keine Zahl vorhanden ist
        for (int i = 1; i < lines.length; i += 2) {
            lines[i]=lines[i].replaceAll("\\[", "");
            lines[i]=lines[i].replaceAll(",", "");
            try {
                int number = Integer.parseInt(numberString(lines[i]));
                arrayList.add(number);
            } catch (NumberFormatException e) {
                // Füge 0 hinzu, falls keine Zahl vorhanden ist
                System.out.println("test");
                arrayList.add(0);
                System.out.println(arrayList);
            }
        }

        // ArrayList returnen
        return arrayList;
    }

    private static String numberString(String input) {
        StringBuilder numberStr = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numberStr.append(c);
            } else if (numberStr.length() > 0) {
                break; // Stop when non-digit is encountered after finding numbers
            }
        }
        return numberStr.toString();
    }


    private static ArrayList<ArrayList<Integer>> packing(ArrayList<Integer> inList) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        int index = 0;
        while (index + 2 < inList.size()) {
            ArrayList<Integer> sublist = new ArrayList<>();
            sublist.add(inList.get(index));
            sublist.add(inList.get(index + 1));
            sublist.add(inList.get(index + 2));
            resultList.add(sublist);
            index += 3;
        }
        return resultList;
    }

    /*private static void gpt(String input) {
        int line=0;
        int itemNum=0;

                // Regulärer Ausdruck, um die Zeilen mit dem gewünschten Muster zu extrahieren
                String regex = "\\[@\\] (\\w+)(?:\\R\\[.*\\]\\[@: Successfully filled (\\d+) block\\(s\\)\\])?";

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);

                // Iteriere über die gefundenen Übereinstimmungen und verarbeite sie
                while (matcher.find()) {
                    String item = matcher.group(1);
                    System.out.println("Matcher " + matcher.group(2));
                    String quantity = matcher.group(2) != null ? matcher.group(2) : "0";

                    System.out.print("Layer " + line +" : " + item + ": ");
                    System.out.println(quantity);
                    itemNum++;
                    if(itemNum==3) {
                        itemNum=0;
                        line++;
                    }
                }
            }*/
    public static int[][] create2DArray(String[] inputLines) {
        // Bestimme die maximale Indexnummer
        int maxIndex = 0;
        for (String line : inputLines) {
            try {
                int index = Integer.parseInt(line);
                if (index > maxIndex) {
                    maxIndex = index;
                }
            } catch (NumberFormatException e) {
                // Ignore non-integer lines
            }
        }

        // Erstelle den 2D-Array
        int[][] array = new int[1][maxIndex];

        // Fülle den Array basierend auf den Eingaben
        for (String line : inputLines) {
            try {
                int value = Integer.parseInt(line);
                array[0][value - 1] = value;
            } catch (NumberFormatException e) {
                // Ignore non-integer lines
            }
        }

        return array;
    }
}


