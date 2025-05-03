public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for (String s : strs) {
          sb.append(s.length());
          sb.append(":/");
          sb.append(s);
      }
      return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
      int i = 0;
      List<String> l = new ArrayList();
      while (i < s.length()) {
          int idx = s.indexOf(":/", i);
          String length = s.substring(i, idx);
          String ss = s.substring(idx + 2, idx + 2 + Integer.valueOf(length));
          l.add(ss);
          i = idx + 2 + Integer.valueOf(length);
      }
      return l;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
