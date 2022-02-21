package dk.brics.soot.callgraphs;

import soot.*;
import soot.jimple.*;
import soot.jimple.toolkits.callgraph.CHATransformer;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Sources;
import soot.jimple.toolkits.callgraph.Targets;
import soot.options.Options;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CallGraphExample
{
	private static SootMethod target;

	public static void main(String[] args) {
		// Soot classpath
//		String path = System.getProperty("user.dir")+"/src";
		String classPath = "/Users/fanxingzhong/commons-codec-master/target/classes/";
//		String path = "/Users/fanxingzhong/XingzhongFanCode/src";
		// Setting the classpath programatically
		Options.v().set_prepend_classpath(true);
		Options.v().set_soot_classpath(classPath);

		// The second argument is the path to the main class of a project you want to analyze
		// (in this case, testers/ExampleCode.java)
		args = new String[]{"-w","-process-dir",classPath};

//		PackManager.v().getPack("wjtp").add(new Transform("wjtp.myTrans", new SceneTransformer() {
//
//			@Override
//			protected void internalTransform(String phaseName, Map options) {
//				CHATransformer.v().transform();
//
//				// This line generates the call graph of the project you're going to analyze
//				CallGraph cg = Scene.v().getCallGraph();
//				// Now that you have the call graph, you can start doing whatever type of
//				// analysis needed for your problem. Below, we are going to traverse the
//				// generated call graph and print caller/callee relationships (BFS)
//
//				System.out.println("**********************************");
//				SootMethod src = Scene.v().getMainClass().getMethodByName("main");
//				List<SootMethod> nodes = new ArrayList<>();
//				nodes.add(src);
//				while(!nodes.isEmpty()){
//					SootMethod parent = nodes.get(0);
//					Iterator<MethodOrMethodContext> targets = new Targets(cg.edgesOutOf(parent));
//					while (targets.hasNext()) {
//						SootMethod child = (SootMethod)targets.next();
//						if(!child.getSignature().contains("init"))
//							nodes.add(child);
//						System.out.println(parent.getDeclaringClass()+"."+parent.getName()+
//								" calls " + child.getDeclaringClass()+"."+child.getName());
//					}
//					nodes.remove(0);
//				}
//				System.out.println("**********************************");
//			}
//
//		}));
		Main.main(args);
		Scene.v().loadNecessaryClasses();
		CallGraph cg = Scene.v().getCallGraph();
		System.out.println("**********************************");
		for(SootClass sc: Scene.v().getApplicationClasses()){
			for(SootMethod sm: Scene.v().getEntryPoints()){
				Iterator<MethodOrMethodContext> targets = new Targets(cg.edgesOutOf(sm));
				List<SootMethod> nodes = new ArrayList<>();
				nodes.add(sm);
				while(targets.hasNext()){
					SootMethod child = (SootMethod)targets.next();
					if (!child.getSignature().contains("init"))
						nodes.add(child);
					System.out.println("\""+sm.getDeclaringClass()+"."+sm.getName()+"\""+"  ->  " + "\""+child.getDeclaringClass()+"."
							+child.getName()+"\"");
				}
				System.out.println(sm.getDeclaringClass()+"."+sm.getName());
				System.out.println("**********************************");

			}
		}
	}
}

