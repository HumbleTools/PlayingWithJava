package com.fun;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* Sujet : trouver le nombre maximum d'évènements consécutifs sans chevauchement
* parmis la liste en entrée. Exemples d'entrées/sorties en bas de classe.
*/
public class kskills {

	private static int maxEvenements = 0;
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(final String... args) throws ParseException {
		if(0==args.length){
			System.out.println("Il manque des Arguments.");
			System.out.println("Exemple : 'java kskills 2013-01-12;5 2013-01-01;13 2013-01-16;20'");
		}else{
			trouverFinEvenementSuivant(0, parserListeEvenements(args));
			System.out.println(maxEvenements);
		}
	}

	/**
	* Supprime les évènements débutant avant la date de recherche, recherche l'évènement se terminant
	* le plus tôt possible après la date de recherche et utilise cette date de fin pour rappeler récursivement
	* cette même méthode. Le nombre d'évènements max est incrémenté à chaque appel.
	*/
	private static long trouverFinEvenementSuivant(final long dateRecherche, final List<long[]> evenements) {
		
		// on supprime ceux qui commencent trop tôt
		for (final Iterator<long[]> iterator = evenements.iterator(); iterator.hasNext();) {
			final long[] evenementSimple = iterator.next();
			if (evenementSimple[0] < dateRecherche) {
				iterator.remove();
			}
		}
		
		if(evenements.isEmpty()){
			return 0;
		}

		maxEvenements++;
		long[] candidat = evenements.get(0);

		// changement de candidat si on trouve un autre se terminant plus tôt
		for (final long[] evenementSimple : evenements) {
			if ((evenementSimple[1] < candidat[1])) {
				candidat = evenementSimple;
			}
		}
		
		// retour de la nouvelle date de recherche
		return trouverFinEvenementSuivant(candidat[1], evenements);
	}

	private static List<long[]> parserListeEvenements(final String... args) throws ParseException {
		final List<long[]> evenements = new ArrayList<long[]>();
		for(final String evenementString : args){
			final String[] splittedEvent = evenementString.split(";");
			//System.out.println(java.util.Arrays.deepToString(splittedEvent));
			final long[] evenementSimple = new long[2];
			evenementSimple[0] = SDF.parse(splittedEvent[0]).getTime();
			evenementSimple[1] = evenementSimple[0] + (Long.parseLong(splittedEvent[1]) * 86400000);
			evenements.add(evenementSimple);
		}
		return evenements;
	}
}

/*
Formalisme : un évènement = '[date au format yyyy-MM-dd];[duree evt en jours]'

2013-01-12;5 2013-01-01;13 2013-01-16;20
Sortie attendue : 2

2014-04-28;4 2014-05-01;7 2014-05-03;7 2014-05-09;5 2014-05-11;11 2014-05-16;3 2014-05-20;1
Sortie attendue : 4

2012-02-20;10 2012-03-01;2 2012-03-12;2 2012-03-14;2 2012-03-15;2 2012-03-20;13
Sortie attendue : 5
*/