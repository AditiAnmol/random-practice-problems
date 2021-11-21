import java.util.Collection;
import java.util.ArrayList;

public class Friend {
    private Collection<Friend> friends;
    private String email;
    private boolean isVisited = false;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        for(final Friend tempFriend: this.friends) {
            if(!tempFriend.isVisited) {
                this.isVisited = true;
                if(tempFriend.email.equals(friend.email) || tempFriend.canBeConnected(friend)) {
                    return true;
                }
            } else {
                continue;
            }
        }
    return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");
        Friend e = new Friend("E");
        Friend f = new Friend("F");
        Friend g = new Friend("G");
        Friend h = new Friend("H");

        a.addFriendship(g);
        c.addFriendship(d);
        c.addFriendship(e);
        a.addFriendship(f);
        e.addFriendship(b);
        f.addFriendship(b);
        g.addFriendship(f);


        System.out.println(a.canBeConnected(b));
    }
}