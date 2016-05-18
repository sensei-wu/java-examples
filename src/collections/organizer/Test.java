package collections.organizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
        CodingTask databaseCode = new CodingTask("db");
        CodingTask interfaceCode = new CodingTask("gui");
        CodingTask logicCode = new CodingTask("logic");
        Collection<PhoneTask> phoneTasks = new ArrayList<>();
        Collection<CodingTask> codingTasks = new ArrayList<>();
        Collection<Task> mondayTasks = new ArrayList<>();
        Collection<Task> tuesdayTasks = new ArrayList<>();
        Collections.addAll(phoneTasks, mikePhone, paulPhone);
        Collections.addAll(codingTasks, databaseCode, interfaceCode, logicCode);
        Collections.addAll(mondayTasks, logicCode, mikePhone);
        Collections.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);
        assert phoneTasks.toString().equals("[phone Mike, phone Paul]");
        assert codingTasks.toString().equals("[code db, code gui, code logic]");
        assert mondayTasks.toString().equals("[code logic, phone Mike]");
        assert tuesdayTasks.toString().equals("[code db, code gui, phone Paul]");

        Collection<Task> mergedTasks = MergeCollections.merge(mondayTasks, tuesdayTasks);
        assert mergedTasks.toString().equals("[code db, code gui, code logic, phone Mike, phone Paul]");
    }
}
