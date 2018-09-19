
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class Main {
    public static void main(String[] unused) {
        System.out.println("The number of word is " + urlToString("http://erdani.com/tdpl/hamlet.txt").length());
        String[] x = urlToString("http://erdani.com/tdpl/hamlet.txt").split(" ");
        System.out.println("The number of one word is " + x.length);
        System.out.println("The number of selected word is " + uniqueWord("of"));
        System.out.print(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int uniqueWord(final String unique) {
        int count = 0;
        int length = unique.length();
        String[] x = urlToString("http://erdani.com/tdpl/hamlet.txt").split(" ");
        int contentLength = x.length;
        for (int i = 0; i < contentLength; i++) {
            String jj = x[i];
            if (jj.length() != length) {
                continue;
            } else {
                for (int j = 0; j < length; j++) {
                    if(unique.charAt(j) != jj.charAt(j)) {
                        break;
                    } else if (j == length - 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
