package model;

import java.util.ArrayList;
import java.util.HashMap;

public class TinderLike {
    private HashMap<User, ArrayList<Interest>> tinder;

    public TinderLike() {
        tinder = new HashMap<>();
    }

    public void add(User user, ArrayList<Interest> interests) {
        if (user != null && interests != null) {
            tinder.put(user, interests);
        }
    }

    public void remove(User user) {
        tinder.remove(user);
    }

    public int compareInterests(User user1, User user2) {
        int n = 0;

        ArrayList<Interest> interest1 = tinder.get(user1);
        ArrayList<Interest> interest2 = tinder.get(user2);

        for (Interest interestA : interest1) {
            for (Interest interestB : interest2) {
                if (interestA == interestB) {
                    n++;
                    break;
                }
            }
        }

        return n;
    }

    public User match(User user) {
        ArrayList<User> temp = match(user, 1);
        return temp.get(0);
    }

    public ArrayList<User> match(User user, int n) {
        int max = 0;
        User temp = null;
        ArrayList<User> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (User entry : tinder.keySet()) {
                if (!entry.equals(user) && !result.contains(entry)) {
                    int m = compareInterests(entry, user);

                    if (max < m) {
                        max = m;
                        temp = entry;
                    }
                }
            }
            result.add(temp);
            max = 0;
        }

        return result;
    }

}
