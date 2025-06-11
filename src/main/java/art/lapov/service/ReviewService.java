package art.lapov.service;

import art.lapov.model.Review;

import java.util.List;

public class ReviewService {

    public static List<Review> getReviewsByAuthor(String name, List<Review> reviews) {
        return reviews.stream()
                .filter(review -> review.getUserName().equals(name))
                .sorted( (r1, r2) -> r2.getDateOfComment().compareTo(r1.getDateOfComment()))
                .toList();
    }

}
