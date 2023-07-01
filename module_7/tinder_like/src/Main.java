import model.Interest;
import model.TinderLike;
import model.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TinderLike tinderLike = new TinderLike();

        Interest iTennis = new Interest("1", "tennis");
        Interest iDance = new Interest("2", "dance");
        Interest iGym = new Interest("3", "gym");
        Interest iJogging = new Interest("4", "jogging");
        Interest iSwimming = new Interest("5", "swimming");

        User uAndrea = new User("1", "Andrea");
        User uMarco = new User("2", "Marco");
        User uAnna = new User("3", "Anna");

        ArrayList<Interest> interestsAndrea = new ArrayList<>();
        interestsAndrea.add(iTennis);
        interestsAndrea.add(iDance);
        interestsAndrea.add(iGym);

        ArrayList<Interest> interestsAnna = new ArrayList<>();
        interestsAnna.add(iTennis);
        interestsAnna.add(iSwimming);
        interestsAnna.add(iJogging);

        ArrayList<Interest> interestsMarco = new ArrayList<>();
        interestsMarco.add(iTennis);
        interestsMarco.add(iJogging);

        tinderLike.add(uAndrea, interestsAndrea);
        tinderLike.add(uMarco, interestsMarco);
        tinderLike.add(uAnna, interestsAnna);

        System.out.println(uAndrea.getName() + " match " + tinderLike.match(uAndrea).getName());
        System.out.println(uMarco.getName() + " match " + tinderLike.match(uMarco).getName());
        System.out.println(uAnna.getName() + " match " + tinderLike.match(uAnna).getName());

        System.out.println(uAndrea.getName() + " second match " + tinderLike.match(uAndrea, 2).get(1).getName());
        System.out.println(uMarco.getName() + " second match " + tinderLike.match(uMarco, 2).get(1).getName());
        System.out.println(uAnna.getName() + " second match " + tinderLike.match(uAnna, 2).get(1).getName());
    }
}
