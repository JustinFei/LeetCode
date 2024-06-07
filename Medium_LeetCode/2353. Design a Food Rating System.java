class Food implements Comparable<Food> {
    // Store the food's rating.
    public int rating;
    // Store the food's name.
    public String name;

    public String cuisine;

    public Food(String name, int rating, String cuisine) {
        this.name = name;
        this.rating = rating;
        this.cuisine = cuisine;

    }

    // Implement the compareTo method for comparison
    @Override
    public int compareTo(Food other) {
        // If food ratings are the same, sort based on their names (lexicographically smaller name food will be on top)
        if (rating == other.rating) {
            return name.compareTo(other.name);
        }
        // Sort based on food rating (bigger rating food will be on top)
        return -1 * Integer.compare(rating, other.rating);
    }
}

class FoodRatings {
    Map<String, PriorityQueue<Food>> pqMap;
    Map<String, Food> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        pqMap = new HashMap<>();
        foodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food cur = new Food(foods[i], ratings[i], cuisines[i]);
            pqMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<Food>()).offer(cur);
            foodMap.put(cur.name, cur);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food cur = foodMap.get(food);
        PriorityQueue<Food> pq = pqMap.get(cur.cuisine);
        pq.remove(cur);
        cur.rating = newRating;
        pq.offer(cur);
    }
    
    public String highestRated(String cuisine) {
        return pqMap.get(cuisine).peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */