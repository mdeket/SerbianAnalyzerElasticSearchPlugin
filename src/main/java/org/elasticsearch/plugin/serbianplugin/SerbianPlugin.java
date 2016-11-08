/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elasticsearch.plugin.serbianplugin;

import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugin.serbianplugin.analyzer.config.SerbianBinderProcessor;
import org.elasticsearch.plugins.AbstractPlugin;

/**
 *
 * @author Milan Deket
 */
public class SerbianPlugin extends AbstractPlugin {

    @Override
    public String name() {
	return "serbian-plugin";
    }

    @Override
    public String description() {
        return "Analyzer that converts cyrilic words into lowercase latinic";
    }
    
    public void onModule(AnalysisModule analysisModule) {
			analysisModule.addProcessor(new SerbianBinderProcessor());
}
}
