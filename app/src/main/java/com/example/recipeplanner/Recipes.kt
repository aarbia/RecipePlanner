package com.example.recipeplanner

import androidx.annotation.DrawableRes

// Object for single recipe with basic information
data class Recipes(
    val id: Int = 0,
    val name: String,
    val prepTimeMin: Int,
    val cookTimeMin: Int,
    val ingredients: List<String>,
    val directions: List<String>,
    val servings: Int,
    val meal: String,
    @DrawableRes val image: Int? = null
)

// sample recipe list
val seedRecipes = mutableListOf(
    Recipes(
        name = "Chicken Pillows",
        prepTimeMin = 20,
        cookTimeMin = 30,
        ingredients = listOf(
            "1lb Chicken Breast, diced",
            "1 Tbsp Cooking Oil",
            "2 Tbsp Minced Garlic",
            "2 Tbsp Italian Seasoning",
            "8oz Onion and Chive Cream Cheese",
            "2 cans Crescent Rolls",
            "12oz Chicken Gravy, canned or homemade",
            "1/2 cup Italian Breadcrumbs"
        ),
        directions = listOf(
            "Pre-heat oven to 375F. In large skillet on medium-high heat add cooking oil and garlic till fragrant",
            "Add chicken to skillet, cook through, add seasonings and salt & pepper to taste",
            "Add cream cheese to chicken, mix thoroughly.",
            "Fill crescent rolls with chicken mix, then roll in breadcrumbs before placing on baking sheet.",
            "Cook pillows according to crescent roll packaging, while cooking add gravy to skillet with leftover chicken & cream cheese mixture. Serve warm over mashed potatoes or rice."
        ),
        servings = 6,
        meal = "Dinner",
        image = R.drawable.chickenpillows
    ),

    Recipes(
        name = "Creamy Cavatappi",
        prepTimeMin = 10,
        cookTimeMin = 20,
        ingredients = listOf(
            "8 ounces (1/2 pound) cavatappi pasta",
            "1 tablespoon unsalted butter",
            "2 cloves garlic, minced",
            "3/4 cup heavy cream",
            "1/2 teaspoon kosher salt, plus more for the pasta water",
            "1/2 teaspoon finely ground black pepper",
            "1/2 cup (1.3 ounces) finely grated Parmesan cheese, plus more for garnish",
            "1 tablespoon fresh lemon juice",
            "1 cup frozen peas, optional",
            "1/4 cup to 1/2 cup reserved pasta cooking water"
        ),
        directions = listOf(
            "Put a large pot of water on to boil over high heat. Season generously with salt, add the pasta and stir. Cook until just short of al dente, according to the package directions.",
            "While the pasta cooks, add the butter to a large skillet over medium heat, add garlic and cook just until fragrant.",
            "Slowly add the cream while stirring and season with salt and pepper. Bring to a simmer, reducing the heat if needed to maintain a simmer. Cook, while stirring, until slightly thickened, about 3 minutes.",
            "Add the Parmesan a small handful at a time, sprinkling it over top and stirring each time until melted. Add the lemon juice and stir. Turn the heat as low as it’ll go until the pasta is ready, stirring occasionally.",
            "Add the pasta and peas to the sauce. Add 1/4 cup of the reserved pasta water and turn the heat to medium. Toss constantly until you have a creamy sauce that coats the noodles, 3 to 5 minutes. If the sauce seems too thick, add more pasta water a small splash at a time, tossing in between.",
            "Taste, adding salt and/or pepper if needed. Top with a sprinkle of Parmesan cheese and serve immediately."
        ),
        servings = 3,
        meal = "Dinner",
        image = R.drawable.creamycavatappi
    ),

    Recipes(
        name = "Sausage And Gnocchi Skillet",
        prepTimeMin = 10,
        cookTimeMin = 20,
        ingredients = listOf(
            "2 Tbsp Cooking Oil",
            "1 (12-ounce) package chicken sausage links, sliced",
            "1 (16-ounce) package shelf-stable gnocchi",
            "1 (15-ounce) jar sun-dried tomato sauce",
            "½ cup water",
            "5 ounces baby spinach leaves",
            "¼ cup chopped fresh basil leaves, plus more for garnish",
            "½ cup shaved or shredded Parmesan cheese"
        ),
        directions = listOf(
            "Add oil to a large skillet over medium-high heat.",
            "Add the sliced chicken sausage and cook until a little browned, 3-4 minutes, stirring occasionally.",
            "Add the gnocchi and sun-dried tomato sauce to the skillet. Add the water to the sauce jar and give it a shake before adding the water to the skillet. Stir to combine.",
            "Bring the mixture just to a simmer, then reduce the heat to medium. Cook until the gnocchi are soft, 3-5 minutes.",
            "Add the spinach and basil to the skillet and stir to combine. Reduce heat to low then cover the skillet and cook until the spinach is wilted, 2-3 minutes.",
            "Sprinkle with Parmesan cheese and additional basil before serving."
        ),
        servings = 4,
        meal = "Dinner",
        image = R.drawable.sausagegnocchiskillet
    ),

    Recipes(
        name = "Easy Stove Top Pork Chops",
        prepTimeMin = 10,
        cookTimeMin = 40,
        ingredients = listOf(
            "3 Thick Cut Pork Chops",
            "1 tsp Garlic Powder",
            "1 tsp Onion Powder",
            "2 tsp Brown Sugar",
            "2 tsp Dried Thyme",
            "1.5 tsp Dried Oregano",
            "2 tsp Salt",
            "1 tsp Pepper",
            "1 (12 oz.) Jar Pork Gravy"
        ),
        directions = listOf(
            "Combine seasonings in a small bowl and fully coat the pork chops with the mix.",
            "Heat oil in a skillet on medium-high and sear the pork chops until brown on all sides, about 5 mins.",
            "Cover the pork chops with gravy and turn heat to low, scraping up the brown bits from the bottom of the skillet.",
            "Let simmer for about 30 mins, until done, 145F inside temperature. Serve warm over mashed potatoes or rice."
        ),
        servings = 4,
        meal = "Dinner",
        image = R.drawable.stovetopporkchop
    ),

    Recipes(
        name = "Fudgey Browines",
        prepTimeMin = 10,
        cookTimeMin = 25,
        ingredients = listOf(
            "1/2 cup unsalted butter (melted and HOT)",
            "1 & 1/8 cup granulated sugar",
            "1 Tbsp vegetable or avocado oil",
            "2 large eggs",
            "1 Tbsp vanilla extract",
            "1 tsp salt",
            "1/2 cup flour",
            "1/2 cup cocoa powder",
            "1/2 cup chocolate chips or chopped nuts"
        ),
        directions = listOf(
            "Pre-heat oven to 350F. Coat 8\"x8\" or 9\"x9\" dish in cooking spray.",
            "Combine hot butter, sugar and oil, whisk well until combined.",
            "Beat eggs separately and add to mix, add vanilla, beat for about a minute",
            "Sift in flour and cocoa powder (add chocolate chips or nuts if using) do NOT overmix!",
            "Bake for 23-26 minutes."
        ),
        servings = 9,
        meal = "Dessert",
        image = R.drawable.fugeybrownies
    ),

    Recipes(
        name = "Cinnamon Roll French Toast Bake",
        prepTimeMin = 15,
        cookTimeMin = 45,
        ingredients = listOf(
            "1/4 cup melted butter",
            "2 cans cinnamon rolls",
            "4 eggs",
            "1/2 cup half & half (or regular milk)",
            "2 tsp cinnamon",
            "2 tsp vanilla extract",
            "1 cup maple syrup"
        ),
        directions = listOf(
            "Pre-heat oven to 375F. Pour melted butter into 13\"x9\" baking dish.",
            "Set icing aside for later, cut rolls into 8 even pieces and add to dish.",
            "Beat eggs, then beat in cream, cinnamon and vanilla until well mixed. Pour over cinnamon rolls, and drizzle with syrup.",
            "Bake for 20-30 minutes (until golden).",
            "Once cooled, drizzle with icing."
        ),
        servings = 12,
        meal = "Breakfast",
        image = R.drawable.cinnrollfrenchtoast
    ),

    Recipes(
        name = "Chocolate Chip Cookies",
        prepTimeMin = 15,
        cookTimeMin = 20,
        ingredients = listOf(
            "1 cup softened butter (not melted)",
            "1 cup granulate sugar",
            "1 cup light brown sugar",
            "2 tsp vanilla extract",
            "2 eggs",
            "2 cups flour",
            "1 tsp baking soda",
            "1/2 tsp baking powder",
            "1 tsp salt",
            "2 tsp cinnamon",
            "2 cup chocolate chips"
        ),
        directions = listOf(
            "Pre-heat over to 350F, line baking sheet with parchment paper.",
            "Cream together butter and sugar.",
            "Beat in eggs and vanilla until fluffy.",
            "In separate bowl, mix flour, baking soda, baking powder, salt and cinnamon; then mix into wet ingredients.",
            "Add chocolate chips to mix.",
            "Roll 2-3 Tbsp of dough at a time to form cookies. Bakes for 12 minutes, until just barely browning.",
            "Let sit on sheet for 2 minutes then move to cooling rack."
        ),
        servings = 30,
        meal = "Dessert",
        image = R.drawable.chocchipcookies
    ),

    Recipes(
        name = "Overnight Oats",
        prepTimeMin = 10,
        cookTimeMin = 10,
        ingredients = listOf(
            "1/2 cup whole rolled oats",
            "1 tablespoon chia seeds",
            "1/2 teaspoon maple syrup",
            "Pinch sea salt",
            "1/4 cup greek yogurt",
            "2/3 cups unsweet almond milk"
        ),
        directions = listOf(
            "Place the oats, chia seeds, maple syrup, salt,yogurt in a lidded jar",
            "Pour in the almond milk, and stir thoroughly to combine.",
            "Cover and store overnight in the fridge"
        ),
        servings = 1,
        meal = "Breakfast",
        image = R.drawable.oats
    ),

    Recipes(
        name = "Avocado Toast",
        prepTimeMin = 5,
        cookTimeMin = 5,
        ingredients = listOf(
            "2 slices of toasted bread",
            "1 large avocado",
            "1 teaspoon fresh lemon juice",
            "2 teaspoon extra virgin olive oil",
            "Pinch of sea salt",
            "Pinch of black pepper"
        ),
        directions = listOf(
            "In a small bowl gently mash peeled and pitted avocado with lemon juice.",
            "Divide and spread the mashed avocado across the two slices of bread.",
            "Drizzle each slice of avocado toast with extra virgin olive oil and sprinkle with sea salt and pepper."
        ),
        servings = 2,
        meal = "Breakfast",
        image = R.drawable.avocado
    ),

    Recipes(
        name = "Quiche",
        prepTimeMin = 15,
        cookTimeMin = 35,
        ingredients = listOf(
            "1 single pie crust unbaked",
            "6 large eggs",
            "3/4 cups of milk",
            "3/4 teaspoon salt",
            "1/4 teaspoon black pepper",
            "1 1/2 cups shredded cheddar cheese",
            "1 cup cubed cooked ham",
            "2 tablespoons sliced green onions"
        ),
        directions = listOf(
            "Preheat oven to 375 F. Unroll pie crust and press into 9 inch pie plate.",
            "In a large bowl, whisk eggs, milk, salt, and pepper",
            "sprinkle ham, 1 cup of cheese and green onion into pie crust and pour egg mixture on top",
            "Sprinkle remaining 1/2 cup of cheese on top of egg mixture.",
            "Bake for 35-40 minutes. Let cool for 5-10 minutes."
        ),
        servings = 6,
        meal = "Breakfast",
        image = R.drawable.quiche
    ),

    Recipes(
        name = "Sausage Breakfast Hash",
        prepTimeMin = 15,
        cookTimeMin = 50,
        ingredients = listOf(
            "1.6 lb potatoes",
            "1 1/2 tbsp olive oil",
            "1/2 tsp paprika",
            "1/2 tsp thyme",
            "1/4 tsp onion powder",
            "1/2 tsp garlic powder",
            "1/2 tsp salt",
            "1 bell pepper",
            "1 red onion",
            "1 tbsp olive oil",
            "4 oz bacon",
            "1 lb sausage",
            "5 large eggs"
        ),
        directions = listOf(
            "Preheat Oven to 400 F. Toss potatoes with oil and seasonings in a bowl.",
            "Spread mixture on large tray. Bake for 15 minutes.",
            "Squeeze dollops on sausage on top of potatoes, scatter bacon as well",
            "Bake for 20 minutes. Toss, then bake for another 15 minutes.",
            "Crack eggs on top and return into oven for 7 minutes"
        ),
        servings = 4,
        meal = "Breakfast",
        image = R.drawable.hash
    ),

    Recipes(
        name = "Fluffy Pancakes",
        prepTimeMin = 5,
        cookTimeMin = 10,
        ingredients = listOf(
            "1 1/2 cups all purpose flour",
            "2 1/2 teaspoons baking powder",
            "1/2 teaspoon salt",
            "1 tablespoon sugar",
            "1 1/4 sups milk",
            "1 egg",
            "3 tablespoons butter, melted",
            "2 teaspoons vanilla extract (optional)"
        ),
        directions = listOf(
            "In a large bowl, sift together the flour, baking powder, salt and sugar.",
            "Make a well in the middle and pour in the milk, egg, butter and vanilla extract.",
            "Combine until mostly smooth.",
            "Heat a large pan over medium-high heat. Once hot, grease, spray or melt butter on the pan.",
            "Pour 1/4 cup of pancake batter onto pan.",
            "Cook pancakes for about 2 minutes, until edges begin to look defined and bubbles form.",
            "Flip the pancakes over and cook for another minute on the other side",
            "Remove pancakes from pan onto a plate and keep warm while cooking the rest of the batter."
        ),
        servings = 4,
        meal = "Breakfast",
        image = R.drawable.pancake
    ),

    Recipes(
        name = "Egg Bites",
        prepTimeMin = 10,
        cookTimeMin = 40,
        ingredients = listOf(
            "2 tablespoons olive oil",
            "1/2 red onion, diced",
            "1/2 chopped red pepper",
            "1 cup chopped broccoli florets",
            "1 small zucchini, diced",
            "2 cloves of garlic, minced",
            "1 1/2 packed cups baby spinach",
            "10 large eggs",
            "3/4 cup cottage cheese",
            "1 teaspoon salt",
            "1/2 teaspoon black pepper",
            "1 teaspoon dried oregano",
            "2/3 cup grated cheddar cheese",
            "8 ounces bacon, cooked and crumbled (optional)"
        ),
        directions = listOf(
            "Pre-heat over to 350F, and grease a muffin pan with butter or cooking spray ",
            "Heat the olive oil over medium-high heat in a large skillet.",
            "Add the onion and bell pepper and saute for 2 minutes. Then add broccoli and zucchini.",
            "Saute until vegetables has softened. Add garlic and spinach and saute for a minute",
            "Turn off heat and set pan aside.",
            "Add the ggs, cottage cheese, salt, pepper and oregano into a blender and blend until well combined.",
            "Add sauteed veggies, egg mixture, cheese and bacon into large mixing bowl and stir",
            "Ladle egg mixture into muffin pan filling each to the top",
            "Bake for 22-25 minutes",
            "Remove pan from oven and let egg bites cool for 5 minutes before removing."
        ),
        servings = 12,
        meal = "Breakfast",
        image = R.drawable.eggbites
    ),

    Recipes(
        name = "Garlic Butter Steak Bites",
        prepTimeMin = 5,
        cookTimeMin = 10,
        ingredients = listOf(
            "1 tbsp olive oil",
            "1 1/2 lb sirloin steak",
            "1/2 tsp salt",
            "1/2 tsp pepper",
            "2 tbsp butter",
            "4 minced garlic cloves",
            "1 tablespoon parsley"
        ),
        directions = listOf(
            "Add olive oil into large skillet and heat over high heat.",
            "Add steak pieces and season them generously with salt and paper.",
            "Transfer steak bites into a plate and in the same skillet as butter and garlic.",
            "Cook util garlic starts to brown. Pour garlic butter over steak bites and toss well.",
            "Garnish with parsley and serve"
        ),
        servings = 4,
        meal = "Dinner",
        image = R.drawable.steak
    ),

    Recipes(
        name = "Chicken Quesadilla",
        prepTimeMin = 10,
        cookTimeMin = 20,
        ingredients = listOf(
            "1 tbsp oil",
            "1 lb chicken breast cut into small pieces.",
            "1 tbsp taco seasoning",
            "1/2 large bell pepper diced",
            "1/2 yellow onion diced",
            "2 tbsp unsalted butter",
            "6 flour tortillas",
            "2 cups mexican cheese"
        ),
        directions = listOf(
            "Preheat a skillet with oil on medium high. Add in chicken and taco seasoning. Cook for 4 minutes",
            "Add in bell pepper and onion, cook for another 5 minutes or until chicken and veggies are cooked",
            "On a clean skillet, add butter and place tortilla on top.",
            "Add mexican cheese and chicken mixture on half of tortilla.",
            "Top with more cheese, fold over tortilla to close",
            "Cook one side until tortilla is golden brown."
        ),
        servings = 6,
        meal = "Dinner",
        image = R.drawable.quesadilla
    ),

    Recipes(
        name = "Italian Meatballs",
        prepTimeMin = 30,
        cookTimeMin = 120,
        ingredients = listOf(
            "1/4 cup olive oil",
            "1/2 cup mined yellow onions",
            "2 tsp minced garlic",
            "6 ounces tomato paste",
            "7 cup crushed canned tomatoes",
            "2 tsp kosher salt",
            "2 lb ground beef",
            "2 large eggs",
            "1 cup plain breadcrumbs",
            "1/2 cup grated parmesan cheese",
            "1/2 cup finely minced yellow onion",
            "1 tsp minced garlic",
            "1/4  cup sliced basil"
        ),
        directions = listOf(
            "In a large pot, heat oil over medium heat. Add onion, garlic and saute for 4 minutes",
            "Stir in tomato paste and cook for 1 minutes. Stir in crushed tomatoes, salt, and pepper.",
            "Simmer covered for 30 minutes. Add seasoning to taste.",
            "Heat over to broil. Line a large baking sheet with foil and lightly grease with olive oil.",
            "In a lagre bowl mix ground beef, eggs, breadcrumbs, Parmesan cheese, onion, and garlic.",
            "Measure out 1/3 cup of beef mixture and evening space on baking sheet.",
            "Cook until surface is browned for 10 minutes, flip meatballs and cook for additional 3 minutes.",
            "Transfer meatballs into tomato sauce. Simmer on low for 20 minutes."
        ),
        servings = 14,
        meal = "Dinner",
        image = R.drawable.meatball
    ),

    Recipes(
        name = "Cake Pops",
        prepTimeMin = 60,
        cookTimeMin = 120,
        ingredients = listOf(
            "1 box vanilla cake mix",
            "1/4 cup vegetable oil",
            "1/2 cup unsalted butter",
            "1 cup powdered sugar",
            "1 tsp vanilla extract",
            "1 tsp milk",
            "3 1/2 cups candy melts.",
            "40 cake pop sticks",
            "1 pack sprinkles"
        ),
        directions = listOf(
            "Make boxed cake mix as directed on box. Before mixing all ingredients, add in the vegetable oil.",
            "Allow cake to cool for 15 minutes. Break the cake apart with hands and crumble up completely.",
            "In a medium sized bowl add butter, icing sugar, vanilla and milk",
            "Mix for 4 minutes until light and fluffy",
            "Add 3/4 of frosting into the crumbled cake and mix until combined",
            "Roll tbsps full of cake mixture into round balls and place on lined tray",
            "Place tray in freezer for 40 minutes",
            "Melt candy melts. Dip cake pop stick into melted chocolate and then into cake ball.",
            "Grab cake ball by stick and place into melted chocolate. Decorate with sprinkles."
        ),
        servings = 40,
        meal = "Dessert",
        image = R.drawable.cakepop
    ),

    Recipes(
        name = "Vanilla Cake",
        prepTimeMin = 20,
        cookTimeMin = 30,
        ingredients = listOf(
            "2 cups all purpose flour",
            "2 1/2 teaspoons baking powder",
            "1/4 tsp Kosher salt",
            "4 large eggs",
            "1 1/2 cups granulated sugar",
            "1 cup milk",
            "6 tsp vanilla extract",
            "2 tsp vegetable oil",
            "2 1/2 sticks unsalted butter",
            "1 lb powdered sugar",
            "2-4 tbsp full fat milk"
        ),
        directions = listOf(
            "Preheat oven to 350 F. Grease 2, 8 inch cake pans with butter.",
            "Whisk flour, baking powder and salt in a large bowl and set aside.",
            "Beat eggs for 30 seconds while pouring over sugar, then beat for 7 minutes until white",
            "Place butter and milk in microwave for 2 minutes, and gently add the flour until mixed in",
            "Pour hot milk, vanilla and oil into now empty flour bowl",
            "Add egg batter into milk batter and whisk until smooth.",
            "Pour batter into pans and bale for 30 minutes until golden",
            "Remove from oven and then cool for 20 minutes while making vanilla buttercream.",
            "Beat butter in stand mixer until fluffy, ass powdered sugar until fluffy",
            "Add vanilla and milk and beat for 30 seconds.",
            "Frost your bottom cake. Put other cake on top and finish frosting entire cake.",
            "Optionally top with sprinkles"
        ),
        servings = 12,
        meal = "Dessert",
        image = R.drawable.cake
    ),

    Recipes(
        name = "Homemade Vanilla Ice Cream",
        prepTimeMin = 30,
        cookTimeMin = 120,
        ingredients = listOf(
            "1 1/2 cups heavy cream",
            "1 1/2 cups whole milk",
            "2/3 cups cane sugar",
            "2 teaspoons vanilla extract",
            "1/8 teaspoon sea salt"
        ),
        directions = listOf(
            "In a medium saucepan, combine the cream, milk, sugar, vanilla and salt.",
            "Warm over medium-low heat, whisking often, for 5 minutes, or until sugar dissolves and mixture is warmed throughout",
            "Pour into a bowl, cover, and chill for 2 hours or overnight",
            "Remove chilled ice cream base form fridge and whisk well",
            "Mix for 20-30 minutes which will make the ice cream soft.",
            "Transfer into an airtight container and freeze for 2 hours."
        ),
        servings = 4,
        meal = "Dessert",
        image = R.drawable.icecream
    ),

    Recipes(
        name = "Homemade Churros",
        prepTimeMin = 20,
        cookTimeMin = 10,
        ingredients = listOf(
            "2/3 cup all purpose flour",
            "1/4 stick unsalted butter",
            "1 cup water",
            "pinch of salt",
            "2 tsp sugar",
            "1 egg",
            "oil (for frying)"
        ),
        directions = listOf(
            "Place water, butter, sugar and pinch of salt into saucepan, bring to a boil",
            "Add flour and mix until dough forms",
            "Remove from stove and let cool. Add egg and work into dough",
            "Pour oil into a large frying pan. Fill a piping bag with the dough.",
            "Pipe the dough directly into the hot oil. They will only need about 2 minutes or until golden.",
            "Place on paper towel to rid excess oil.",
            "Roll into sugar and ground cinnamon"
        ),
        servings = 60,
        meal = "Dessert",
        image = R.drawable.churro
    ),

    Recipes(
        name = "Lemon Bars",
        prepTimeMin = 22,
        cookTimeMin = 55,
        ingredients = listOf(
            "3 cups all purpose flour",
            "2/3 cups powdered sugar",
            "1/2 tsp salt",
            " 1/2 tbsp unsalted butter",
            "3 tbsp lemon zest",
            "8 large eggs",
            "1 cup lemon juice"
        ),
        directions = listOf(
            "Heat oven to 350F. Whisk together flour, powdered sugar and salt.",
            "Pour in melted butter and mix until combined",
            "Sprinted the dough into lined pan and press down into a flat layer. Bake for 20 minutes",
            "Add sugar and zest for 3 lemons into food processor until light yellow color.",
            "Add sugar and remaining flour into large bowl and mix well.",
            "Pour in lemon juice and add eggs. Mix until completely combined.",
            "Pour filling onto warm crust then transfer to over and bake for 25 minutes.",
            "All to chill in fridge for two hours.",
            "Dust with powdered sugar and cut into bars."
        ),
        servings = 4,
        meal = "Dessert",
        image = R.drawable.lemon
    ),

    Recipes(
        name = "Caesar Salad",
        prepTimeMin = 10,
        cookTimeMin = 20,
        ingredients = listOf(
            "3 cups torn sourdough bread (1/2 inch pieces)",
            "2 Tbsp. extra-virgin olive oil",
            "1 1/2 tsp. kosher salt",
            "1/2 tsp. freshly ground black pepper ",
            "3 oil-packed anchovy fillets, finely chopped \n",
            "2 large egg yolks",
            "2 garlic cloves, grated",
            "1 Tbsp. Dijon mustard",
            "1 Tbsp. fresh lemon juice",
            "2/3 cup neutral oil",
            "1/3 cup finely grated Parmesan",
            "1/2 tsp. freshly ground black pepper",
            "Kosher salt",
            "3 heads of romaine lettuce, coarsely chopped",
            "1/4 tsp. salt",
            "1/2 cup shaved parmesan"
        ),
        directions = listOf(
            "Prepare croutons: Arrange a rack in center of oven; preheat to 375°. In a large bowl, toss bread pieces, oil, salt, and pepper. Spread bread pieces on a baking sheet.",
            "Bake croutons until crispy and light golden brown, 10 to 12 minutes.",
            "Prepare dressing: Meanwhile, in a medium bowl, whisk anchovies, egg yolks, garlic, mustard, and lemon juice. While whisking, slowly stream in oil until dressing is thick and creamy. (This can also be done with an immersion blender or in a small food processor.)",
            "Stir in Parmesan and black pepper; season with salt.",
            "Assemble: In a large bowl, toss romaine and salt.",
            "Add Parmesan and croutons. Pour in 1/3 cup dressing and toss to combine. Serve with remaining dressing alongside."
        ),
        servings = 4,
        meal = "Lunch",
        image = R.drawable.caesarsalad
    ),

    Recipes(
        name = "Pinwheel Sandwiches",
        prepTimeMin = 10,
        cookTimeMin = 25,
        ingredients = listOf(
            "3/4 cup mayonnaise",
            "2 Tbsp. ranch seasoning",
            "8 (10\") flour tortillas",
            "8 oz. sliced American or cheddar cheese",
            "1 lb. deli-sliced baked ham",
            "1 lb. deli-sliced turkey breast",
            "16 butter lettuce leaves"
        ),
        directions = listOf(
            "In a small bowl, mix mayonnaise and ranch seasoning.",
            "On a clean surface, lay tortillas flat. Spread each tortilla with 1 tablespoon mayonnaise mixture. Place 2 to 3 slices cheese on bottom two-thirds of each tortilla. Top cheese with ham and turkey. Top meat with 2 to 3 lettuce leaves and tightly roll up.",
            "To serve right away, slice into 1\" rounds and arrange on a platter. To make ahead, place seam side down on a baking sheet and refrigerate up to 6 hours. Slice when ready to serve."
        ),
        servings = 40,
        meal = "Lunch",
        image = R.drawable.pinwheels
    ),

    Recipes(
        name = "Steak Fajita Power Bowls",
        prepTimeMin = 30,
        cookTimeMin = 45,
        ingredients = listOf(
            "2 Tbsp. vegetable oil, divided",
            "1/2 yellow onion, sliced into half moons",
            "2 bell peppers, seeds and ribs removed, thinly sliced",
            "Kosher salt",
            "Freshly ground black pepper",
            "1 lb. skirt steak, cut into 1/2\" slices",
            "Juice of 1/2 lime",
            "1/2 tsp. chili powder",
            "1/2 tsp. cumin",
            "4 cups cooked brown rice",
            "1 avocado, thinly sliced",
            "1 cup black beans, drained, rinsed",
            "1 cup frozen corn, thawed, warmed",
            "1 Tbsp. finely chopped fresh cilantro",
            "Sour cream, for serving"
        ),
        directions = listOf(
            "In a large skillet over medium heat, heat 1 Tbsp. oil. Add onions and peppers; season with salt and pepper. Cook, stirring frequently, until onions are translucent and peppers are tender, 7 to 10 minutes. Transfer to a plate.",
            "In same skillet over medium-high heat, heat remaining 1 Tbsp. oil until very hot, about 30 seconds. Arrange steak in pan and pour lime juice over. Add chili powder and cumin; season with salt and pepper. Cook steak, undisturbed, until browned, 2 to 3 minutes. Continue to cook, stirring occasionally, to your preference, about 2 minutes more for medium. Transfer to another plate.",
            "Divide rice among bowls. Top with steak, onions, peppers, avocado, beans, and corn. Top with cilantro. Drizzle with sour cream."
        ),
        servings = 4,
        meal = "Lunch",
        image = R.drawable.steakfajitapowerbowls
    ),

    Recipes(
        name = "Crispy Sheet-Pan Black Bean Tacos",
        prepTimeMin = 5,
        cookTimeMin = 45,
        ingredients = listOf(
            "5 Tbsp. neutral oil, divided",
            "1 small yellow onion, finely chopped",
            "1 tsp. kosher salt, divided",
            "1 Tbsp. taco seasoning",
            "1 (15.5-oz.) can black beans, drained, rinsed",
            "8 (6\") yellow corn tortillas, warmed",
            "1 cup shredded Mexican blend cheese",
            "Sour cream, cilantro leaves, and lime wedges, for serving (optional)"
        ),
        directions = listOf(
            "Place a rack in center of oven; preheat to 425°. In a large skillet over medium heat, heat 2 tablespoons oil. Add onion, season with 1/2 teaspoon salt, and cook, stirring occasionally, until softened and sweet to the taste, about 7 minutes. Add taco seasoning and 1 tablespoon oil and cook, stirring, until fragrant, about 30 seconds.",
            "Add beans, remaining 1/2 teaspoon salt, and 1/2 cup water. Bring to a simmer over high heat; reduce heat to medium-low and simmer, mashing down on some beans, until thickened and reduced, 2 to 3 minutes. Remove from heat.",
            "Grease a large metal baking sheet with remaining 2 tablespoons oil. Arrange tortillas in a single layer, making sure that one side of tortilla is coated in oil. Spoon a scant 1/4 cup bean mixture onto one half of each tortilla. Top each with 2 tablespoons cheese. Fold tortillas over cheese to create a taco (it's okay if they crack a little). Flip tacos so side with cheese is closest to baking sheet.",
            "Bake tacos until golden brown and crisp on the bottom, 8 to 10 minutes. Flip tacos and continue to bake until golden brown and crisp on the other side, 5 to 8 minutes longer.",
            "Transfer tacos to a platter. Serve with sour cream, cilantro, and lime wedges alongside (if using)."
        ),
        servings = 4,
        meal = "Lunch",
        image = R.drawable.sheetpanbeantacos
    ),

    Recipes(
        name = "Buffalo Chicken Grilled Cheese",
        prepTimeMin = 10,
        cookTimeMin = 10,
        ingredients = listOf(
            "2 cups rotisserie chicken, shredded",
            "1 block cream cheese, softened",
            "1/2 cup buffalo sauce",
            "1/2 cup shredded sharp white cheddar (or Monterey Jack)",
            "2 Tbsp. butter",
            "4 slices bread"
        ),
        directions = listOf(
            "In a large mixing bowl, combine chicken, cream cheese, buffalo sauce, and white cheddar. Slather on bread and form sandwiches, then set aside.",
            "In a sauté pan over medium heat, melt butter. Add sandwiches and cook until golden brown, about 2 minutes. Flip and grill the other side, 1 to 2 minutes."
        ),
        servings = 2,
        meal = "Lunch",
        image = R.drawable.buffalochickengrilledcheese
    ),

    Recipes(
        name = "Taco Salad",
        prepTimeMin = 15,
        cookTimeMin = 35,
        ingredients = listOf(
            "1 lb. ground beef",
            "Kosher salt",
            "Freshly ground black pepper",
            "2 Tbsp. store-bought or homemade taco seasoning",
            "2 Tbsp. tomato paste",
            "2 cups (or more) vegetable oil",
            "2 (4\") corn tortillas, cut into 1/4\" strips",
            "2 heads romaine, coarsely chopped",
            "2 1/2 cups halved cherry tomatoes",
            "1 (15-oz.) can black beans, drained, rinsed",
            "1 cup shredded cheddar",
            "1/2 cup pico de gallo",
            "1/4 cup coarsely chopped or whole cilantro",
            "1/2 cup sour cream"
        ),
        directions = listOf(
            "In a large cast-iron skillet over medium-high heat, cook beef, breaking up into small pieces with a wooden spoon; season with salt and pepper. Add taco seasoning, tomato paste, and 2 Tbsp. water. Cook, stirring occasionally, until beef is browned and cooked through, about 5 minutes. Remove from heat.",
            "Into another large skillet, pour oil to a depth of 1/2\". Heat over medium-high heat until hot but not smoking. Fry tortilla strips, turning halfway through, until golden brown, about 2 minutes. Transfer to a paper towel-lined plate; immediately season with salt.",
            "In a large bowl, season lettuce with a pinch of salt. Add tomatoes, beans, and beef mixture and toss to combine.",
            "Top with cheese, pico de gallo, cilantro, and tortilla strips. Dollop with sour cream."
        ),
        servings = 4,
        meal = "Lunch",
        image = R.drawable.tacosalad
    ),

    Recipes(
        name = "Tuscan Chicken Wrap",
        prepTimeMin = 15,
        cookTimeMin = 20,
        ingredients = listOf(
            "6 Tbsp. mayonnaise",
            "3 Tbsp. chopped fresh basil",
            "2 Tbsp. chopped sun-dried tomatoes",
            "2 Tbsp. finely grated Parmesan",
            "1 Tbsp. chopped fresh oregano or 1 tsp. dried oregano",
            "1 scallion, sliced",
            "1 clove garlic, grated",
            "4 (10\") flour wraps",
            "1 1/2 oz. packed baby spinach or arugula (about 1 1/2 c.), divided",
            "2 cups cooked chopped rotisserie chicken (about 8 oz.), divided",
            "4 oz. cherry tomatoes, quartered, divided",
            "4 oz. fresh mozzarella, sliced, divided"
        ),
        directions = listOf(
            "In a small bowl, mix mayonnaise, basil, sun-dried tomatoes, Parmesan, oregano, scallion, and garlic until combined.",
            "Spread one-quarter of mayonnaise mixture onto 1 wrap, leaving a 1\" border. Top with one-quarter of spinach, 1/2 cup chicken, 1 ounce cherry tomatoes, and 1 ounce mozzarella. Fold in sides of wrap, then tightly roll bottom of wrap away from you, keeping sides tucked in, until a burrito shape forms. Repeat with remaining mayonnaise mixture, wraps, spinach, chicken, cherry tomatoes, and mozzarella. Slice wraps in half to serve."
        ),
        servings = 4,
        meal = "Lunch",
        image = R.drawable.tuscanchickenwrap
    ),

    Recipes(
        name = "Deviled Eggs",
        prepTimeMin = 10,
        cookTimeMin = 25,
        ingredients = listOf(
            "6 large eggs",
            "3 tablespoons mayonnaise",
            "1 teaspoon Dijon mustard",
            "1 teaspoon dill pickle brine",
            "Hot sauce, such as Tabasco, optional",
            "Sea salt and freshly ground black pepper",
            "Paprika, chives, and/or fresh dill, for garnish"
        ),
        directions = listOf(
            "Place the eggs in a medium pot and cover with cold water by 1 inch. Bring to a boil, then cover the pot and turn off the heat. Let the eggs sit, covered, for 10 to 12 minutes, depending on your desired doneness.",
            "Transfer the eggs to a bowl of ice water and chill for 14 minutes, or until cooled completely.",
            "Gently rap the eggs on the counter to crack the shells, then peel. I like to do this under cool running water to help the shells slip off. Pat dry if necessary.",
            "Slice the peeled eggs in half lengthwise. Use a small spoon to carefully scoop out the yolks and transfer them to a medium bowl. Set the egg whites aside.",
            "To the bowl with the egg yolks, add the mayonnaise, mustard, apple cider vinegar, and a dash of hot sauce, if using. Mash with a fork until creamy, then season to taste with salt, pepper, and more hot sauce, as desired. For a smoother deviled egg filling, pulse the mixture in a food processor.\nDivide the filling among the egg whites and garnish with paprika, chives, and/or fresh dill."
        ),
        servings = 6,
        meal = "Appetizer",
        image = R.drawable.deviledeggs
    ),

    Recipes(
        name = "Seafood Stuffed Mushrooms",
        prepTimeMin = 20,
        cookTimeMin = 30,
        ingredients = listOf(
            "12 oz bag Italian Stuffing mix",
            "12 oz Seafood Stuffing",
            "1 can Minced Clams",
            "1 can Crab Meat",
            "1 cup Shredded Mozzarella Cheese",
            "3 Tbsp. Butter (melted)",
            "3 8oz. containers Whole White Mushrooms"
        ),
        directions = listOf(
            "Pre-heat oven to 350F. Wash and separate stems from mushroom caps, save about 8 stems to chop and set aside.",
            "Add 1-2 tbsp of cooking oil to skillet on medium heat, add chopped stems, clams, and crab meat. Save and set aside the broth from both cans.",
            "Spread mushroom caps onto a baking sheet in a single layer and bake for 8-10 minutes prior to stuffing, until they just start to darken.",
            "Follow the directions to cook the italian stuffing, using the saved broth in place of water, adding water until liquid is the required water amount, before adding dry stuffing add in saute mix.",
            "Add seafood stuffing to the stuffing mixture, if the mix is dry add a small amount of additional water. Then add cheese and mix well.",
            "Add stuffing to the mushroom caps, overflowing a bit, and then brush with melted butter.",
            "Bake in pre-heated oven for 30 minutes, or until mushrooms are tender."
        ),
        servings = 12,
        meal = "Appetizer",
        image = R.drawable.stuffedmushrooms
    ),

    Recipes(
        name = "Caprese Skewers",
        prepTimeMin = 15,
        cookTimeMin = 15,
        ingredients = listOf(
            "24 cherry tomatoes",
            "12 mini mozzarella balls",
            "24 basil leaves",
            "Extra-virgin olive oil, for drizzling",
            "Balsamic reduction, for drizzling",
            "Sea salt and freshly ground black pepper"
        ),
        directions = listOf(
            "Thread the tomatoes, mozzarella, and basil onto mini skewers.",
            "Drizzle with olive oil and balsamic reduction and sprinkle with salt and pepper."
        ),
        servings = 4,
        meal = "Appetizer",
        image = R.drawable.capreseskewers
    ),

    Recipes(
        name = "Jalapeño Poppers",
        prepTimeMin = 20,
        cookTimeMin = 20,
        ingredients = listOf(
            "12 jalapeño peppers",
            "1 cup thick whole milk Greek yogurt*, (see note)",
            "¼ cup grated cheddar cheese**, (see note)",
            "3 tablespoons chives, divided",
            "2 garlic cloves, grated",
            "½ teaspoon onion powder",
            "½ heaping teaspoon sea salt, more for sprinkling",
            "⅛ teaspoon smoked paprika",
            "6 tablespoons panko bread crumbs",
            "Extra-virgin olive oil, for drizzling"
        ),
        directions = listOf(
            "Preheat the oven to 400°F and line a baking sheet with parchment paper",
            "Slice the jalapeños in half and remove the seeds and ribbing. Note: You might want to use rubber or disposable plastic gloves when working with these spicy peppers.",
            "In a small bowl, combine the yogurt, cheese, 2 tablespoons of the chives, garlic, onion powder, salt, and smoked paprika, if using.",
            "Fill the jalapeño halves with the yogurt mixture, sprinkle with panko, drizzle with olive oil and bake for 15 to 20 minutes or until the peppers are tender and the topping is golden brown. Remove from the oven and garnish with the remaining chives."
        ),
        servings = 8,
        meal = "Appetizer",
        image = R.drawable.jalapenopoppers
    ),

    Recipes(
        name = "Spinach Artichoke Dip",
        prepTimeMin = 25,
        cookTimeMin = 40,
        ingredients = listOf(
            "3 cups small cauliflower florets, 3/4-inch pieces",
            "2 garlic cloves",
            "5 ounces fresh spinach",
            "1 (14-ounce) can whole artichoke hearts, drained, patted dry, and chopped",
            "⅓ cup chopped scallions",
            "½ cup whole milk Greek yogurt",
            "1½ tablespoons extra-virgin olive oil, more for brushing",
            "Heaping ½ teaspoon Dijon mustard",
            "Scant 1 teaspoon sea salt",
            "¾ cup white cheddar cheese",
            "Pinches of red pepper flakes"
        ),
        directions = listOf(
            "Preheat the oven to 450°F and brush an 8-inch cast iron skillet lightly with olive oil.",
            "Bring a large pot of salted water to a boil. Add the cauliflower and garlic and boil until the cauliflower is fork tender, about 8 minutes. Use a slotted spoon to scoop the cauliflower and the garlic into a blender, reserving the pot of cooking water.",
            "Set a bowl of ice water nearby. Add the spinach to the boiling water and use a slotted spoon to immediately remove it (it’ll wilt very quickly) and transfer to the ice water to cool completely. Drain and squeeze excess moisture from the spinach. Coarsely chop the spinach and add it to a large bowl with the artichokes and scallions.",
            "Check to make sure that the cauliflower in the blender has (mostly) cooled, then add the yogurt, olive oil, mustard, and salt to the blender and blend until creamy. Add this mixture to the bowl with the spinach and artichokes and stir to combine.",
            "Spread the spinach mixture into the skillet and top with the cheese and pinches of red pepper flakes. Bake 15 to 18 minutes, or until the cheese on top is browned and bubbling.",
            "Garnish with parsley, if desired, and serve with baguette slices."
        ),
        servings = 4,
        meal = "Appetizer",
        image = R.drawable.spinachartichokedip
    )
)
