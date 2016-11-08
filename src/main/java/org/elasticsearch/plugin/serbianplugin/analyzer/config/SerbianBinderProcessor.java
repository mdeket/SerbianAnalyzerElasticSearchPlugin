/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elasticsearch.plugin.serbianplugin.analyzer.config;

import org.elasticsearch.index.analysis.AnalysisModule;

/**
 *
 * @author Milan Deket
 */
public class SerbianBinderProcessor extends AnalysisModule.AnalysisBinderProcessor  {
    @Override
    public void processAnalyzers(AnalyzersBindings analyzersBindings) {
            analyzersBindings.processAnalyzer(SerbianAnalyzerProvider.NAME,
                    SerbianAnalyzerProvider.class);
    }
}
