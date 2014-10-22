package daniel.java.util;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.omg.CosNaming.NameHelper;

public class NameSimilarityHelper {
	
	/*public static int maxNameSimilarity(String single, String multiple)
	{
	  if ((!(StringUtils.hasLength(single))) || (!(StringUtils.hasLength(multiple)))) {
	    return 0;
	  }
	  Set singleSet = NameHelper.nameParseSet(single);
	  Set multipleSet = NameHelper.nameParseSet(multiple);
	  int[] levenshteins = new int[multipleSet.size() * singleSet.size()];
	  int i = 0;
	  for (Iterator i$ = multipleSet.iterator(); i$.hasNext(); ) { multipleStr = (String)i$.next();
	    for (String singleStr : singleSet) {
	      levenshteins[i] = LevenshteinHelper.levenshteinSimilarity(PinYinHelper.getStringPinyin(NameHelper.nameParse(singleStr)), PinYinHelper.getStringPinyin(NameHelper.nameParse(multipleStr)));

	      ++i;
	    }
	  }
	  String multipleStr;
	  return SortHelper.quickSort(levenshteins, "desc")[0];
	}*/
	
	
}
