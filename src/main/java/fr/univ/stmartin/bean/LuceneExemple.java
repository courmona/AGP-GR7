package fr.univ.stmartin.bean;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;

public class LuceneExemple {

	public static void main(String[] args) throws Exception {

		int MAX_RESULTS = 100; // nombre max de réponses retournées

		// 1. Specifier l'analyseur pour le texte.
		// Le même analyseur est utilisé pour l'indexation et la recherche
		Analyzer analyseur = new StandardAnalyzer();

		// 2. Creation de l'index
		// Directory index = new RAMDirectory(); //création index en mémoire
		Path indexpath = FileSystems.getDefault().getPath("F:\\ARIJ\\site_index"); // localisation index
		Directory index = FSDirectory.open(indexpath); // création index sur disque

		IndexWriterConfig config = new IndexWriterConfig(analyseur);
		IndexWriter w = new IndexWriter(index, config);

		// 3. Indexation des documents
		// Ici on indexe seulement un fichier
		File dir = new File("F:\\ARIJ\\site_fichiers");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File f : directoryListing) {
				// File f = new File("/tmp/.txt");
				Document doc = new Document();
				doc.add(new Field("nom", f.getName(), TextField.TYPE_STORED));
				doc.add(new Field("contenu", new FileReader(f), TextField.TYPE_NOT_STORED));
				w.addDocument(doc);
				// indexer les autres documents de la même façon

			}
		}
		w.close();

		//File f = new File("/tmp/.txt");
		//Document doc = new Document();
		//doc.add(new Field("nom", f.getName(), TextField.TYPE_STORED));
		//doc.add(new Field("contenu", new FileReader(f), TextField.TYPE_NOT_STORED));
		//w.addDocument(doc);
		// indexer les autres documents de la même façon

		w.close(); // on ferme le index writer après l'indexation de tous les documents

		// 4. Interroger l'index
		DirectoryReader ireader = DirectoryReader.open(index);
		IndexSearcher searcher = new IndexSearcher(ireader); // l'objet qui fait la recherche dans l'index
		String reqstr = "plage";

		// Parsing de la requete en un objet Query
		// "contenu" est le champ interrogé par defaut si aucun champ n'est precisé
		QueryParser qp = new QueryParser("contenu", analyseur);
		Query req = qp.parse(reqstr);

		TopDocs resultats = searcher.search(req, MAX_RESULTS); // recherche

		// 6. Affichage resultats
		Set<String> listIdFileContientParole = new HashSet<>(0);
		
		//System.out.println(resultats.totalHits + " documents correspondent");
		
		for (int i = 0; i < resultats.scoreDocs.length; i++) {
			int docId = resultats.scoreDocs[i].doc;
			Document d = searcher.doc(docId);
			//System.out.println(d.get("nom") + ": score " + resultats.scoreDocs[i].score);
			listIdFileContientParole.add(d.get("nom").substring(0, d.get("nom").indexOf(".")));
		}

		// fermeture seulement quand il n'y a plus besoin d'acceder aux resultats
		ireader.close();
		
		
		System.out.println(listIdFileContientParole.size() + " documents correspondent");
		System.out.println("liste des id site trouvées sont:");
		for (String siteId : listIdFileContientParole) {
			System.out.println(siteId);
		}
		//SELECT *
		 // FROM voyage
		// WHERE site.id IN (listIdFileContientParole)
	}
}
