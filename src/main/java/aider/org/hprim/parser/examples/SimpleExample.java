package aider.org.hprim.parser.examples;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.antlr.runtime.*;

import aider.org.hprim.parser.HPRIMSInputStreamReader;
import aider.org.hprim.parser.HPRIMSTokenSource;
import aider.org.hprim.parser.antlr.HPRIMSParser;
import aider.org.hprim.parser.xml.XmlContentHandler;


/**
 * Classe d'exemple
 * @author delabre
 * @version $Id: SimpleExample.java 1024 2012-08-06 19:47:04Z jp $
 */
public class SimpleExample {

	/**
	 * Logger de la classe
	 */
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(SimpleExample.class.getCanonicalName());
	
	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws RecognitionException 
	 * @throws HPRIMSMismatchException 
	 */
	public static void main(String[] args) throws IOException, RecognitionException {

		// Création du collecteur par défaut (affiche sur la console les données)
		XmlContentHandler contentHandler = new XmlContentHandler(new PrintWriter(System.out));
		
		// Définition des flux matériels (à fermer en fin d'utilisation)
		InputStream is = null;
		HPRIMSInputStreamReader inputreader = null;
		
		try {
			// Création de l'inputstream en entrée
			is = new FileInputStream(args[0]);
	
			// Création de la source des tokens
			inputreader = new HPRIMSInputStreamReader(is, "ISO8859_1");
			HPRIMSTokenSource toksce = new HPRIMSTokenSource(inputreader);
	
			// Création du flux de tokens
			TokenStream tokenstream = new CommonTokenStream (toksce);
	
			// Création du parser de tokens provenant de input et réalisant dans
			// la classe collecteur l'export des données
			HPRIMSParser parser = new HPRIMSParser(tokenstream, contentHandler);
	
			// Pour l'instant, seul le parser hprim 2.1 est fonctionnel
			parser.hprim();
		} finally {
			// Fermeture propre des ressources allouées
			if (inputreader != null)
				inputreader.close();
			if (is != null)
				is.close();
		}
		
		System.out.println("done");
	}
}