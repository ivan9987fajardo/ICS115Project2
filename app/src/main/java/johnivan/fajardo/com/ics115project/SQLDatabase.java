package johnivan.fajardo.com.ics115project;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLDatabase extends SQLiteOpenHelper {

    public SQLDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id integer primary key,firstname text, lastname text, middlename text, number text)");
        db.execSQL("create table myrecipe(id integer primary key,name text, ingredients text, pic blob)");
        db.execSQL("create table recipe(id integer primary key,name text, ingredients text, pic blob, type text)");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Gyudon'," +
                " 'INGREDIENTS\n 1 onion\n" +
                "2 green onions/scallions\n" +
                "¾ lb thinly sliced beef (chuck or rib eye) (¾ lb = 12 oz or 340 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "2 tsp sugar\n" +
                "2 Tbsp sake\n" +
                "2 Tbsp mirin\n" +
                "1 Tbsp soy sauce\n" +
                "3 large eggs (beaten, optional)\n" +
                "3 cups cooked Japanese short grain rice\n" +
                "Pickled red ginger (to garnish)\n\nINSTRUCTIONS\nGather all the ingredients.\n" +
                "Slice the onions, cut the green onion into thin slices (save for garnish), and cut the meat into small pieces.\n" +
                "Heat the oil in a large frying pan over medium high heat and cook the onions until tender.\n" +
                "Add the meat and sugar and cook until no longer pink.\n" +
                "Add sake, mirin, and soy sauce.\n" +
                "Reduce the heat and simmer for 2-3 minutes.\n" +
                "If you like to add the egg, slowly and evenly drizzle the beaten egg over the beef. Cook covered until the egg is done. Add the green onion right before removing from the heat.\n" +
                "Place the beef and egg on top of steamed rice, pour the desired amount of sauce, and top with green onion and pickled red ginger.', 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Beef Tendon Stew', " +
                "'INGREDIENTS\n" +
                "1 lb beef tendon (454 g) (rinsed well)\n" +
                "3 green onions/scallions (use green part and white part separately)\n" +
                "1 knob ginger\n" +
                "3 inch daikon radish\n" +
                "½ gobo (burdock root)\n" +
                "6 oz konnyaku (konjac) (170 g, 2/3 of the block)\n" +
                "½ tsp kosher salt (for konnyaku)\n\n" +
                "Seasonings\n" +
                "2 cups dashi\n" +
                "4 Tbsp soy sauce\n" +
                "3 Tbsp sake\n" +
                "3 Tbsp sugar\n" +
                "2 Tbsp miso" +
                "\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Add the rinsed beef tendon and 4 cups water (Add more to cover the tendon, if necessary) in the Instant Pot.\n" +
                "Press the “Sauté” button and change to your setting to “More” by pressing the “Adjust” button.\n" +
                "Once boiling, press the “Keep Warm/Cancel” button on the Instant Pot to stop cooking. Take out the inner pot and discard the water.\n" +
                "Put the inner pot with the tendons back in the Instant Pot and add 4 cups water.\n" +
                "Peel the ginger skin with the back of the knife or spoon and cut into thin slices. Cut the green onions in half, reserving the white bottom part.\n" +
                "In the Instant Pot, add the sliced ginger and green part of the green onions.\n" +
                "Cover and lock the lid. Press the “Manual” button on the Instant Pot. Set HIGH pressure for 30 minutes by pressing “+ (plus)” or “- (minus)” button to change the cooking time. Make sure the steam release handle points at “Sealing” and not “Venting”. The float valve goes up when pressurized. [For stovetop cooking, bring the water to boil and lower the heat to simmer and cook for 3 hours.]'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hamburger Steak'," +
                " 'INGREDIENTS\n" +
                "½ onion (½ onion = 6.8 oz or 192 g)\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ tsp Kosher salt (for onion)\n" +
                "Freshly ground black pepper\n" +
                "¾ lb ground beef & pork combination (¾ lb = 14 oz or 386 g) (See Notes)\n" +
                "1 large egg\n" +
                "2 Tbsp milk\n" +
                "⅓ cup panko (Japanese breadcrumbs) (⅓ cup = 20 g)\n" +
                "1 tsp Kosher salt (for meat mixture)\n" +
                "Freshly ground black pepper\n" +
                "½ tsp nutmeg\n" +
                "1 Tbsp neutral flavor oil (vegetable, canola, etc)\n" +
                "¼ cup red wine\n\n" +
                "Sauce:\n" +
                "1 Tbsp unsalted butter\n" +
                "3 Tbsp red wine\n" +
                "3 Tbsp water\n" +
                "3 Tbsp ketchup\n" +
                "3 Tbsp tonkatsu sauce (or Worcestershire sauce)\n\n" +
                "INSTRUCTIONS\n" +
                "Gather all the ingredients.\n" +
                "Chop the onion finely. With the knife tip pointing toward the root, slice the onion to within 1/2 inch of the base. Make about 1/4 inch parallel cuts. Then slice the onion horizontally about 1/4 inch parallel cuts. Then cut perpendicular to the first slices you made. If the onions need to be chopped finer, you can run your knife through them in a rocking motion. Be sure to hold down the tip of the knife, otherwise the onions are going to go flying around the room.\n" +
                "Heat oil in a large pan over medium high heat and sauté the onion until translucent. Season with ¼ tsp salt and pepper.\n" +
                "Transfer to a large bowl and let it cool.\n" +
                "Add the meat in the bowl and mix all together.\n" +
                "Add an egg, milk, Panko, 1 tsp salt, black pepper, and nutmeg.\n" +
                "Mix the meat well with your hands until the mixture gets sticky. If you want to keep your hands clean, use rubber gloves or use plastic bags.\n" +
                "Pinch off 2 inch from the mixture and make 4 large patties (or 6 medium patties). Toss each portion from one hand to the other hand repeatedly about 5 times in order to release air inside the mixture (see the video link above). The hamburger steaks will crack while cooking if you don’t release the air inside.\n" +
                "Make oval shape patties. The top shouldn’t be flat, more like round. Keep in the fridge for at least 30 minutes before cooking so that the meat combines together.\n" +
                "In a large pan, heat oil over medium heat and place the patties gently on the pan. Indent the center of each patty with 2 fingers because the center of patties will rise with heat.\n" +
                "Cook the patties about 5 minutes. Do not flip until nicely browned.\n" +
                "After you flip, pour red wine and lower heat to medium low heat. Cover and cook for 5 minutes to thoroughly cook the inside of the patties (adjust cooking time depending on thickness).\n" +
                "Then uncover and increase heat to medium high to let the red wine evaporate. When it’s almost gone, transfer steaks into individual plates. Do not wash the pan.\n" +
                "Combine the liquid sauce ingredients in a bowl.\n" +
                "In the same pan (without cleaning), add butter and sauce ingredients and mix well.\n" +
                "Lower the heat to medium low and let it simmer for a few minutes until alcohol smell is gone. While simmering, you can skim off the scum and fat.\n" +
                "When the sauce thickens, pour the sauce over the hamburger steaks. Serve the hamburger steak with vegetables over your favorite side dish.'" +
                ", 'Japanese')");

        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Pork Adobo', '100g flour', 'Filipino')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Chicken Adobo', '100g flour', 'Filipino')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Fish Adobo', '100g flour', 'Filipino')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Korean Food 1', '100g flour', 'Korean')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Korean Food 2', '100g flour', 'Korean')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Korean Food 3', '100g flour', 'Korean')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Burger', '100g flour', 'American')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Fries', '100g flour', 'American')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hotdog', '100g flour', 'American')");


    }

    public boolean insertdata(String name,String ingredients){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("ingredients",ingredients);
       // contentValues.put("pic",pic);
        long result =db.insert("myrecipe",null,contentValues);

        if (result== -1){
            return false;
        }
        else {

            return true;
        }


    }

    public boolean insertuser(String first,String middle,String last,String num){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname",first);
        contentValues.put("middlename",middle);
        contentValues.put("lastname",last);
        contentValues.put("number",num);
        // contentValues.put("pic",pic);
        long result =db.insert("users",null,contentValues);

        if (result== -1){
            return false;
        }
        else {

            return true;
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
