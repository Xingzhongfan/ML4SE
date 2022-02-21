# ML4SE
# MileStone 1
The project we chose to analyze is the Apache Commons CLI:<https://github.com/apache/commons-cli>.

We use CallGraphExample.java and CFGtest2.java to generate the text of CG and CFG of the whole project, each class in the project is separated by "**************".

Using drawGraph.py directly can generate .dot files for each class and use .dot files to generate .svg images. This project has generated hundreds of .svg images in CFGraph.zip and CallGraph.zip respectively. There are 4 pictures each in CallGraphExample and CFGExample as examples.

In addition, it is recommended to use jupyter notebook to copy the drawCF() and drawCFG() functions in drawGraph.py, which will be a bit faster than running drawGraph.py directly to generate .dot files and .svg images.

By AST graph, We select a few classes to use the Eclipse plugin to get the textual representation of the AST, and then use drawAST.py to draw the graphics. 
