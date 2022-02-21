package dk.brics.soot.callgraphs;

import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CHATransformer;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Targets;
import soot.jimple.toolkits.ide.icfg.JimpleBasedInterproceduralCFG;
import soot.options.Options;
import soot.toolkits.graph.DirectedGraph;
import soot.util.dot.DotGraph;
import soot.util.queue.QueueReader;

import java.util.*;

public class CFGtest2
{
    public static void main(String[] args) {
        // Soot classpath
        String classPath = "/Users/fanxingzhong/commons-codec-master/target/classes/";
        // Setting the classpath programatically
        Options.v().set_prepend_classpath(true);
        Options.v().set_soot_classpath(classPath);

        // The second argument is the path to the main class of a project you want to analyze
        // (in this case, testers/ExampleCode.java)
        args = new String[] {"-w", "-process-dir", classPath};

        Main.main(args);
        Scene.v().loadNecessaryClasses();
        Scene.v();
        System.out.println("**********************************");
        for(SootClass sc: Scene.v().getApplicationClasses()) {
            for(SootMethod sm: Scene.v().getEntryPoints()){
                Body b = sm.retrieveActiveBody();
                UnitGraph cfg = new ExceptionalUnitGraph(b);
                Iterator i = cfg.iterator();
                Unit parent = (Unit)i.next();
                while (i.hasNext()){
                    Unit child = (Unit)i.next();
                    System.out.println("\""+parent.toString()+"\""+ " -> " +"\""+child.toString()+"\"");
                    parent = child;
                }
                System.out.println("**********************************");
            }
        }
    }

}
