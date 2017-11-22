package br.puc.bd;

import java.util.HashMap;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.tdb.TDBFactory;

public class Main {

	public static void main(String[] args) {
		
		// Direct way: Make a TDB-back Jena model in the named directory.
        String directory = "/home/flavio-barros/triple-store";
        Dataset dataset = TDBFactory.createDataset(directory);
        Model model = dataset.getDefaultModel();
        
        String queryFile = "query3";
        
        Query query = QueryFactory.read(queryFile) ;
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
          ResultSet results = qexec.execSelect() ;
          ResultSetFormatter.out(System.out, results, query);
        }
        
        // Close the dataset.
        dataset.close();
		
	}
	
	

}
