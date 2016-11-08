/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elasticsearch.plugin.serbianplugin.analyzer;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 *
 * @author Milan Deket
 */
public class RemoveAccentsFilter extends TokenFilter {
    private LatCyrUtils LatCyrUtils;
    private CharTermAttribute termAttribute;
    
    public RemoveAccentsFilter(TokenStream input, boolean replaceDj) {
        super(input);
        replaceDj = true;
	termAttribute = (CharTermAttribute) input.addAttribute(CharTermAttribute.class); 
    }
    
    
    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
        	String text = termAttribute.toString();
        	termAttribute.setEmpty();
        	termAttribute.append(LatCyrUtils.removeAccents(text).replace("Dj", "D").replace("dj", "d"));
        	return true;
        }
        return false;
    }

}
