<p><strong>SET-UP INSTRUCTIONS:</strong></p>
<p>This is a computational text analysis on news articles. We use the following two external packages:</p>
<ul>
<li>StanfordCore NLP (more info here: <a href="https://stanfordnlp.github.io/CoreNLP/">https://stanfordnlp.github.io/CoreNLP/</a>)</li>
<li>XChart (<a href="https://knowm.org/open-source/xchart/">https://knowm.org/open-source/xchart/</a>)</li>
</ul>
<p>Our analysis is set up as a maven roject, and therefore it is not necessary to download any .jar files. In order to run the analysis, you will need to dowload all of the files in the Design MileStone Folder, and set up the project as a maven project in your IDE of choice. (The pom.xml file is located here.) More info on setting up Maven projects can be found here: <a href="https://knowm.org/open-source/xchart/">http://maven.apache.org/guides/getting-started/</a></p>
<p>&nbsp;</p>
<p><strong>THE NITTY-GRITTY - HOW THE ANALYSIS IS DESIGNED:</strong></p>
<p>//I'll put a more detailed breakdown of how thngs are structured here&nbsp;</p>
<p><br /> <br /> <strong>TLDR; THE ANALYSIS - A BRIEF OVERVIEW:</strong></p>
<p>In order to run the analysis, you'll need to run the ProjectRunnerClass. In the console, you will be asked whether or not you would like to create an .ser file from a sample of the full dataset. We have included this option so that you (the user, the TA, etc) can see our RawDocumentReader class in action. When this class is run on the full data set, it takes arond four hours, due to the computationally-intensive tasks of sentiment analysis and named-entity recognition.&nbsp;</p>
<p>After the (optional) ceation of the test .ser file, the full analysis will being to run. When it is complete, a bare-bones swing window will display the following graphs:</p>
<p><em>Charts 1-4:</em>&nbsp;These charts display the average reading level and average lexical density for each news source in the corpus, as well as the z-scores for these averages. The goal of these charts was to give the user a sense of which sources might be written at a higher level, and which sources migth contain more information (ie: have a higher "lexical density" score.) We also chose to plot the z-scores of each of these etrics to give the user a sense of how much variance there was in these two metrics, across the different sources in the corpus. Ie - which sources really stand out in terms of being extra-dense or extra-hard, or alternatively,&nbsp; extra-fluffy or extra-easy.&nbsp;</p>
<p>&nbsp;</p>