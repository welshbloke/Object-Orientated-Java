// Test Code for HoverFrogVet

HoverFrog kris = new HoverFrog("kristopher"); // creates a new HoverFrog kris
HoverFrog dan = new HoverFrog("daniel"); // creates a new HoverFrog dan
HoverFrog mike = new HoverFrog("michael"); // creates a new HoverFrog mike
HoverFrog sam = new HoverFrog("samantha"); // creates a new HoverFrog sam
HoverFrogVet clinic = new HoverFrogVet(); // creates a new HoverFrogVet clinic
clinic.addFrog(kris, 2010, 2013);
clinic.addFrog(dan, 2012, 2013);
clinic.addFrog(mike, 2010, 2011);
clinic.printMap(); // displays a list of all the HoverFrogs in clinic along with the years oiled
clinic.printMapValue("daniel"); // displays the map entry for HoverFrog dan
clinic.printMapValue("clive"); // displays a dialogue box announcing the a record for clive cannot be found
clinic.addMapEntry(sam, 2009, 2013); // returns true, indicating same key exists and a new entry has been made
clinic.addMapEntry(dan, 2013, 2014); // warns an existing record already exists. Clicking no returns false to indicate the new record wasn't created
clinic.printMapValue("daniel"); // displays the original years as 2012 and 2013 to show the record wasn't overwritten
clinic.addMapEntry(dan, 2013, 2014); // warns an existing record already exists. Clicking yes returns true to indicate the old record was overwritten
clinic.printMapValue("daniel"); // displays the new record with years 2013 and 2014
clinic.selectValues(2013); // displays [daniel, samantha, kristopher] - the set of keys with 2013 as a value
clinic.addValue(kris, 2008);
clinic.deleteValue(sam, 2009);
clinic.printMap(); // displays a list of all the HoverFrogs, but showing kristopher now contains the additional year 2008, and sam only contains one year, 2013