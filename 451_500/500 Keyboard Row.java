//Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
public String[] findWords(String[] words) {
    ArrayList<String> arrayList = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
		char[] temp = words[i].toCharArray();
		if (containA(temp)||containQ(temp)||containZ(temp)) {
			arrayList.add(words[i]);
		}
	}
    String[] reStrings = arrayList.toArray(new String[arrayList.size()]);
    return reStrings;
}
public boolean containQ(char[] temp) {
	char[] cq = {'q','w','e','r','t','y','u','i','o','p'};
	Set<Character> setq = new HashSet<>();
	for (int i = 0; i < cq.length; i++) {
		setq.add(cq[i]);
	}
	for (int i = 0; i < temp.length; i++) {
		if (!setq.contains(Character.toLowerCase(temp[i]))) {
			return false;
		}
	}
	return true;
}
public boolean containA(char[] temp) {
	char[] ca = {'a','s','d','f','g','h','j','k','l'};
	Set<Character> seta = new HashSet<>();
	for (int i = 0; i < ca.length; i++) {
		seta.add(ca[i]);
	}
	for (int i = 0; i < temp.length; i++) {
		if (!seta.contains(Character.toLowerCase(temp[i]))) {
			return false;
		}
	}
	return true;
}
public boolean containZ(char[] temp) {
	char[] cz = {'z','x','c','v','b','n','m'};
    Set<Character> setz = new HashSet<>();
    for (int i = 0; i < cz.length; i++) {
		setz.add(cz[i]);
	}
    for (int i = 0; i < temp.length; i++) {
		if (!setz.contains(Character.toLowerCase(temp[i]))) {
			return false;
		}
	}
	return true;
}
