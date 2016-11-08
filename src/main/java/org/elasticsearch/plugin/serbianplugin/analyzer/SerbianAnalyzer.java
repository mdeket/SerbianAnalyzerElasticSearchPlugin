package org.elasticsearch.plugin.serbianplugin.analyzer;


import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.snowball.SnowballFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;


public class SerbianAnalyzer extends Analyzer {

        Version version;
	
        private CharArraySet serbianStopSet;
                
	private static final String[] SERBIAN_STOP_WORDS = {
		"biti", "ne", 
		"jesam", "sam", "jesi", "si", "je", "jesmo", "smo", "jeste", "ste", "jesu", "su",
		"nijesam", "nisam", "nijesi", "nisi", "nije", "nijesmo", "nismo", "nijeste", "niste", "nijesu", "nisu",
		"budem", "budeš", "bude", "budemo", "budete", "budu",
		"budes",
		"bih",  "bi", "bismo", "biste", "biše", 
		"bise",
		"bio", "bili", "budimo", "budite", "bila", "bilo", "bile", 
		"ću", "ćeš", "će", "ćemo", "ćete", 
		"neću", "nećeš", "neće", "nećemo", "nećete", 
		"cu", "ces", "ce", "cemo", "cete",
		"necu", "neces", "nece", "necemo", "necete",
		"mogu", "možeš", "može", "možemo", "možete",
		"mozes", "moze", "mozemo", "mozete"};
        
	/*
	 * TODO
	 * prosiriti listu stop reci
	 */
	
	/**
	 * 
	 */
	public SerbianAnalyzer(Version version) {
		super();
		this.version = version;
		serbianStopSet = StopFilter.makeStopSet(this.version, SERBIAN_STOP_WORDS);
	}
	
	public SerbianAnalyzer(){
		super();
		this.version = Version.LUCENE_4_9;
		serbianStopSet = StopFilter.makeStopSet(version, SERBIAN_STOP_WORDS);
	}


	@Override
	protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
            
            Tokenizer source = new StandardTokenizer(version,reader);
                
            TokenStream result = new LowerCaseFilter(version, source);
            
            result = new LatCyrFilter(result);

            result = new StopFilter(version, result, serbianStopSet);

            result = new SnowballFilter(result, new SerbianStemmer());

            result = new RemoveAccentsFilter(result, true);

            return new TokenStreamComponents(source, result);
	}

}
