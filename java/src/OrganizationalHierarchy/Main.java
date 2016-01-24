package OrganizationalHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chris on 1/9/2016.
 */
public class Main {


    static class NodeTree implements Comparable {


        List<NodeTree> children;

        String name;


        public NodeTree() {

            name = "";
            children = new ArrayList<>();
        }

        public NodeTree(String name) {

            this();
            this.name = name;

        }

        public boolean add(String myName, String parentName) {
            if (this.name.equals(myName)) return false;
            if (this.name.equals(parentName) && !(name.isEmpty() && children.size() > 0)) {
                children.add(new NodeTree(myName));

                Collections.sort(children);

                return true;
            }


            for (NodeTree nt : children) {
                nt.add(myName, parentName);
            }

            return false;

        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();


            if (name.isEmpty()) {
                sb.append(children.get(0).toString());
            } else {
                sb.append(name);

                if (children.size() > 0) {
                    sb.append(" [");

                    for (int i = 0; i < children.size(); i++) {
                        sb.append(children.get(i).toString());
                        if (i < children.size() - 1) sb.append(", ");
                    }
                    sb.append("]");
                }
            }


            return sb.toString();


            // a [b [c [d, x [z]]], e]
        }

        @Override
        public int compareTo(Object o) {


            NodeTree that = (NodeTree) o;

            return this.name.toLowerCase().compareTo(that.name.toLowerCase());


        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {


            String[] pairs = line.split("\\|");

            NodeTree root = new NodeTree();
            for (String pair : pairs) {
                char[] ind = pair.trim().toCharArray();

                String parentName = String.valueOf(ind[0]);
                String childName = String.valueOf(ind[1]);

                root.add(parentName, "");
                root.add(childName, parentName);


            }

            System.out.println(root.toString());
        }
    }

}
