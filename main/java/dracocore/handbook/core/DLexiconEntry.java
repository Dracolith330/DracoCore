package dracocore.handbook.core;

import dracocore.CoreMain;

public class DLexiconEntry extends BLexiconEntry {

	public DLexiconEntry(String unlocalizedName, LexiconCategory category) {
		super(unlocalizedName, category);
		setKnowledgeType(CoreMain.draconianKnowledge);
	}

}
