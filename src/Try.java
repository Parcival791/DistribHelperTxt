import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Try {
    public static boolean expects = true; //false -> name | true -> nummer
    public static void main(String[] args) throws Exception {
        //String input = "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] ad\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] gold\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] quartz\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] ad\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 2 block(s)]\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] gold\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 4 block(s)]\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] quartz\n" + "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 5 block(s)]";
        String input="";
        String filepath = "input.txt";
        try {
            input = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (NoSuchFileException e) {
            throw new NoSuchFileException("file not found ig?");
        }
        input= kürzen(input);
        System.out.println("Input: ");

        System.out.println(input);

        System.out.println("input ende");

        String[] lines = input.split("\\n");
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            if(expects) {
                expects= false;
                System.out.println("expects text" + lines[i]);
            } else {
                try {

                    nums.add(Integer.parseInt(lines[i]));

                } catch (NumberFormatException ignored) {
                    System.out.println(lines[i]);
                    nums.add(0);
                    System.out.println("got text, expected num: " + Arrays.toString(lines[i].toCharArray()));
                    i--;
                }
                expects=!expects;
            }
        }
        System.out.println(nums);
        System.out.println("now packing");



        ArrayList<ArrayList<Integer>> packed = packing(nums);
        System.out.println(packed);





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
    private static String kürzen(String input) {
        String output="";

        output=input.toLowerCase();
        output=output.replaceAll("\\[\\d{2}:\\d{2}:\\d{2}] \\[render thread/info]: \\[system] \\[chat] \\[@] ", "");
        output=output.replaceAll("\\[\\d{2}:\\d{2}:\\d{2}] \\[render thread/info]: \\[system] \\[chat] \\[@: successfully filled ", "");
        output=output.replaceAll(" block\\(s\\)]", "");


        return output;
    }
}
