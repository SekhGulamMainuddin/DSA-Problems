// https://leetcode.com/problems/design-a-food-rating-system/

import java.util.HashMap;
import java.util.PriorityQueue;

public class DesignAFoodRatingSystem {
    static class Pair implements Comparable<Pair> {
        String food;
        int rating;

        Pair(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        @Override
        public int compareTo(Pair o) {
            // Higher rating first
            int value = Integer.compare(o.rating, this.rating);
            if (value == 0) {
                value = this.food.compareTo(o.food);
            }
            return value;
        }
    }

    HashMap<String, Integer> foodRatingsMap = new HashMap<>();
    HashMap<String, PriorityQueue<Pair>> cuisineHeapMap = new HashMap<>();
    HashMap<String, String> foodToCuisineMap = new HashMap<>();

    public DesignAFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        for (String cuisine : cuisines) {
            /// This is by default going to be priority queue because of the compareTo function in Pair class
            cuisineHeapMap.put(cuisine, new PriorityQueue<>());
        }

        for (int i = 0; i < foods.length; i++) {
            foodRatingsMap.put(foods[i], ratings[i]);
            PriorityQueue<Pair> q = cuisineHeapMap.get(cuisines[i]);
            q.add(new Pair(foods[i], ratings[i]));
            foodToCuisineMap.put(foods[i], cuisines[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingsMap.put(food, newRating);
        cuisineHeapMap.get(foodToCuisineMap.get(food)).add(new Pair(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Pair> q = cuisineHeapMap.get(cuisine);
        Pair highest = q.peek();

        while (foodRatingsMap.get(highest.food) != highest.rating) {
            q.poll();
            highest = q.peek();
        }

        return highest.food;
    }
}
