import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    public static void main(String[] args) {
        ArrayList<Players> arrayList = new ArrayList<>();
        arrayList.add(new Players("케빈데브라위너"));
        arrayList.add(new Players("손흥민"));
        arrayList.add(new Players("베실바"));


        HashMap<String, Players> player = new HashMap<>();
        player.put("황의조", new Players("황의조"));
        player.put("조현우", new Players("조현우"));
    }
}
