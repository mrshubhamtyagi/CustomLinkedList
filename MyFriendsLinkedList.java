public class MyFriendsLinkedList {
    static int totalFriends = 0;

    private Node headNode;

    MyFriendsLinkedList() {
        headNode = null;
    }

    public void addFriend(Friend friend) {

        if (headNode == null) {
            headNode = new Node(friend);
        } else {
            Node traverse = headNode;
            while (traverse.link != null) {
                traverse = traverse.link;
            }
            Node newNode = new Node(friend);
            traverse.link = newNode;
        }
        totalFriends++;
    }

    public void addAllFriends(Friend... friend) {
        Node newNode;
        for (Friend obj : friend) {
            newNode = new Node(obj);
            if (headNode == null) {
                headNode.link = newNode;
            } else {
                Node traverse = headNode;
                newNode = new Node(obj);
                while (traverse.link != null) {
                    traverse = traverse.link;
                }
                traverse.link = newNode;
            }
            totalFriends++;
        }
        return;
    }

    public boolean removeFriend(String fullName) {
        if (fullName.trim().equals(headNode.data.getName())) {
            headNode = headNode.link;
            totalFriends--;
            return true;
        } else {
            Node traverse = headNode;
            while (traverse.link != null) {
                if (traverse.link.data.getName().equals(fullName.trim())) {
                    traverse.link = traverse.link.link;
                    totalFriends--;
                    return true;
                }
                traverse = traverse.link;
            }
            return false;
        }
    }

    public void printList() {
        Node traverse = headNode;
        while (traverse != null) {
            System.out.println(traverse.data.toString());
            traverse = traverse.link;
        }
    }

    public int totalFriends() {
        return totalFriends;
    }
}


class Node {
    Friend data;
    Node link;

    Node(Friend friend) {
        data = friend;
        link = null;
    }
}


class Friend {

    private String name;
    private double friendshipAge;

    Friend(String name, double friendshipAge) {
        this.name = name;
        this.friendshipAge = friendshipAge;
    }

    public String getName() {
        return name;
    }

    public double getFriendshipAge() {
        return friendshipAge;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFriendshipAge(double friendshipAge) {
        this.friendshipAge = friendshipAge;
    }


    @Override
    public String toString() {
        String years = " years";
        if (this.friendshipAge == 1) years = " year";
        else if (this.friendshipAge < 1) years = " months";
        return "Name -> " + this.name + "\nFriendship Age -> " + this.friendshipAge + years + "\n";
    }
}