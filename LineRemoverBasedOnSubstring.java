import java.io.*;

public class LineRemoverBasedOnSubstring {

    public static void main(String[] args) {
        String inputFileName = "input.csv";
        String outputFileName = "output.csv";
        String[] stringsToRemove = new String[]{
                                                ".ps", ".be", ".bt", ".ms", ".sd", ".pk", ".sv", ".mq", ".dz",
                                                ".jo", ".mm", ".bn", ".vi", ".ws", ".tj", ".pn", ".sx", ".gw",
                                                ".hk", ".gf", ".bb", ".by", ".pt", ".jp", ".hu", ".ro", ".gw",
//                                                ".ph", ".fi", ".rs", ".mk", ".ly", ".tm", ".ke", ".md", ".gp",
//                                                ".to", ".id", ".cl", ".ir", ".mn", ".hr", ".ge", ".cn", ".sa",
//                                                ".pl", ".rw", ".co", ".sg", ".tt"
                                                };

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                boolean shouldRemove = false;
                for (String substringToRemove : stringsToRemove) {
                    if (line.contains(substringToRemove)) {
                        shouldRemove = true;
                        break;
                    }
                }
                if (!shouldRemove) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("All lines containing specified substrings has been removed.");
    }
}
