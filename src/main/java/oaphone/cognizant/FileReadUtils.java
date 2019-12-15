package oaphone.cognizant;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Tool class to read file in Mac
 *
 * @author Jeff
 * @version 1.0
 * @date 03/22/2019
 */
public class FileReadUtils {

    public static void main(String[] args) {
        FileReadUtils fileReadUtils = new FileReadUtils();
        String absoluteFilePath = fileReadUtils.getFilePath();

        String str = "elephant";
        char c = 'e';
        System.out.println("Count the number of char '" + c + "' from String " + str + " is : " + fileReadUtils.countChar(str, c));
        try {
            long number = fileReadUtils.countDistinctWordsByJava8();
            System.out.println("The number of unique words is " + number);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            String string = fileReadUtils.readFileBynewBufferedReader(absoluteFilePath);
            System.out.println("Read file by newBufferedReader : " + string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("================readFileByJava8========Start=======");
        try {
            Stream<String> stream = fileReadUtils.readFileByJava8(absoluteFilePath);
            //stream.forEach( element -> { System.out.println(element); });
            List<String> list = new ArrayList<>();
            list = stream
                    //.filter(line -> line.startsWith(""))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            System.out.println("=====readFileByJava8====Middle======" + list.toString());
            /*List<String> asList = stream.collect(Collectors.toList());
            String resu = Stream.of(stream).toString();
            stream.forEach(s->System.out.println(s));;*/
            /*stream = stream
                    .peek(s -> System.out.println(s));*/
            //Stream<String> stringStream = stream.filter(s-> s.length()<=120);
            //stream = stream.filter(s -> s.length()<=100);  //注意这个
            //stream.forEach(System.out::println);
            /*String concat = stringStream.collect(StringBuilder::new, StringBuilder::append,
                                          StringBuilder::append)
                                 .toString();
            ;*/
            /*System.out.println(stream.collect(Collectors.toList()));
            Supplier<Stream<String>> streamSupplier
                    = () -> stream;
            Optional<String> result1 = streamSupplier.get().findAny();
            System.out.println("result1.get() : " + result1.get());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("================readFileByJava8=========End======");

        List<String> list = fileReadUtils.readFileByTradition(absoluteFilePath);
        StringBuilder sb = new StringBuilder();
        list.forEach(x -> sb.append(x));
        System.out.println("Merge lines to one sentence : " + sb.toString());
        long freqCount = fileReadUtils.searchFrequencyofOneWord(sb.toString(), "line");
        System.out.println("The frequency of word 'line' is : " + freqCount);

        try {
            Map<String, Long> stringLongMap = fileReadUtils.countByJava8(absoluteFilePath);
            System.out.println("Java 8 : count the frequency of each word (Version 1) : " + stringLongMap.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Long> freqCountMap = fileReadUtils.readFileAndCountWordFrequency(absoluteFilePath);
        System.out.println("Java 8 : count the frequency of each word (Version 2) : " + freqCountMap.toString());
    }

    private String getFilePath() {
        String filename = "1.txt";
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator + filename;
        System.out.println("Final filepath : " + absoluteFilePath);
        return absoluteFilePath;
    }

    private List<String> readFileByTradition(String filePath) {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (IOException ie) {
            System.err.format("IOException occurred trying to read '%s'.", ie.getMessage());
            //log.error(ie);
            return null;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", e.getMessage());
            //log.error(e);
            return null;
        }
    }

    /**
     * @param filePath
     * @return
     * @throws IOException
     */
    private String readFileBynewBufferedReader(String filePath) throws IOException {
        Path path = null;
        try {
            path = Paths.get(filePath);
        } catch (InvalidPathException ipe) {
            //log.error(ipe);
            return "";
        }
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            StringBuilder builder = new StringBuilder();
            for (int c = reader.read(); c != -1; c = reader.read()) {
                builder.append((char) c);
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            //log.error(e);
        } catch (IOException e) {
            //log.error(e);
        }
        return "";
    }

    private Stream<String> readFileByJava8(String filePath) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return stream;
        }
    }

    private long searchFrequencyofOneWord(final String sentence, final String toSearch) {
        return Arrays.stream(sentence.split(" "))
                .filter(str -> str.equals(toSearch))
                .count();
    }

    /**
     * filter the , . ? # $ sign
     *
     * @param filePath
     * @return
     */
    private Map<String, Long> readFileAndCountWordFrequency(String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            Stream<String> stream = br.lines();
            Map<String, Long> map = countFrequency(stream);
            return map;
        } catch (IOException e) {
            //log.error(e);
        }
        return null;
    }

    private Map<String, Long> countFrequency(Stream<String> valueStream) {
        return valueStream
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .map(FileReadUtils::clean)
                .filter(s -> !s.equals(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static String clean(String word) {
        return word.replaceAll("[1234567—890!@#$%^&*()_+|\\-=~`{}\\[\\]:;\"<>,.?/]", "").toLowerCase();
    }

    /**
     * Didn't filter , . # $
     *
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    private long countDistinctWordsByJava8() throws IOException, URISyntaxException {
        final String workingDirectory = System.getProperty("user.dir");
        final String absoluteFilePath = workingDirectory + File.separator + "1.txt";

        long uniqueWords = java.nio.file.Files
                .lines(Paths.get(absoluteFilePath), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ."))).distinct()
                .count();
        return uniqueWords;
    }

    public Map<String, Long> countByJava8(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Map<String, Long> wordMap = Files.lines(path)
                .parallel()
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                //.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                //.collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));

        wordMap.forEach((k, v) -> System.out.println(String.format(k, v)));
        return wordMap;
    }

    private long countChar(String inputString, char target) {
        long count = inputString.chars().filter(ch -> ch == target).count();
        return count;
    }
}
