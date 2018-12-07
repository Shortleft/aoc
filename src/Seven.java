import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Seven {


    public  void findSequece() {
        List<String> parsedInput = Arrays.asList(INPUT.split("\n"));

        List<SevenHelper> dependencies = parsedInput.stream().map(x -> new SevenHelper(x)).collect(Collectors.toList());

        HashMap<String, List<String>> map = new HashMap();

        for(SevenHelper d : dependencies) {
            if(map.containsKey(d.getFirst())) {
                List<String> list = map.get(d.getFirst());
                list.add(d.getSecond());
                map.put(d.getFirst(), list);
            } else {
                List<String> l = new ArrayList<>();
                l.add(d.getSecond());
                map.put(d.getFirst(), l);
            }
        }

        StringBuilder result = new StringBuilder();

        List<String> keys = new ArrayList<>(map.keySet());

        List<String> values = new ArrayList<>();

        for(List<String> valueList : map.values()) {
            for(String value: valueList) {
                if (!values.contains(value)) {
                    values.add(value);
                }
            }
        }

        for(String key : map.keySet()) {
            if(!values.contains(key)) {
                values.add(key);
            }
        }

        Collections.sort(values);


        int worker1 = 0;

        String worker1Task = null;

        int worker2 = 0;

        int time = 0;

        int[] timeArray = new int[5];

        String[] tasks = new String[5];

        for(int i = 0; i < timeArray.length; i++) {
            tasks[i] = null;
            timeArray[i] = 0;
        }

        while (!values.isEmpty()) {
            boolean taskDone = false;
            for(int i = 0; i < timeArray.length; i++) {
                if (timeArray[i] == 0) {
                    if (tasks[i] != null) {
                        map.remove(tasks[i]);
                        result.append(tasks[i]);
                    }
                    String s = "";
                    for (String value : values) {
                        if (!valuesContainsKey(map.values(), value)) {
                            s = value;
                            break;
                        }
                    }
                    tasks[i] = s;
                    if (!s.isEmpty()) {
                        values.remove(s);
                        timeArray[i] = (int) s.charAt(0) - 4;
                    }
                }
                if (!tasks[i].isEmpty()) {
                    taskDone = true;
                    timeArray[i]--;
                }
            }
            if(taskDone) {
                time++;
            }
        }

        int largestTime = 0;
        for(int i = 0; i < timeArray.length; i++) {
            if(timeArray[i] > 0) {
                System.out.println(tasks[i]);
                if(timeArray[i] > largestTime) {
                    largestTime = timeArray[i];
                }
            }
        }

        time = time + largestTime;

        System.out.println(result.toString());
        System.out.println(time);
    }

    public boolean valuesContainsKey(Collection<List<String>> values, String key) {
        for(List<String> value : values) {
            if(value.contains(key)) {
                return true;
            }
        }

        return  false;
    }

    private boolean dataAlreadyExtracted(Node<String> node, String data) {
        if(node.getData().equals(data)) {
            return true;
        }

        if(node.isLeaf()) {
            return false;
        }

        for(Node<String> childNode : node.getChildren()) {
            if(dataAlreadyExtracted(childNode, data)) {
                return true;
            }
        }

        return false;

    }

  /* private static String INPUT = "Step C must be finished before step A can begin.\n" +
            "Step C must be finished before step F can begin.\n" +
            "Step A must be finished before step B can begin.\n" +
            "Step A must be finished before step D can begin.\n" +
            "Step B must be finished before step E can begin.\n" +
            "Step D must be finished before step E can begin.\n" +
            "Step F must be finished before step E can begin.";
*/

    private static String INPUT = "Step F must be finished before step P can begin.\n" +
            "Step R must be finished before step J can begin.\n" +
            "Step X must be finished before step H can begin.\n" +
            "Step L must be finished before step N can begin.\n" +
            "Step U must be finished before step Z can begin.\n" +
            "Step B must be finished before step C can begin.\n" +
            "Step S must be finished before step C can begin.\n" +
            "Step N must be finished before step Y can begin.\n" +
            "Step I must be finished before step J can begin.\n" +
            "Step H must be finished before step K can begin.\n" +
            "Step G must be finished before step Z can begin.\n" +
            "Step Q must be finished before step V can begin.\n" +
            "Step E must be finished before step P can begin.\n" +
            "Step P must be finished before step W can begin.\n" +
            "Step J must be finished before step D can begin.\n" +
            "Step V must be finished before step W can begin.\n" +
            "Step T must be finished before step D can begin.\n" +
            "Step Z must be finished before step A can begin.\n" +
            "Step K must be finished before step A can begin.\n" +
            "Step Y must be finished before step O can begin.\n" +
            "Step O must be finished before step W can begin.\n" +
            "Step C must be finished before step M can begin.\n" +
            "Step D must be finished before step A can begin.\n" +
            "Step W must be finished before step M can begin.\n" +
            "Step M must be finished before step A can begin.\n" +
            "Step C must be finished before step A can begin.\n" +
            "Step F must be finished before step Z can begin.\n" +
            "Step I must be finished before step A can begin.\n" +
            "Step W must be finished before step A can begin.\n" +
            "Step T must be finished before step C can begin.\n" +
            "Step S must be finished before step K can begin.\n" +
            "Step B must be finished before step J can begin.\n" +
            "Step O must be finished before step A can begin.\n" +
            "Step Q must be finished before step P can begin.\n" +
            "Step G must be finished before step M can begin.\n" +
            "Step R must be finished before step T can begin.\n" +
            "Step B must be finished before step G can begin.\n" +
            "Step J must be finished before step O can begin.\n" +
            "Step X must be finished before step E can begin.\n" +
            "Step X must be finished before step C can begin.\n" +
            "Step H must be finished before step Y can begin.\n" +
            "Step Y must be finished before step A can begin.\n" +
            "Step X must be finished before step W can begin.\n" +
            "Step H must be finished before step A can begin.\n" +
            "Step X must be finished before step A can begin.\n" +
            "Step I must be finished before step M can begin.\n" +
            "Step G must be finished before step J can begin.\n" +
            "Step N must be finished before step G can begin.\n" +
            "Step D must be finished before step M can begin.\n" +
            "Step L must be finished before step D can begin.\n" +
            "Step V must be finished before step T can begin.\n" +
            "Step I must be finished before step Y can begin.\n" +
            "Step S must be finished before step J can begin.\n" +
            "Step K must be finished before step Y can begin.\n" +
            "Step F must be finished before step R can begin.\n" +
            "Step U must be finished before step T can begin.\n" +
            "Step Z must be finished before step M can begin.\n" +
            "Step T must be finished before step Z can begin.\n" +
            "Step B must be finished before step I can begin.\n" +
            "Step E must be finished before step K can begin.\n" +
            "Step N must be finished before step J can begin.\n" +
            "Step X must be finished before step Q can begin.\n" +
            "Step F must be finished before step Y can begin.\n" +
            "Step H must be finished before step P can begin.\n" +
            "Step Z must be finished before step D can begin.\n" +
            "Step V must be finished before step O can begin.\n" +
            "Step E must be finished before step C can begin.\n" +
            "Step V must be finished before step C can begin.\n" +
            "Step P must be finished before step A can begin.\n" +
            "Step B must be finished before step N can begin.\n" +
            "Step S must be finished before step W can begin.\n" +
            "Step P must be finished before step D can begin.\n" +
            "Step L must be finished before step W can begin.\n" +
            "Step D must be finished before step W can begin.\n" +
            "Step K must be finished before step C can begin.\n" +
            "Step L must be finished before step M can begin.\n" +
            "Step R must be finished before step O can begin.\n" +
            "Step F must be finished before step L can begin.\n" +
            "Step R must be finished before step H can begin.\n" +
            "Step K must be finished before step O can begin.\n" +
            "Step T must be finished before step W can begin.\n" +
            "Step R must be finished before step K can begin.\n" +
            "Step C must be finished before step W can begin.\n" +
            "Step N must be finished before step T can begin.\n" +
            "Step R must be finished before step P can begin.\n" +
            "Step E must be finished before step M can begin.\n" +
            "Step G must be finished before step T can begin.\n" +
            "Step U must be finished before step K can begin.\n" +
            "Step Q must be finished before step D can begin.\n" +
            "Step U must be finished before step S can begin.\n" +
            "Step J must be finished before step V can begin.\n" +
            "Step P must be finished before step Y can begin.\n" +
            "Step X must be finished before step Z can begin.\n" +
            "Step U must be finished before step H can begin.\n" +
            "Step H must be finished before step M can begin.\n" +
            "Step I must be finished before step C can begin.\n" +
            "Step V must be finished before step M can begin.\n" +
            "Step N must be finished before step I can begin.\n" +
            "Step B must be finished before step K can begin.\n" +
            "Step R must be finished before step Q can begin.\n" +
            "Step O must be finished before step C can begin.";

}
