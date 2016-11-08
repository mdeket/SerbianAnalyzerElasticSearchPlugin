/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elasticsearch.plugin.serbianplugin.analyzer.config;

import java.io.IOException;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.elasticsearch.index.settings.IndexSettings;
import org.elasticsearch.plugin.serbianplugin.analyzer.SerbianAnalyzer;

/**
 *
 * @author Milan Deket
 */
public class SerbianAnalyzerProvider extends AbstractIndexAnalyzerProvider{

    @Inject
    public SerbianAnalyzerProvider(Index index, @IndexSettings Settings indexSettings, Environment env, @Assisted String name, @Assisted Settings settings) throws IOException {
        super(index, indexSettings, name, settings);
    }
    
    @Override
    public SerbianAnalyzer get() {
        return this.analyzer;
    }
    
    protected SerbianAnalyzer analyzer = new SerbianAnalyzer();
    public static final String NAME = "serbian_analyzer";
}
