import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Next {
    static boolean interpret= true;
    static boolean waswrong = false;
    public static void main(String[] args) throws NoSuchFileException {
        System.out.println("Hello World!");
        ArrayList<Integer> output;
        String filepath = "input.txt";
        StringBuilder inputBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filepath));

            for (int i = 0; i < lines.size(); i++) {
                inputBuilder.append(lines.get(i)).append("\n");
            }
        } catch (IOException e) {
            throw new NoSuchFileException("file not found ig?");
        }
        String input = inputBuilder.toString();
        /*input="[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] ad\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] gold\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] quartz\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] ad\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 1 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] gold\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 4 block(s)]\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@] quartz\n" +
                "[11:34:29] [Render thread/INFO]: [System] [CHAT] [@: Successfully filled 5 block(s)]";*/
        //System.out.println("Input: \n" + input + "\n----------");
        ArrayList<Integer> array = inputInNumArray(input);
        int height=1;
        try {
        System.out.println("Höhe | Ancient Debris | Nether Gold Ore | Nether Quartz Ore");
        for (int i = 0; i+2 < array.size(); i+=3) {
            System.out.println(height + "|"+array.get(i) + "|" + array.get(i+1) + "|" + array.get(i+2));
            height++;
        }} catch (ArrayIndexOutOfBoundsException ignored){}
    }





    private static ArrayList<Integer> inputInNumArray(String input) {
        input = input.replaceAll("\\[\\d{2}:\\d{2}:\\d{2}] \\[Render thread/INFO]: \\[System] \\[CHAT] \\[@", "");
        input=input.replaceAll("] ", "");
        input=input.replaceAll(": Successfully filled ", "");
        input=input.replaceAll(" block\\(s\\)]", "");
        //System.out.println(input);
        String[] lines = input.split("\\n");
        ArrayList<Integer> nums = new ArrayList<>();
        try {
        for (int i = 0; i < lines.length; i+=2) {
            //System.out.println("current line: " + Arrays.toString(lines[i].toCharArray()));
            if (lines[i].equals("ad")) {
                if (lines[i+1].equals("gold")) {
                    nums.add(0);
                    i--;
                    continue;
                } else nums.add(Integer.valueOf(lines[i+1]));
            }
            if (lines[i].equals("gold")) {
                if (lines[i+1].equals("quartz")) {
                    nums.add(0);
                    i--;
                    continue;
                } else nums.add(Integer.valueOf(lines[i+1]));
            }
            if (lines[i].equals("quartz")) {
                if (lines[i+1].equals("ad")) {
                    nums.add(0);
                    i--;
                } else nums.add(Integer.valueOf(lines[i+1]));
            }
        } }catch (ArrayIndexOutOfBoundsException ignored){}
        return nums;
    }
}
