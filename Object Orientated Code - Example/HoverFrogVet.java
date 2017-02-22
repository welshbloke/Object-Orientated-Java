import java.util.*;
import ou.*;
import java.io.*;
/**
 * HoverFrogClass used to map when hoverFrogs last had their propeller oiled.
 * 
 * @author Kris Dighton 
 * @version 1.0
 */
public class HoverFrogVet
{
   private Map<String, Set<Integer>> oiledHoverFrog;

   /**
    * Constructor for objects of HoverFrogVet Class
    */
   public HoverFrogVet()
   {
      super();
      this.oiledHoverFrog = new HashMap<>();
   }

   /**
    * Adds the full name of the HoverFrog referenced by aFrog as the key to the map,
    * with an associated set containing the last two years the HoverFrog was oiled.
    */
   public void addFrog(HoverFrog aFrog, Integer year1, Integer year2)
   {
      Set<Integer> years = new HashSet<>();
      years.add(year1);
      years.add(year2);
      this.oiledHoverFrog.put(aFrog.getVetID(), years);
   }

   /**
    * Iterates through the map referenced by the HoverFrogVet, printing
    * a list of the keys (full name of the HoverFrog) and its values (a set
    * containing all the years the HoverFrog was oiled)
    */
   public void printMap()
   {   
      for (String key: oiledHoverFrog.keySet())
      {
         System.out.println("The HoverFrog " + key + " was oiled in " + oiledHoverFrog.get(key));
      }
   }

   /**
    * Checks to see if the argument String is a HoverFrog in the map reference
    * by the HoverFrogVet Object
    * @param theKey the full name of the HoverFrog being searched for
    */
   public void printMapValue(String theKey)
   {
      if (oiledHoverFrog.containsKey(theKey))
      {
         System.out.println("HoverFrog " + theKey + " was oiled " + oiledHoverFrog.get(theKey));
      }
      else
      {
         OUDialog.alert("Cannot find records for " + theKey);
      }

   }

   /**
    * Checks to see if HoverFrog aFrog aleady exists as a key to the map.
    * If so, an option is given to override the existing entry or do nothing.
    * If no entry is found, HoverFrog aFrog is added to the map.
    * @param aFrog the HoverFrog to be added to the list
    * @param year1 a year the HoverFrog was oiled
    * @param year2 a year the HoverFrog was oiled
    * @return true or false to indicate if the HoverFrog was added to the map
    */
   public boolean addMapEntry(HoverFrog aFrog, Integer year1, Integer year2)
   {
      boolean result = oiledHoverFrog.containsKey(aFrog.getVetID());
      if (result == true)
      {
         if (OUDialog.confirm("A record for " + aFrog.getVetID() + " already exists. Overwrite existing record?"))
         {
            addFrog(aFrog, year1, year2);
         }
         else
         {
            return false;
         }
      }
      else
      {
         addFrog(aFrog, year1, year2);
      }
      return true;
   }

   /**
    * Prints out all the HoverFrogs that were oiled in the year given by
    * the argument oiledYears
    * @param oiledYears to check which HoverFrogs were oiled in this year
    * @return a set of all the HoverFrogs oiled in the requested year
    */
   public Set<String> selectValues(Integer oiledYears)
   {
      Set<String> years = new HashSet<>();
      Set<String> selectedYears = this.oiledHoverFrog.keySet();
      for (String eachYear: selectedYears)
      {
         Set<Integer> oiledFrogs = this.oiledHoverFrog.get(eachYear);
         if (oiledFrogs.contains(oiledYears))
         {
            years.add(eachYear);
         }
      }
      return years;
   }

   /**
    * Assuming it already exists in the map, adds a new year, yearToAdd, to the entry with
    * key referenced by HoverFrog frogToChange.
    * @param frogToChange the name of the HoverFrog to have another year oiled added
    * @param yearToAdd the new year to add to the set of years referenced by the map
    */
   public void addValue(HoverFrog frogToChange, Integer yearToAdd)
   {
      Set<Integer> newYear = this.oiledHoverFrog.get(frogToChange.getVetID());
      newYear.add(yearToAdd);
      this.oiledHoverFrog.put(frogToChange.getVetID(), newYear);
   }

   /**
    * Assuming it already exists in the map, removes a new year, yearToDelet, from the entry with
    * key referenced by HoverFrog frogToChange.
    * @param frogToChange the name of the HoverFrog to have a year oiled removed
    * @param yearToDeltet the year to delete from the set of years referenced by the map
    */
   public void deleteValue(HoverFrog frogToChange, Integer yearToDelete)
   {
      Set<Integer> yearToRemove = this.oiledHoverFrog.get(frogToChange.getVetID());
      yearToRemove.remove(yearToDelete);
      this.oiledHoverFrog.put(frogToChange.getVetID(), yearToRemove);
   }  

}