import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.runtime.debug.*;

/*
Sample file that shows how to connect to AntlrWorks

Remember to change the following to suit your own project
 - XMLGrammarLexer
 - XMLGrammarParser
 - XMLTree

*/

public class TreeTest {

  public static void main(String args[]) throws Exception {
    	CharStream input = new ANTLRFileStream(args[0]);
    	XMLGrammarLexer lex = new XMLGrammarLexer(input);
			
			// MODIFY: change document to the root rule 
			ParseTreeBuilder builder = new ParseTreeBuilder("document"); 

      // create a debug socket proxy to ANTLRWorks
      // MODIFY: change the name of the grammar file
      DebugEventSocketProxy AW = new DebugEventSocketProxy("/Users/vazexqi/Antlr/handGeneratedXMLGrammar/XMLTree.g");
      AW.handshake();

			DebugEventHub hub = new DebugEventHub(builder, AW);

      CommonTokenStream tokens = new CommonTokenStream(lex);
      XMLGrammarParser parser = new XMLGrammarParser(tokens);
			XMLGrammarParser.document_return root = parser.document();
			
			CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree)root.tree);
      XMLTree walker = new XMLTree(nodes, hub);
      try {
					// MODIFY: change to the rule that you want to follow
          walker.document();
      } catch (RecognitionException e) {
          e.printStackTrace();
      }
      
  }
}