package util;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
public class APIListUtil {
    // All Lists of Requestable are initialized after they are accessed to save time
    public static List initFromUrls(List items, List<String> urls, Class type) {
        if (items.size() != urls.size()) {
            items.removeIf(item -> true);
            for (String url : urls) {
                try {
                    String json = RequestMaker.get(url);
                    items.add(GSONParser.getInstance().fromJson(json, type));
                } catch (IOException e) {
                    System.out.println("Failed to retrieve " + url);
                }
            }
        }
        return items;
    }
}
