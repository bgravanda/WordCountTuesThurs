package BSU.comp152;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        var wordCount = new HashMap<String,Integer>(2048);
	    var fileLOC = Paths.get("WarAndPeace.txt");
        List<String>allLines = null;
        try {
            allLines = Files.readAllLines(fileLOC);
        }catch (IOException e){
            System.out.println("error reading file");

        }
        if (allLines==null)
            System.exit(-1);
        for (var lines: allLines){
            var allwords = lines.split(" ");
            for (var word: allwords){
                word = word.replaceAll("\\p{Punct}","");
                var lowerCaseWord = word.toLowerCase(Locale.ROOT);
                if(wordCount.containsKey(lowerCaseWord)){
                    var currentCount = wordCount.get(lowerCaseWord);
                    wordCount.replace(lowerCaseWord,++currentCount);
                }
            }
        }
    }
}
