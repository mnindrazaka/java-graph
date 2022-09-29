import java.util.ArrayList;
import java.util.List;

public class PeopleNetwork extends Graph<People> {
    public void addPeople(People people) {
        this.addVertex(people);
    }

    public void addConnection(People source, People destination) {
        this.addEdge(source, destination, true);
    }

    public void printConnection(People source) {
        int no = 1;
        List<People> connections = this.map.get(source);

        if (connections.size() > 0) {
            for (People people : connections) {
                System.out.println(no + ". " + people.getName());
                no++;
            }
        } else {
            System.out.println("No connection");
        }
    }

    public List<People> getConnectionSuggestion(People source) {
        List<People> suggestions = new ArrayList<>();

        for (People connection : this.map.get(source)) {
            for (People suggestedConnection : this.map.get(connection) ) {
                if (!suggestions.contains(suggestedConnection) && !this.map.get(source).contains(suggestedConnection) && source != suggestedConnection) {
                    suggestions.add(suggestedConnection);
                }
            }
        }

        return suggestions;
    }

    public void printConnectionSuggestion(People source) {
        int no = 1;
        List<People> suggestions = this.getConnectionSuggestion(source);

        if (suggestions.size() > 0) {
            for (People people : suggestions) {
                System.out.println(no + ". " + people.getName());
                no++;
            }
        } else {
            System.out.println("No suggested connection");
        }
    }

    public void printPeopleList() {
        int no = 1;
        for (People people : this.map.keySet()) {
            System.out.println(no + ". " + people.getName());
            no++;
        }
    }

    public People getPeopleByName(String name) {
        for (People people : this.map.keySet()) {
            if (people.getName().equals(name)) {
                return people;
            }
        }
        return null;
    }
}
