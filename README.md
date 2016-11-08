# DESCRIPTION:  
SerbianAnalyzerElasticSearchPlugin is used for analyzing and preparing input text for indexing. 

This plugin has been written for ApacheLucene v4.9 and ElasticSearch v1.3.2.


# TEXT PROCESS FLOW:

It uses StandardTokenizer for creating tokens out of input text. After tokenizer tokens go trough five filters:

    1. LowerCaseFilter - filter transforms all characters from token to lowercase.
    2. LatCyrFilter - takes lowercase words, and turns them from cyrilic to latinic.
    3. StopFilter - removes the stop words/tokens.
    4. SnowballFilter - stems tokens, taking only root of the word.
    5. RemoveAccentsFilter - replaces 'Dj' to 'D'.
    
# HOW TO BUILD PLUGIN

To build SerbianAnalyzer you will need to have Apache Maven build tool installed.
It can be downloaded from https://maven.apache.org/download.cgi.
After installation, type 

    mvn -v 
in terminal, just to be sure that installation was successful.
Navigate to folder with SerbainPlugin, then run:

    mvn package
Maven will create 'target' folder in SerbianPlugin directory. Navigate to 
target/release/. Elasticsearch-SerbianPlugin-1.3.2.zip will be created there.

# HOW TO SETUP PLUGIN TO WORK WITH ELASTICSEARCH
To add this plugin navigate to elasticsearch`s bin folder, and run:

    plugin -url path_to_Elasticsearch-SerbianPlugin-1.3.2.zip --install serbian-plugin
Open elasticsearch configuration from elasticsearch/config/elasticsearch.yml
Find configuration for indexes, and put:

    index.analysis.analyzer.default.type: serbian_analyzer
Save configuration, go to the bin/plugin folder, and run:

    plugin -l
to check if plugin was successfully installed. 

# HOW TO REMOVE PLUGIN
Navigate to elasticsearch`s bin and run:

    plugin -r serbian-plugin
and remove configuration for serbian_analyzer from elasticsearch.yml.

