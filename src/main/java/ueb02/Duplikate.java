package ueb02;

class Duplikate {
	/**
	 * Gibt ein StringSet mit den Wörtern zurück, welche mindestens zwei mal im Text vorkommen.
	 * Alle Satzzeichen im Text sollen ignoriert werden.
	 * @param text Eingabetext, kann Satzzeichen enthalten welche ignoriert werden.
	 * @return StringSet mit den Wörtern, welche mind. zwei mal vorkommen.
	 */
	static StringSet findeDuplikate(String text) {
		// TODO Implementieren Sie die Methode gemäß dem obigen Javadoc Kommentar.

		String myString = text.replaceAll("[^a-zA-Z 0-9]", "");
		String[] words = myString.split(" ");

		StringSetImpl impl = new StringSetImpl();
		StringSetImpl doppelt = new StringSetImpl();

		for(String s: words) {
			if(impl.contains(s)) {
				doppelt.add(s);
			} else {
				impl.add(s);
			}
		}

		return doppelt;
	}
}
