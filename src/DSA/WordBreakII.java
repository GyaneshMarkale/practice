package DSA;

public class WordBreakII {
    public static void main(String[] args)
    {
        Trie trie = new Trie();
        trie.insert("word");
    }
}

class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    String word;

    public boolean contains(char ch)
    {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch)
    {
        return links[ch - 'a'];
    }

    public void put (char ch, Node node)
    {
        links[ch - 'a'] = node;
    }

    public boolean isWord()
    {
        return flag;
    }

    public void setWordExist()
    {
        flag = true;
    }

    public void setWord(String s)
    {
        word = s;
    }
}
class Trie {
    Node root;
    Trie()
    {
        root = new Node();
    }

    public void insert (String s)
    {
        Node node = root;
        for (int i = 0; i < s.length(); i++)
        {
            if (!node.contains(s.charAt(i)))
            {
                node.put(s.charAt(i), new Node());
            }
            node = node.get(s.charAt(i));
        }
        node.setWordExist();
        node.setWord(s);
    }
}
