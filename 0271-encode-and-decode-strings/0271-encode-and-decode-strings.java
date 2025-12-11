public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for ( String str : strs ) {
            result.append(str);
            result.append("∞");
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> resultList = new ArrayList<>();
        String[] decodeList = s.split("∞", -1);

        for ( int i=0; i<decodeList.length-1; i++ ) {
            resultList.add(decodeList[i]);
        }
        return resultList;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));